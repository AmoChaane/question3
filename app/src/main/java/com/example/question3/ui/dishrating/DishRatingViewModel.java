package com.example.question3.ui.dishrating;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DishRatingViewModel extends ViewModel {

    private final MutableLiveData<String> dishName = new MutableLiveData<>();
    private final MutableLiveData<String> dishType = new MutableLiveData<>();
    private final MutableLiveData<Float> dishRating = new MutableLiveData<>();

    public DishRatingViewModel() {
        // Initialize with default values
        dishName.setValue("");
        dishType.setValue("");
        dishRating.setValue(0.0f);
    }

    public LiveData<String> getDishName() {
        return dishName;
    }
    
    public LiveData<String> getDishType() {
        return dishType;
    }
    
    public LiveData<Float> getDishRating() {
        return dishRating;
    }
    
    public void setDishName(String name) {
        dishName.setValue(name);
    }
    
    public void setDishType(String type) {
        dishType.setValue(type);
    }
    
    public void setDishRating(float rating) {
        dishRating.setValue(rating);
    }
}