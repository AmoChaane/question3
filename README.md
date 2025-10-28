# RestaurantRaterApp

A comprehensive Android application for rating dishes at restaurants, built with fragments and featuring seamless navigation using FragmentManager and FragmentTransaction.

## Features

### 1. MainActivity with Bottom Navigation
- Uses `FragmentManager` and `FragmentTransaction` for navigation
- Implements seamless switching between fragments without reloading the activity
- Bottom Navigation View with two tabs: Restaurant and Rate Dish

### 2. RestaurantFragment
- Displays restaurant name and address (hardcoded)
- Shows the latest dish rating information shared from DishRatingFragment
- Uses SharedViewModel for data communication between fragments
- Clean, user-friendly interface with rounded backgrounds

### 3. DishRatingFragment
- **EditText**: For entering dish name
- **Spinner**: For selecting dish type (Appetizer, Entrée, Main Course, Side Dish, Dessert, Beverage)
- **RatingBar**: For rating dishes from 1-5 stars (0.5 increments)
- **Button**: To submit rating and display information
- **TextView**: For displaying submitted rating information
- **Toast**: Shows confirmation when rating is submitted

### 4. Data Communication
- Uses **SharedViewModel** for seamless data sharing between fragments
- Maintains application state across fragment switches
- Real-time updates when data changes

## Technical Implementation

### Architecture
- **MVVM Pattern**: Uses ViewModels for data management
- **Fragment-based Navigation**: Uses FragmentManager instead of Navigation Component
- **Data Binding**: Uses View Binding for type-safe view references
- **LiveData**: For reactive UI updates

### Key Components
- `MainActivity`: Manages fragment transactions and bottom navigation
- `SharedViewModel`: Handles data communication between fragments
- `RestaurantFragment`: Displays restaurant information and latest ratings
- `DishRatingFragment`: Allows users to rate dishes
- Custom drawables for enhanced UI appearance

### UI Features
- Responsive design with ScrollView support
- Custom backgrounds and styling
- Real-time rating display as user interacts with RatingBar
- Input validation with user-friendly error messages
- Seamless data persistence across fragment switches

## Requirements Met
✅ MainActivity with Bottom Navigation View switching between two fragments  
✅ RestaurantFragment displaying restaurant name and address  
✅ DishRatingFragment with EditText, Spinner, RatingBar, and Button  
✅ FragmentManager and FragmentTransaction for navigation  
✅ Data sharing between fragments using SharedViewModel  
✅ Toast and TextView display of rating information  
✅ Seamless user interaction experience  

## How to Use
1. Launch the app to see the Restaurant tab with restaurant information
2. Switch to the "Rate Dish" tab using bottom navigation
3. Enter a dish name in the text field
4. Select a dish type from the dropdown spinner
5. Rate the dish using the star rating bar
6. Press "Submit Rating" to save and display the rating
7. Switch back to Restaurant tab to see the latest rating information

## Build Instructions
1. Open the project in Android Studio
2. Sync the project with Gradle files
3. Run on an Android device or emulator (API level 24+)

## Dependencies
- AndroidX AppCompat
- Material Design Components
- ConstraintLayout
- Lifecycle components (ViewModel, LiveData)
- View Binding