// -------------------------------------------------------------
// Assignment 3 Question 2 - House Class
// Written by: Anthony van Voorst, 40001890
// For COMP 248 Section P - Fall 2018
// Date: November 7, 2018
// Description: This class file contains several methods related
// to creating and changing attributes of a house or several
// houses. There are also methods to estimate the future price
// of a house, to display the attributes of a house in a string
// and to compare 2 houses' types or costs.
// -------------------------------------------------------------

import java.util.Scanner;

public class House {
	// Declaration of variables
	private int age, counter = 0;
	private String type, houseString;
	private double cost, estimate = 0;
	// Declaration of scanner
	Scanner keyboard = new Scanner(System.in);
	// Constructor for default house
	public House() {
		age = 1950;
		type = "attached";
		cost = 100000;
	}
	// Constructor for default age and type, but cost is not the default
	public House(double newCost) {
		age = 1950;
		type = "attached";
		cost = newCost;
	}
	// Constructor for default type, but cost and age are not the defaults
	public House(double newCost, int newAge) {
		age = newAge;
		type = "attached";
		cost = newCost;
	}
	// Constructor where type, age, and cost are not the defaults
	public House(double newCost, int newAge, String newType) {
		age = newAge;
		type = "detached";
		cost = newCost;
	}
	// Access Methods to return age, type, or cost
	public int getAge() {
		return age;
	}
	public String getType() {
		return type;
	}
	public double getCost() {
		return cost;
	}
	// 3 Mutator methods to change the age, type, or cost of a house
	public void changeAge(int newAge) {
		age = newAge;
	}
	public void changeType(String newType) {
		type = newType;
	}
	public void changeCost(double newCost) {
		cost = newCost;
	}
	// Mutator method to change age, type, and cost of a house
	public void changeAll(int newAge, String newType, double newCost) {
		age = newAge;
		type = newType;
		cost = newCost;
	}
	// Mutator method to change age and cost of a house
	public void changeAgeAndCost(int newAge, double newCost) {
		age = newAge;
		cost = newCost;
	}
	// Method to estimate the appreciation of a house based on its type and age.
	public double estimatePrice() {
		if (type == "attached") {
			estimate = 100000;
			if (age > 5) {
				for (counter = 1; counter <= 5; counter++) estimate = estimate + 0.01*cost;
				for (counter = 5; counter < age; counter++) estimate = estimate + 0.02*cost;
			}
			else {
				for (counter = 1; counter <= age; counter++) estimate = estimate + 0.01*cost;
			}
		}
		else if (type == "semi-detached") {
			estimate = 150000;
			if (age > 5) {
				for (counter = 1; counter <= 5; counter++) estimate = estimate + 0.02*cost;
				for (counter = 5; counter < age; counter++) estimate = estimate + 0.03*cost;
			}
			else {
				for (counter = 1; counter <= age; counter++) estimate = estimate + 0.02*cost;
			}
		}
		else if (type == "detached") {
			estimate = 200000;
			if (age > 5) {
				for (counter = 1; counter <= 5; counter++) estimate = estimate + 0.02*cost;
				for (counter = 5; counter < age; counter++) estimate = estimate + 0.02*cost;
			}
			else {
				for (counter = 1; counter <= age; counter++) estimate = estimate + 0.02*cost;
			}
		}
		else estimate = 34404;	// Error code in case the house has a non-standard type
		return estimate;
	}
	// Method that displays the attributes of a house in a single string
	public String toString() {
		houseString = "This House is type ";
		houseString = houseString.concat(type);
		houseString = houseString.concat(". Its age is ");
		houseString = houseString.concat(String.valueOf(age));
		houseString = houseString.concat(" and costs $");
		houseString = houseString.concat(String.valueOf(cost));
		houseString = houseString.concat("0");
		return houseString;
	}
	// Method to compare the type and age of 2 houses for equality
	public boolean equals(House secondHouse) {
		return type.equals(secondHouse.type) && (age == secondHouse.age);
	}
	// Method to compare the cost of 2 houses to see if the first house is less than the second house
	public boolean lessThan(House secondHouse) {
		return cost < secondHouse.cost;
	}
	// Method to compare the cost of 2 houses to see if the first house is greater than the second house
	public boolean greaterThan(House secondHouse) {
		return cost > secondHouse.cost;
	}
}
