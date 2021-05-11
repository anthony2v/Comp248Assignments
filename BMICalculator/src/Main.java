// --------------------------------------------------------
// Assignment 1 Question 2
// Written by: Anthony van Voorst, 40001890
// For COMP 248 Section P - Fall 2018
// Date: September 28, 2018
// Description: This program is a BMI calculator. It will
// take in the user's weight in kilograms and height in
// meters. It will then calculate the user's BMI and
// output it to the console.
// --------------------------------------------------------

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		double height, weight, BMI;														//Declaration of variables
		Scanner scan = new Scanner(System.in);											//Declaration of scanner
		System.out.println("Welcome to my BMI calculator.");							//Greeting to the user
		System.out.print("Please enter your weight in kilograms: ");					//Asks the user for their weight
		weight = scan.nextDouble();														//Input is assigned to "weight"
		System.out.print("Please enter your height in meters: ");						//Asks the user for their height
		height = scan.nextDouble();														//Input is assigned to "height"
		BMI = weight/(height*height);													//BMI Calculation
		System.out.println("************** BMI **************\n");						//Banner followed by a blank line
		System.out.println("Your weight:\t " + weight);									//Displays user's weight
		System.out.println("Your height:\t " + height + "\n");							//Displays user's height followed by a blank line
		System.out.println("Your BMI is:\t " + BMI + "\n");								//Displays user's BMI followed by a blank line
		System.out.println("** Thanks for using the greatest BMI calculator ever! **");	//Farewell message
		scan.close();
	}
}