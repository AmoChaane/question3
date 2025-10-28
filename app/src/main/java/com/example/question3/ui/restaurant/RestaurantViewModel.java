package com.example.question3.ui.restaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestaurantViewModel extends ViewModel {

    private final MutableLiveData<String> restaurantName = new MutableLiveData<>();
    private final MutableLiveData<String> restaurantAddress = new MutableLiveData<>();

    public RestaurantViewModel() {
        // Set default restaurant information
        restaurantName.setValue("La Bella Vista");
        restaurantAddress.setValue("123 Main Street, Downtown, City 12345");
    }

    public LiveData<String> getRestaurantName() {
        return restaurantName;
    }
    
    public LiveData<String> getRestaurantAddress() {
        return restaurantAddress;
    }
    
    public void setRestaurantName(String name) {
        restaurantName.setValue(name);
    }
    
    public void setRestaurantAddress(String address) {
        restaurantAddress.setValue(address);
    }
}