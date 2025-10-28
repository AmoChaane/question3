package com.example.question3;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.question3.databinding.ActivityMainBinding;
import com.example.question3.ui.restaurant.RestaurantFragment;
import com.example.question3.ui.dishrating.DishRatingFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SharedViewModel sharedViewModel;
    private FragmentManager fragmentManager;
    private RestaurantFragment restaurantFragment;
    private DishRatingFragment dishRatingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize shared ViewModel
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        
        // Initialize FragmentManager
        fragmentManager = getSupportFragmentManager();
        
        // Initialize fragments
        restaurantFragment = new RestaurantFragment();
        dishRatingFragment = new DishRatingFragment();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        
        // Set up bottom navigation listener
        navView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                
                if (item.getItemId() == R.id.navigation_restaurant) {
                    selectedFragment = restaurantFragment;
                } else if (item.getItemId() == R.id.navigation_dishrating) {
                    selectedFragment = dishRatingFragment;
                }
                
                if (selectedFragment != null) {
                    switchFragment(selectedFragment);
                    return true;
                }
                
                return false;
            }
        });
        
        // Load the default fragment (Restaurant)
        if (savedInstanceState == null) {
            switchFragment(restaurantFragment);
            navView.setSelectedItemId(R.id.navigation_restaurant);
        }
    }
    
    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

}