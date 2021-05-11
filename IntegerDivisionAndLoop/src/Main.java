// --------------------------------------------------------
// Assignment 2 Question 2
// Written by: Anthony van Voorst, 40001890
// For COMP 248 Section P - Fall 2018
// Date: October 15, 2018
// Description: This program will ask the user to enter
// a number of up to 7 digits. It will calculate the sum
// of each individual digit and also the divisors for the
// sum. These results will be displayed to the user. The
// user will be asked if they want to use the program 
// again and they can do so by typing "yes" as input.
// Typing "no" will close the program.
// --------------------------------------------------------

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Declare variables
		double userInput = 0, userInputCopy = 0, singleDigit = 0, inputSum = 0; 
		int counter = 0;
		String repeatString = "yes", affirmative = "yes";
		// Declare scanner
		Scanner intKeyboard = new Scanner(System.in);
		Scanner stringKeyboard = new Scanner(System.in);
		// Welcome message
		System.out.println("   Welcome to my calculator program!");
		System.out.println("---------------------------------------\n");
		while(affirmative.equals(repeatString)) {
			// Asks for and accepts user input
			System.out.print("Enter a number with at most 7 digits: ");
			userInput = intKeyboard.nextInt();
			userInputCopy = userInput;
			// Calculate sum of every digit in userInput
			for(counter = 6; counter >= 0; counter--) {
				singleDigit = (int)(userInput/(Math.pow(10, counter)));
				inputSum = inputSum + singleDigit;
				userInput = userInput-(singleDigit*(Math.pow(10, counter)));
			}
			// Displays sum as an integer
			System.out.println("The sum of the digits of " + (int)userInputCopy + " is: " + (int)inputSum);
			System.out.println();
			// Displays the divisors of the sum
			System.out.println("The divisors for " + (int)inputSum + " are as follows:");
			for(counter = 1; counter <= inputSum; counter++) {
				if(inputSum % counter == 0) System.out.print(counter + " ");
			}
			// Asks user if they'd like to try again
			System.out.print("\nDo you want to try another number? (yes to repeat, no to stop) ");
			repeatString = stringKeyboard.nextLine();
			System.out.println();
			inputSum = 0;
		}
		System.out.println("Thank you and have a great day!");
		intKeyboard.close();
		stringKeyboard.close();
	}
}
