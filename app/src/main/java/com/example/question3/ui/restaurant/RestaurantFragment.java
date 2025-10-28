package com.example.question3.ui.restaurant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.question3.SharedViewModel;
import com.example.question3.databinding.FragmentRestaurantBinding;

public class RestaurantFragment extends Fragment {

    private FragmentRestaurantBinding binding;
    private SharedViewModel sharedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        binding = FragmentRestaurantBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Get shared ViewModel from activity
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Set up UI elements
        setupUI();
        
        return root;
    }
    
    private void setupUI() {
        // Observe restaurant name and address from shared ViewModel
        sharedViewModel.getRestaurantName().observe(getViewLifecycleOwner(), name -> {
            binding.restaurantName.setText(name);
        });
        
        sharedViewModel.getRestaurantAddress().observe(getViewLifecycleOwner(), address -> {
            binding.restaurantAddress.setText(address);
        });
        
        // Display any current dish rating info if available
        sharedViewModel.getDishName().observe(getViewLifecycleOwner(), dishName -> {
            updateDishInfo();
        });
        
        sharedViewModel.getDishType().observe(getViewLifecycleOwner(), dishType -> {
            updateDishInfo();
        });
        
        sharedViewModel.getDishRating().observe(getViewLifecycleOwner(), rating -> {
            updateDishInfo();
        });
    }
    
    private void updateDishInfo() {
        String dishInfo = sharedViewModel.getFormattedDishInfo();
        if (dishInfo != null && !dishInfo.contains("No dish selected")) {
            binding.dishInfo.setText(dishInfo);
            binding.dishInfo.setVisibility(View.VISIBLE);
        } else {
            binding.dishInfo.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}