package com.example.question3.ui.dishrating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.question3.databinding.FragmentDishratingBinding;

public class DishRatingFragment extends Fragment {

    private FragmentDishratingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DishRatingViewModel dishRatingViewModel =
                new ViewModelProvider(this).get(DishRatingViewModel.class);

        binding = FragmentDishratingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDishrating;
        dishRatingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}