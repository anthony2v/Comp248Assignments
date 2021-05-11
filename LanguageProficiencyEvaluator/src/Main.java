// --------------------------------------------------------
// Assignment 2 Question 1
// Written by: Anthony van Voorst, 40001890
// For COMP 248 Section P - Fall 2018
// Date: October 15, 2018
// Description: This program will ask the user if they
// would like to know the requirements for admission or if
// they would like to calculate their scores in each area
// (listening, speaking, reading and writing). If it's the
// second case, the program will ask for the user's scores
// and calculate their overall score and determine if the
// user is admitted to Concordia, conditionally or
// otherwise.
// --------------------------------------------------------

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Declaration of variables
		int userInput = 0, studentCase = 0;
		double listeningScore = 0, speakingScore = 0, readingScore = 0, writingScore = 0, averageScore = 0;
		double scoreDecimals = 0, overallScore = 0;
		// Declaration of scanners
		Scanner intKeyboard = new Scanner(System.in);
		Scanner doubleKeyboard = new Scanner(System.in);
		// Display welcome message and input options
		System.out.println("------------------------------------------------------");
		System.out.println("Welcome to Concordia's Language Proficiency Evaluator!");
		System.out.println("\t\t(Based on IELTS Exam)");
		System.out.println("------------------------------------------------------\n");
		System.out.println("Here are the following options:");
		System.out.println("\t1 - Language proficiency requirements for the applicant");
		System.out.println("\t2 - Evaluation of your English proficiency\n");
		System.out.print("Please enter the digit corresponding to your case: ");
		userInput = intKeyboard.nextInt();
		// Case 1: Display information about the evaluator
		if(userInput == 1) {
			System.out.println("\n- The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores");
			System.out.println("for writing and reading skills should not be below 6.0. If your overall score is 6, and your");
			System.out.println("reading and writing scores are at least 6, you will be eligible for conditional admission. So");
			System.out.println("you need to take an English course in the first semester. Otherwise you have to retake the IELTS");
			System.out.println("exam.");
		}
		// Case 2: Ask for user's scores (listening, speaking, reading, writing)
		if(userInput == 2) {
			System.out.print("\nPlease enter your listening score: ");
			listeningScore = doubleKeyboard.nextDouble();
			System.out.println();
			System.out.print("Please enter your speaking score: ");
			speakingScore = doubleKeyboard.nextDouble();
			System.out.println();
			System.out.print("Please enter your reading score: ");
			readingScore = doubleKeyboard.nextDouble();
			System.out.println();
			System.out.print("Please enter your writing score: ");
			writingScore = doubleKeyboard.nextDouble();
			System.out.println();
		// Calculates the average score given the user's input
			averageScore = (listeningScore + speakingScore + readingScore + writingScore)/4;
			scoreDecimals = averageScore - (int)averageScore;
			if(scoreDecimals >= 0.250 && scoreDecimals < 0.500) overallScore = (int)averageScore + 0.5;
			else if(scoreDecimals >= 0.5) overallScore = (int)averageScore + 1;
			else overallScore = (int)averageScore;
		// Displays overall score, reading score, and writing score
			System.out.println("Your overall score is: " + overallScore);
			System.out.println("Your reading score is: " + readingScore);
			System.out.println("Your writing score is: " + writingScore);
			System.out.println();
		// Determine eligibility for admission
			if(overallScore >= 6.5 && readingScore >= 6 && writingScore >= 6) studentCase = 1;
			if(overallScore >= 6.5 && readingScore < 6 || writingScore < 6) studentCase = 2;
			if(overallScore == 6 && readingScore >= 6 && writingScore >= 6) studentCase = 3;
			if(overallScore == 6 && readingScore < 6 || writingScore < 6) studentCase = 4;
			if(overallScore < 6) studentCase = 5;
		// Display result for each case
			switch(studentCase) {
			case 1: 
				System.out.println("Congratulations, you are eligible for admission.");
				break;
			case 2:
			case 3:
				System.out.println("You are eligible for Conditional Admission.");
				break;
			case 4:
			case 5:
				System.out.println("You must retake the exam.");
				break;
			default: System.out.println("A logic error has occured.");
			}
		// Closing scanners
		intKeyboard.close();
		doubleKeyboard.close();
		}
		System.out.println("Thank you and have a nice day.");
	}
}
