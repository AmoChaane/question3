package com.example.question3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    
    // Data for sharing between fragments
    private final MutableLiveData<String> dishName = new MutableLiveData<>();
    private final MutableLiveData<String> dishType = new MutableLiveData<>();
    private final MutableLiveData<Float> dishRating = new MutableLiveData<>();
    private final MutableLiveData<String> restaurantName = new MutableLiveData<>();
    private final MutableLiveData<String> restaurantAddress = new MutableLiveData<>();
    
    public SharedViewModel() {
        // Initialize with default restaurant data
        restaurantName.setValue("La Bella Vista");
        restaurantAddress.setValue("123 Main Street, Downtown, City 12345");
    }
    
    // Dish name methods
    public void setDishName(String name) {
        dishName.setValue(name);
    }
    
    public LiveData<String> getDishName() {
        return dishName;
    }
    
    // Dish type methods
    public void setDishType(String type) {
        dishType.setValue(type);
    }
    
    public LiveData<String> getDishType() {
        return dishType;
    }
    
    // Dish rating methods
    public void setDishRating(float rating) {
        dishRating.setValue(rating);
    }
    
    public LiveData<Float> getDishRating() {
        return dishRating;
    }
    
    // Restaurant name methods
    public void setRestaurantName(String name) {
        restaurantName.setValue(name);
    }
    
    public LiveData<String> getRestaurantName() {
        return restaurantName;
    }
    
    // Restaurant address methods
    public void setRestaurantAddress(String address) {
        restaurantAddress.setValue(address);
    }
    
    public LiveData<String> getRestaurantAddress() {
        return restaurantAddress;
    }
    
    // Get formatted dish information
    public String getFormattedDishInfo() {
        String name = dishName.getValue() != null ? dishName.getValue() : "No dish selected";
        String type = dishType.getValue() != null ? dishType.getValue() : "No type selected";
        Float rating = dishRating.getValue() != null ? dishRating.getValue() : 0.0f;
        
        return String.format("Dish: %s\nType: %s\nRating: %.1f/5.0 stars", name, type, rating);
    }
}