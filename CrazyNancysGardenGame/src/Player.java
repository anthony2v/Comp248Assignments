// -------------------------------------------------------
// Assignment 4 - Player Class
// Written by: Anthony van Voorst - 40001890
// For COMP 248 Section P - Fall 2018
// Description: This class creates a player object with 
// a player's name, that player's garden, and their dice.
// -------------------------------------------------------

public class Player {
	private String playerName;
	private Dice dice;
	private Garden garden;
	// Constructor with the default garden. The size is specified in the Garden class.
	public Player(String name) {
		playerName = name;
		dice = new Dice();
		garden = new Garden();
	}
	// Constructor with a garden for the player that is bigger than or equal to 3x3.
	public Player(String name, int boardSize) {
		playerName = name;
		dice = new Dice();
		garden = new Garden(boardSize);
	}
	// Accessor to return the player's name.
	public String getPlayerName() {
		String temp = playerName;
		return temp;
	}
	// Accessor to get the current dice roll for the player.
	public int getPlayerDiceRoll() {
		int sum = dice.getFirstDie() + dice.getSecondDie();
		return sum;
	}
	// Accessor to get the sum of the player's dice
	public String getPlayerSeperateDice() {
		String statement = dice.toString();
		return statement;
	}
	// Accessor to get the possible places to plant a flower.
	public int howManyFlowersPossible() {
		int possibleFlowers = garden.countPossibleFlowers();
		return possibleFlowers;
	}
	// Accessor to get the possible places to plant a tree.
	public int howManyTreesPossible() {
		int possibleTrees = garden.countPossibleTrees();
		return possibleTrees;
	}
	// Mutator to roll the dice for the player.
	public void playerDiceRoll() {
		dice.rollDice();
	}
	// Method to see what is planted in a specific place in the garden
	public char whatIsPlanted(int row, int column) {
		char currentPlant = garden.getInLocation(row, column);
		return currentPlant;
	}
	// Method to plant a tree in the player's garden.
	public void plantTreeInGarden(int row, int column) {
		garden.plantTree(row, column);
	}
	// Method to plant a flower in the player's garden.
	public void plantFlowerInGarden(int row, int column) {
		garden.plantFlower(row, column);
	}
	// Method to remove a flower or part of a tree from the garden.
	public void eatHere(int row, int column) {
		garden.removeFlower(row, column);
	}
	// Method to check if the garden is fill completely with trees and flowers.
	public boolean isGardenFull() {
		boolean result = garden.gardenFull();
		return result;
	}
	// Method to display the player's garden
	public String showGarden() {
		String currentPlayersGarden = garden.toString();
		return currentPlayersGarden;
	}
}