// -------------------------------------------------------
// Assignment 4 - Let's Play Driver
// Written by: Anthony van Voorst - 40001890
// For COMP 248 Section P - Fall 2018
// Description: This class contains everything needed to
// a full game of Crazy Nancy's Garden Game. It contains
// all messages for the users and calls the construction
// of all the players that will be participating.
// -------------------------------------------------------

import java.util.Scanner;

public class LetsPlay {
	// Declaration of static variables, to be available to the whole program.
	public static int gardenSize = 0, playerRowChoice = 0, playerColumnChoice = 0;
	// Initialization of scanners
	static Scanner intKeyboard = new Scanner(System.in);
	static Scanner stringKeyboard = new Scanner(System.in);
	public static void main (String[] args) {
		// Declaration of variables, firstPlayer, currentPlayer and winningPlayer are indexes for the players array.
		int numberOfPlayers = 0, firstPlayer = 0, currentPlayer = 0, winningPlayer = 13, roundCounter = 1;
		boolean startOver = true;
		String playerName;
		// Welcome banner and general rules of the game.
		System.out.println("\t------****-------****-------****-------****-----****-----");
		System.out.println("\t\tWelcome to Crazy Nancy's Garden Game!");
		System.out.println("\t------****-------****-------****-------****-----****-----\n");
		System.out.println("To win this game you need some luck with the dice and a bit of strategy.");
		System.out.println("Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot. A");
		System.out.println("tree takes 4 spots (2x2).");
		System.out.println("You roll the dice and based on the outcome you get to plant a pre-set number of trees");
		System.out.println("and flowers.\n");
		System.out.println("Rolls and their outcome:");
		System.out.println("---------------------");
		System.out.println("3: plan a tree (2x2) and a flower (1x1)");
		System.out.println("6: plant 2 flowers (2 times 1x1)");
		System.out.println("12: plant 2 trees (2 times 2x2)");
		System.out.println("5 or 10: the rabbit will eat something that you have planted - might be a flower or part of a tree(1x1)");
		System.out.println("Any other EVEN rolls: plant a tree (2x2)");
		System.out.println("Any other ODD rolls: plant a flower (1x1)\n");
		System.out.println("Number of players: 2-10.");
		System.out.println("Minimum garden size: 3x3.");
		System.out.println("You can only plant in empty locations. To plant a tree you give the top left coordinates");
		System.out.println("of the 2x2 space and I will check to make sure all 4 locations are free.");
		System.out.println("Okay ... Let's start the game! May the best gardener win!!!\n");
		System.out.println("The default garden size is a 3x3 square. You can use this default board size or change the size.");
		System.out.print("Enter 0 to use the default garden size or -1 to enter your own size: ");
		// Takes user input and doesn't continue until valid options, garden sizes, and number of players have been specified.
		gardenSize = intKeyboard.nextInt();
		while(gardenSize != 0 && gardenSize != -1) {
			System.out.print("Sorry, but " + gardenSize + " is not a legal choice. Enter a new choice: ");
			gardenSize = intKeyboard.nextInt();
		}
		if (gardenSize == -1) {
			System.out.print("What size board would you like (minimum size 3)? ");
			gardenSize = intKeyboard.nextInt();
			while(gardenSize < 3) {
				System.out.print("Sorry, but " + gardenSize + " is not a legal choice. Enter a new choice (minimum size 3): ");
				gardenSize = intKeyboard.nextInt();
			}
		}
		else gardenSize = 3;
		System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
		numberOfPlayers = intKeyboard.nextInt();
		while(numberOfPlayers < 2 || numberOfPlayers > 10) {
			System.out.println("** Sorry but " + numberOfPlayers + " is not a legal number of players.");
			System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
			numberOfPlayers = intKeyboard.nextInt();
		}
		System.out.println("Great, " + numberOfPlayers + " players it will be!\n");
		// Constructs 2-10 players with a specified/default board size.
		Player[] players = new Player[numberOfPlayers];
		for(int i = 1; i <= numberOfPlayers; i++) {
			System.out.print("--> Name of player " + i + " (no spaces allowed): ");
			playerName = stringKeyboard.next();
			if(gardenSize == 0) players[i-1] = new Player(playerName);
			else players[i-1] = new Player(playerName, gardenSize);
		}
		// Determines which player goes first. If 2 players roll the same sum then everyone must roll again.
		System.out.println("\nLet's see who goes first...");
		while(startOver) {
			for(int i = 0; i < numberOfPlayers; i++) {
				players[i].playerDiceRoll();
				System.out.println(players[i].getPlayerName() + " rolled a " + players[i].getPlayerDiceRoll());
				for(int j = 0; j < i; j++) {
					if (players[j].getPlayerDiceRoll() == players[i].getPlayerDiceRoll()) {
						System.out.println("We will start over as " + players[j].getPlayerDiceRoll() + " was rolled by " + players[j].getPlayerName() + 
								" as well.\n");
						i = numberOfPlayers;
						j = numberOfPlayers;
						startOver = true;
					}
					else startOver = false;
				}
			}
		}
		// Once everyone rolls, the dice rolls are compared to see who goes first.
		for(int i = 0; i < numberOfPlayers-1; i++) {
			if (players[i].getPlayerDiceRoll() > players[i+1].getPlayerDiceRoll()) firstPlayer = i;
		}
		System.out.println(players[firstPlayer].getPlayerName() + " goes first.\n");
		System.out.println("Time to play!!!");
		System.out.println("------------------\n");
		// The while loop is a single turn for each player. Once a player fills their garden completely, the program will exit the loop.
		currentPlayer = firstPlayer;
		while(winningPlayer == 13) {
			playersTurn(players[currentPlayer]);
			if(players[currentPlayer].isGardenFull()) winningPlayer = currentPlayer;
			if(currentPlayer == numberOfPlayers-1) currentPlayer = 0;
			else currentPlayer++;
			roundCounter++;
			System.out.println();
		}
		// Displays the final results, including each player's garden as well as declaring the winner.
		System.out.println("FINAL RESULTS\n-------------");
		System.out.println("Here are the results after " + roundCounter + " rounds.");
		for(int k = 0; k < numberOfPlayers; k++) {
			System.out.println(players[k].getPlayerName() + "'s Garden\n\n" + players[k].showGarden());
		}
		System.out.print("And the winner is... " + players[winningPlayer].getPlayerName() + "!!!\nWhat a beautiful garden you have!\n\nHope you had fun!");
		intKeyboard.close();
		stringKeyboard.close();
	}
	// Uses the dice roll method and determines what a player can do during their turn. 
	public static void playersTurn(Player players) {
		players.playerDiceRoll();
		System.out.println(players.getPlayerName() + ", you rolled " + players.getPlayerDiceRoll() + " " + players.getPlayerSeperateDice());
		// Perform an action on the player's garden using switch. 
		switch(players.getPlayerDiceRoll()) {
			case 3:
				// The player can plant a tree and a flower. It will break out of the case if the players's garden is full after planting the tree.
				System.out.println("You must plant a tree (2x2) and a flower (1x1).\n\n" + players.showGarden());
				System.out.println("Let's start with the tree. You have " + players.howManyTreesPossible() + " places to do this.");
				if(players.howManyTreesPossible() > 0) plantTreeDuringTurn(players);
				else System.out.println("** Sorry, no room to plant a tree!");
				if(players.howManyFlowersPossible() == 0) break;
				System.out.println("You still have a flower (1x1) to plant.\n\n" + players.showGarden());
				System.out.println("You now have " + players.howManyFlowersPossible() + " places to do this.");
				plantFlowerDuringTurn(players);
				break;
			case 6:
				// The player can plant 2 flowers. It will break out of the case if the player's garden is full after planting the first flower.
				System.out.println("You must plant 2 flowers (1x1).\n\n" + players.showGarden());
				System.out.println("Let's start with the first flower. You have " + players.howManyFlowersPossible() + " places to do this.");
				plantFlowerDuringTurn(players);
				if(players.howManyFlowersPossible() == 0) break;
				System.out.println("You have 1 more flower (1x1) to plant.\n\n" + players.showGarden());
				System.out.println("You now have " + players.howManyFlowersPossible() + " places to do this.");
				plantFlowerDuringTurn(players);
				break;
			case 12:
				// The player can plant 2 trees. It will break out of the case if the player's garden is full after the planting the first flower.
				System.out.println("You must plant 2 trees (2x2).\n\n" + players.showGarden());
				System.out.println("Let's start with the first tree. You have " + players.howManyTreesPossible() + " places to do this.");
				if(players.howManyTreesPossible() > 0) plantTreeDuringTurn(players);
				else System.out.println("** Sorry, no room to plant a tree! You miss a turn.");
				if(players.howManyFlowersPossible() == 0) break;
				System.out.println("You still have another tree to plant.\n\n" + players.showGarden());
				System.out.println("You now have " + players.howManyTreesPossible() + " places to do this.");
				if(players.howManyTreesPossible() > 0) plantTreeDuringTurn(players);
				else System.out.println("** Sorry, no room to plant a tree! You miss a turn.");
				break;
			case 5:
			case 10:
				// Checks first to see if there's anything in the garden that the rabbit can eat.
				if(gardenSize * gardenSize == players.howManyFlowersPossible()) {
					System.out.println("The rabbit is supposed to eat a plant, but nothing is planted!");
				}
				else {
					// Finds a non-empty ('-') space so that the rabbit can eat its contents.
					playerRowChoice = (int)(Math.random()*gardenSize);
					playerColumnChoice = (int)(Math.random()*gardenSize);
					while(players.whatIsPlanted(playerRowChoice, playerColumnChoice) == '-') {
						playerRowChoice = (int)(Math.random()*gardenSize);
						playerColumnChoice = (int)(Math.random()*gardenSize);
					}
					System.out.println("\n" + players.showGarden());
					System.out.println("The rabbit ate whatever was planted in location (" + playerRowChoice + ", " + playerColumnChoice + ")");
					players.eatHere(playerRowChoice, playerColumnChoice);
					System.out.print("\n" + players.showGarden());
				}
				break;
			case 2:
			case 4:
			case 8:
				// The player can plant a tree. They will miss a turn if there's no space to plant one.
				System.out.println("You must plant a tree (2x2).\n\n" + players.showGarden());
				System.out.println("You have " + players.howManyTreesPossible() + " places to do this.");
				if(players.howManyTreesPossible() > 0) plantTreeDuringTurn(players);
				else System.out.println("** Sorry, no room to plant a tree! You miss a turn.");
				break;
			case 7:
			case 9:
			case 11:
				// The player can plant a flower.
				System.out.println("You must plant flower (1x1).\n\n" + players.showGarden());
				System.out.println("You have " + players.howManyFlowersPossible() + " places to do this.");
				plantFlowerDuringTurn(players);
				break;
			default: System.out.println("Error");
		}
	}
	// Static method to plant flowers on a legal space in a player's garden.
	public static void plantFlowerDuringTurn(Player players) {
		System.out.print("Enter coordinates as row column: ");
		playerRowChoice = intKeyboard.nextInt();
		playerColumnChoice = intKeyboard.nextInt();
		// The while loop checks to make sure the 1x1 space is empty and that the flower won't go out of bounds.
		while((playerRowChoice+1 > gardenSize || playerColumnChoice+1 > gardenSize) || (players.whatIsPlanted(playerRowChoice, playerColumnChoice) != '-')) {
			System.out.println("** Sorry, that location is already taken up by a plant or the flower will be out of bounds.");
			System.out.print("Please enter a new set of coordinates as row column: ");
			playerRowChoice = intKeyboard.nextInt();
			playerColumnChoice = intKeyboard.nextInt();
		}
		players.plantFlowerInGarden(playerRowChoice, playerColumnChoice);
	}
	// Static method to plant trees on a legal 2x2 space in a player's garden.
	public static void plantTreeDuringTurn(Player players) {
		System.out.print("Enter coordinates as row column: ");
		playerRowChoice = intKeyboard.nextInt();
		playerColumnChoice = intKeyboard.nextInt();
		// The while loop checks to make sure the 2x2 space is empty and that the tree won't go out of bounds.
		while((playerRowChoice+1 >= gardenSize || playerColumnChoice+1 >= gardenSize) || (players.whatIsPlanted(playerRowChoice, playerColumnChoice) != '-' || 
				players.whatIsPlanted(playerRowChoice, playerColumnChoice) != '-' || players.whatIsPlanted(playerRowChoice, playerColumnChoice) != '-' || 
				players.whatIsPlanted(playerRowChoice, playerColumnChoice) != '-')) {
			System.out.println("** Sorry, that location is already taken up by a plant or the tree will be out of bounds.");
			System.out.print("Please enter a new set of coordinates as row column: ");
			playerRowChoice = intKeyboard.nextInt();
			playerColumnChoice = intKeyboard.nextInt();
		}
		players.plantTreeInGarden(playerRowChoice, playerColumnChoice);
	}
}