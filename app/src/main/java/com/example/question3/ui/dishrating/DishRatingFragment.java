package com.example.question3.ui.dishrating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.question3.SharedViewModel;
import com.example.question3.databinding.FragmentDishratingBinding;

public class DishRatingFragment extends Fragment {

    private FragmentDishratingBinding binding;
    private SharedViewModel sharedViewModel;
    private String[] dishTypes = {"Select dish type", "Appetizer", "Entrée", "Main Course", "Side Dish", "Dessert", "Beverage"};
    private String selectedDishType = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        binding = FragmentDishratingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Get shared ViewModel from activity
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        setupUI();
        
        return root;
    }
    
    private void setupUI() {
        // Set up spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), 
            android.R.layout.simple_spinner_item, dishTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerDishType.setAdapter(adapter);
        
        binding.spinnerDishType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) { // Skip the "Select dish type" option
                    selectedDishType = dishTypes[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedDishType = "";
            }
        });
        
        // Set up button click listener
        binding.buttonSubmitRating.setOnClickListener(v -> submitRating());
        
        // Set up rating bar listener to update display in real-time
        binding.ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                binding.textCurrentRating.setText(String.format("Current Rating: %.1f/5.0", rating));
                binding.textCurrentRating.setVisibility(View.VISIBLE);
            }
        });
        
        // Load existing data if available
        loadExistingData();
    }
    
    private void loadExistingData() {
        // Load existing dish name
        sharedViewModel.getDishName().observe(getViewLifecycleOwner(), dishName -> {
            if (dishName != null && !dishName.isEmpty() && !dishName.equals("No dish selected")) {
                binding.editTextDishName.setText(dishName);
            }
        });
        
        // Load existing dish type
        sharedViewModel.getDishType().observe(getViewLifecycleOwner(), dishType -> {
            if (dishType != null && !dishType.isEmpty() && !dishType.equals("No type selected")) {
                for (int i = 0; i < dishTypes.length; i++) {
                    if (dishTypes[i].equals(dishType)) {
                        binding.spinnerDishType.setSelection(i);
                        selectedDishType = dishType;
                        break;
                    }
                }
            }
        });
        
        // Load existing rating
        sharedViewModel.getDishRating().observe(getViewLifecycleOwner(), rating -> {
            if (rating != null && rating > 0) {
                binding.ratingBar.setRating(rating);
                binding.textCurrentRating.setText(String.format("Current Rating: %.1f/5.0", rating));
                binding.textCurrentRating.setVisibility(View.VISIBLE);
            }
        });
    }
    
    private void submitRating() {
        String dishName = binding.editTextDishName.getText().toString().trim();
        float rating = binding.ratingBar.getRating();
        
        // Validate input
        if (dishName.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a dish name", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (selectedDishType.isEmpty() || selectedDishType.equals("Select dish type")) {
            Toast.makeText(requireContext(), "Please select a dish type", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (rating == 0) {
            Toast.makeText(requireContext(), "Please provide a rating", Toast.LENGTH_SHORT).show();
            return;
        }
        
        // Save data to shared ViewModel
        sharedViewModel.setDishName(dishName);
        sharedViewModel.setDishType(selectedDishType);
        sharedViewModel.setDishRating(rating);
        
        // Display the rating information
        String ratingInfo = String.format(
            "Rating Submitted!\n\nDish: %s\nType: %s\nRating: %.1f/5.0 stars\n\nThank you for your feedback!",
            dishName, selectedDishType, rating
        );
        
        // Show in TextView
        binding.textRatingDisplay.setText(ratingInfo);
        binding.textRatingDisplay.setVisibility(View.VISIBLE);
        
        // Also show as Toast
        Toast.makeText(requireContext(), 
            String.format("Rating saved: %s (%.1f★)", dishName, rating), 
            Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}