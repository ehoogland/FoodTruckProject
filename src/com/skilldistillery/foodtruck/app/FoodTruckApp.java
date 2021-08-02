/**
 * Lessons
 * 
 * Array is created in the FoodTruck app, not the FoodTruck class
 * 
 */
package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	private static Scanner scanner = new Scanner(System.in);

	private static final int MAX_TRUCKS = 5;

	FoodTruck[] trucks = new FoodTruck[MAX_TRUCKS];

	public static void main(String[] args) {

		// create instance
		FoodTruckApp fta = new FoodTruckApp();

		fta.greeting();
		
		fta.createTrucks();

		fta.menu();

	}

	private final void greeting() {
		System.out.println("*********************************************");
		System.out.println();
		System.out.print("*************");

		System.out.print(" Greetings, Truckers ");
		System.out.println("***********");
		System.out.println();
		System.out.println("        Weigh In On Up To " + MAX_TRUCKS + " Food Trucks!");
		System.out.println();

		System.out.println("*********************************************");
		System.out.println("\n");
	}

	public void createTrucks() {
		for (int truckID = 0; truckID < MAX_TRUCKS; truckID++) {

			System.out.println("Enter food truck name: ");
			System.out.println("(To exit or finish truck reviews, enter 'quit'.)");
			String name = scanner.nextLine();

			if (name.equalsIgnoreCase("quit") || name.equalsIgnoreCase("q")) {
				System.out.println("Finished any entries. Keep on truckin' !");
				break;

			}
			System.out.println("Enter type of food: ");
			String foodType = scanner.nextLine();

			System.out.print("Enter your rating, from one to one hundred. ");
			System.out.println("Decimals are allowed: ");

			double rating = scanner.nextDouble();

			if (rating < 1 || rating > 100) {

				System.out.println("Your rating must be between 1 and 5, inclusive");
				rating = scanner.nextDouble();
			}

			scanner.nextLine();
			FoodTruck truck = new FoodTruck(name, foodType, rating);
			trucks[truckID] = truck;

		}
	}

	private void menu() {
		int choice = 0;
		while (choice != 4) {
			choice = displayMenu();
			switch (choice) {
			case 1:
				displayFoodTrucks();
				break;
			case 2:
				calculateAverage();
				break;
			case 3:
				highestRated();
				break;
			case 4:
				System.out.println("Thanks for visiting!");
				break;
			default:
				System.err.println("Error: Input Not Valid");
				break;
			}
		}
	}

	// Menu method displays the options and accepts/returns the choice
	private int displayMenu() {
		System.out.println("---------MENU----------");
		System.out.println("1. Show food trucks");
		System.out.println("2. Show average rating");
		System.out.println("3. Show highest-rated truck");
		System.out.println("4. Quit");
		System.out.println("-----------------------");
		
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}

	private void displayFoodTrucks() {

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				System.out.println("Truck " + (i + 1));
				System.out.println(trucks[i].toString());
				System.out.println("----------------------");
			}
		}
	}
    // TODO: When there are no trucks to average
	// NaN is displayed
	public void calculateAverage() {
		int ratingsTotal = 0;
		int count = 0;

		for (int i = 0; i < trucks.length; i++) {
			FoodTruck foodTruck = trucks[i];
			if (foodTruck != null) {
				ratingsTotal += foodTruck.getRating();
				count++;
			}
		}

		double average = (double) ratingsTotal / count;

		System.out.println("The average rating of all your trucks is: " + average);
	}
	// TODO: disambiguate ties
	public void highestRated() {
		
		FoodTruck prior = trucks[0];

		FoodTruck highest = trucks[0];

		for (int i = 0; i < trucks.length; i++) {
			FoodTruck foodTruck = trucks[i];
			if (foodTruck != null) {
				if (prior.getRating() > (trucks[i].getRating())) {
					prior = trucks[i];
				}
				if (highest.getRating() < trucks[i].getRating()) {
					highest = trucks[i];
				}
			}
		}
		System.out.println("The highest-rated truck is:\n" + highest);
	}

}
