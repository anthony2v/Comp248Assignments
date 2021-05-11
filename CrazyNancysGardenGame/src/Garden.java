// -------------------------------------------------------
// Assignment 4 - Garden Class
// Written by: Anthony van Voorst - 40001890
// For COMP 248 Section P - Fall 2018
// Description: This class creates a garden object with
// a single attribute: a 2-D character array. Each
// location will contain 1 of 3 characters: 'f', 't', or
// '-' which are flowers, trees, and blank spaces
// respectively.
// -------------------------------------------------------

public class Garden {
	private char[][] gardenLayout;
	private static int size = 0;
	// Constructs a default garden of at least 3x3 spaces using a 2-D array.
	public Garden() {
		gardenLayout = new char[3][3];
		size = 3;
		initializeGarden(gardenLayout);
	}
	// Constructs a garden with a custom amount of spaces using a 2-D array.
	public Garden(int gardenSize) {
		gardenLayout = new char[gardenSize][gardenSize];
		size = gardenSize;
		initializeGarden(gardenLayout);
	}
	// Used by the constructors to make every space in the garden '-' (blank).
	private void initializeGarden(char[][] array) {
		for(int row = 0; row < size; row++) {
			for(int column = 0; column < size; column++) {
				array[row][column] = '-';
			}
		}
	}
	// Returns the character stored at the specified location of the array.
	public char getInLocation(int row, int column) {
		char location = gardenLayout[row][column];
		return location;
	}
	// Mutator to plant a flower (1x1) in the array.
	public void plantFlower(int row, int column) {
		gardenLayout[row][column] = 'f';
	}
	// Mutator to plant a tree (2x2) in the array.
	public void plantTree(int row, int column) {
		gardenLayout[row][column] = 't';
		gardenLayout[row+1][column] = 't';
		gardenLayout[row][column+1] = 't';
		gardenLayout[row+1][column+1] = 't';
	}
	// Mutator to remove a flower from the array
	public void removeFlower(int row, int column) {
		gardenLayout[row][column] = '-';
	}
	// Method to return the amount of possible places to plant a tree.
	public int countPossibleTrees() {
		int possibleTrees = 0;
		for(int row = 0; row < size-1; row++) {
			for(int column = 0; column < size-1; column++) {
				if (gardenLayout[row][column] == '-' && gardenLayout[row+1][column] == '-' &&
						gardenLayout[row][column+1] == '-' && gardenLayout[row+1][column+1] == '-') {
				possibleTrees++;
				}
			}
		}
		return possibleTrees;
	}
	// Method to return the amount of possible places to plant a flowers.
	public int countPossibleFlowers() {
		int possibleFlowers = 0;
		for(int row = 0; row < size; row++) {
			for(int column = 0; column < size; column++) {
				if (gardenLayout[row][column] == '-') {
					possibleFlowers++;
				}
			}
		}
		return possibleFlowers;
	}
	// Method to see if the player's garden is filled completely with trees and flowers. Returns false otherwise.
	public boolean gardenFull() {
		int population = 0;
		for(int row = 0; row < size; row++) {
			for(int column = 0; column < size; column++) {
				if (gardenLayout[row][column] == 't' || gardenLayout[row][column] == 'f') {
					population++;
				}
			}
		}
		if (population == size * size) return true;
		else return false;
	}
	// toString() to display the player's garden as a Size x Size square.
	public String toString() {
		String gardenStatus = " ";
		for(int row = 0; row <= size; row++) {
			if (row == 0) gardenStatus = gardenStatus + " | ";
			else gardenStatus = gardenStatus + (row-1) + " | ";
			for(int column = 0; column < size; column++) {
				if (row == 0) gardenStatus = gardenStatus + column + " ";
				else gardenStatus = gardenStatus + gardenLayout[row-1][column] + " ";
			}
			gardenStatus = gardenStatus + "\n";
		}
		return gardenStatus;
	}
}