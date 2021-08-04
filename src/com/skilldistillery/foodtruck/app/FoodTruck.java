package com.skilldistillery.foodtruck.app;

/*
 * When a FoodTruck is created, its constructor assigns its
 * id field the current value of a static field (such as (nextTruckId) 
 * and then increments the static field.
 */
public class FoodTruck {

	private static int nextTruckID = 1; // static Food Truck field
	private int truckID;
	private String name;
	private String foodType;
	private double rating;

	public FoodTruck(String name, String foodType, double rating) {

		truckID = nextTruckID++;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}
	public int getTruckID() {
		return truckID;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void displayTruck() {
		String truckInfo = this.toString();
		System.out.println(truckInfo);
	}
	
	@Override
	public String toString() {
		return "Food Truck ID: " + truckID + "\nFood Truck Name: " + name
				+ "\nFood Type: " + foodType + "\nFood Truck Rating: " + rating + "\n";

	}

}
