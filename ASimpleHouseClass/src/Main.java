// -------------------------------------------------------------
// Assignment 3 Question 2 - Main
// Written by: Anthony van Voorst, 40001890
// For COMP 248 Section P - Fall 2018
// Date: November 7, 2018
// Description: The main class of this program. It contains test
// code to verify that the House class and its methods are
// functioning properly.
// -------------------------------------------------------------

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello, this is a test program to verify the functionality of the House Class file.");
		System.out.println("----------------------------------------------");
		// Declaration of 4 house objects using the 4 different constructors
		House H1 = new House();
		House H2 = new House(100000);
		House H3 = new House(120000, 4);
		House H4 = new House(220000, 2, "Detached");
		// Testing output of the description of each house
		System.out.print("House H1: ");
		System.out.println(H1.toString());
		System.out.print("House H2: ");
		System.out.println(H2.toString());
		System.out.print("House H3: ");
		System.out.println(H3.toString());
		System.out.print("House H4: ");
		System.out.println(H4.toString());
		// Testing of the accessor methods
		System.out.println();
		System.out.print("Accessor Method: The housetype for House H4 is " + H4.getType() + ", its age is " + H4.getAge() + ", and it costs $");
		System.out.printf("%.2f\n", H4.getCost());
		// Testing the getEstimate() method
		System.out.println();
		System.out.printf("The estimated price of House H3 is $%.2f\n", H3.estimatePrice());
		System.out.printf("The estimated price of House H4 is $%.2f\n", H4.estimatePrice());
		// Testing the mutator methods
		System.out.println();
		H3.changeAge(5);
		System.out.println("Mutator Method: The new age for house H3 is " + H3.getAge());
		H3.changeType("Semi-detached");
		System.out.println("Mutator Method: The new housetype for house H3 is " + H3.getType());
		H3.changeCost(240000);
		System.out.printf("Mutator Method: The new house cost for house H3 is $%.2f\n", H3.getCost());
		H3.changeAgeAndCost(6, 245000);
		System.out.printf("Mutator Method: The new house H3 age is %d and its new cost is $%.2f\n", H3.getAge(), H3.getCost());
		H3.changeAll(14, "semi-detached", 260000);
		System.out.printf("Mutator Method: The new housetype for house H3 is %s, its new age is %d and its cost is $%.2f\n", H3.getType(), H3.getAge(), H3.getCost());
		// Testing the toString method
		System.out.println();
		System.out.println("toString: " + H3.toString());
		// Testing the equals method to compare types and ages between 2 houses
		System.out.println();
		System.out.println("Houses H1 and H2 are equal is " + H1.equals(H2));
		System.out.println("Houses H1 and H4 are equal is " + H1.equals(H4));
		// Testing the less than and greater than method to compare the prices between 2 houses
		System.out.println();
		System.out.println("House H4 is less than H3 is " + H4.lessThan(H3));
		System.out.println();
		System.out.println("House H1 is greater than H3 is " + H1.greaterThan(H3));
		// Closing message
		System.out.println("----------------------------------------------");
		System.out.println("Test complete, please verify the results. Thank you and have a great day.");
	}

}
