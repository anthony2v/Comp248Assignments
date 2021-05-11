// -------------------------------------------------------
// Assignment 4 - Dice Class
// Written by: Anthony van Voorst - 40001890
// For COMP 248 Section P - Fall 2018
// Description: This class creates a dice object to be
// used in a game. There are 2 attributes for each die.
// -------------------------------------------------------

public class Dice {
	private int firstDie, secondDie;
	// Constructor to create an object of 2 dice with initial value of 0.
	public Dice() {
		firstDie = 0;
		secondDie = 0;
	}
	// Accessor method to get the value of the first die.
	public int getFirstDie() {
		int dieNumber = firstDie;
		return dieNumber;
	}
	// Accessor method to get the value of the second die.
	public int getSecondDie() {
		int dieNumber = secondDie;
		return dieNumber;
	}
	// Method to roll the dice and return the sum of the two dice.
	public int rollDice() {
		firstDie = (int)(1 + Math.random()*6);
		secondDie = (int)(1 + Math.random()*6);
		int sumOfDice = firstDie + secondDie;
		return sumOfDice;
	}
	// Method to return the amounts of the dice in a string.
	public String toString() {
		String diceAmounts = "(Die 1: " + firstDie + " Die 2: " + secondDie + ")";
		return diceAmounts;
	}
}