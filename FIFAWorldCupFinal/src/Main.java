// -------------------------------------------------------------
// Assignment 3 Question 1
// Written by: Anthony van Voorst, 40001890
// For COMP 248 Section P - Fall 2018
// Date: November 7, 2018
// Description: This is a simulated series of soccer tournaments
// based on the FIFA World Cup. The user enters their favorite
// soccer team and the program starts if that team is in the
// predefined list. There are 4 rounds: preliminary, quarter-
// finals, semi-finals and the winning game. In each round, the
// scores for each game are determined randomly between 0 and 4.
// Sudden death matches will occur in the event of a tie to
// determine the winning team. The tournaments stop when the
// user's favorite team wins the tournament or when the maximum
// number of tournaments have taken place. A message is 
// displayed if the user's team didn't win any tournament. A
// table containing all the goal statistics for each tournament
// is displayed afterwards.
// -------------------------------------------------------------

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Declaration of variables
		String userInput = "";
		int teamCounter = 0, scoreCounter = 0, tournamentCounter = 0, suddenDeathResult = 0, 
				statisticsCounter = 1, tournamentStatisticsCounter = 0, aboveAverageMatches = 0;
		boolean teamComparison = false;
		String winningTeam = "whatever";
		double totalTournamentGoals = 0, totalAverageGoals = 0;
		// Declaration of constants
		final int TOURNAMENT_COUNTER_MAXIMUM = 20;
		// Declaration of arrays
		String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil",
				"Mexico", "Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark",
				"Sweden", "Switzerland", "Colombia", "England"};
		String[] teams8 = new String[8], teams4 = new String[4], teams2 = new String[2];
		int[] roundOneScores = new int[16], quarterFinalScores = new int[8],
				semiFinalScores = new int[4], finalScores = new int[2];
		// goalStatistics contains the tournament number, total goals for each game in the tournament, and the average goals for the tournament
		double[][] goalStatistics = new double[TOURNAMENT_COUNTER_MAXIMUM][17];
		// Declaration of scanner
		Scanner stringKeyboard = new Scanner(System.in);
		// Welcome message and asks for user input
		System.out.println("******* Welcome to my FIFA World Soccer Tournament Program! *******");
		System.out.print("Please enter your favourite team: ");
		userInput = stringKeyboard.nextLine();
		System.out.println();
		// Compares the userInput string with every team in the teams16 array to see if their team is part of the tournament.
		for (teamCounter = 0; teamCounter < teams16.length; teamCounter++) {
			if (teamComparison == false)
				teamComparison = userInput.equalsIgnoreCase(teams16[teamCounter]);
		}
		// Ends the program if the user's team is not part of the lineup
		if (teamComparison == false) {
			System.out.println("Your team is not in the round of 16.\n");
			System.out.println("Thank you and have a nice day.");
			stringKeyboard.close();
			return;
		}
		// Starts the tournament if the user's team is in the array, the loop quits if the maximum tournament limit is reached or if the user's team wins the tournament.
		while (teamComparison && tournamentCounter < TOURNAMENT_COUNTER_MAXIMUM && !(userInput.equalsIgnoreCase(winningTeam))) {
			totalTournamentGoals = 0;
			goalStatistics[tournamentCounter][0] = tournamentCounter;
			statisticsCounter = 1;
			System.out.print("ROUND OF 16 ");
			for (scoreCounter = 0; scoreCounter <= 15; scoreCounter++) {
				// Determines random score in roundOneScores for each team, but converts the range from [0.0-1.0) to [0-5).
				roundOneScores[scoreCounter] = (int)(Math.random()*5);
				// Checks for the winning team after every 2 scores are determined, it's a sudden death if there's a tie.
				if(scoreCounter % 2 != 0) {
					if (roundOneScores[scoreCounter - 1] > roundOneScores[scoreCounter]) teams8[scoreCounter/2] = teams16[scoreCounter - 1];
					else if (roundOneScores[scoreCounter - 1] < roundOneScores[scoreCounter]) teams8[scoreCounter/2] = teams16[scoreCounter];
					// Sudden death period
					else {
						// Determines at random which team scores in the sudden death period, and increments that team's score by one
						suddenDeathResult = scoreCounter - (int)(Math.random()*2);
						roundOneScores[suddenDeathResult]++;
						teams8[scoreCounter/2] = teams16[suddenDeathResult];
					}
					// Places the total goals from the current game and puts it into goalStatistics
					goalStatistics[tournamentCounter][statisticsCounter] = roundOneScores[scoreCounter - 1] + roundOneScores[scoreCounter];
					statisticsCounter++;
					System.out.print("[" + teams16[scoreCounter - 1] + " " + roundOneScores[scoreCounter - 1] + ":" + roundOneScores[scoreCounter] + " " + teams16[scoreCounter] + "]");
				}
			}
			System.out.print("\nQUARTER-FINALS ");
			for (scoreCounter = 0; scoreCounter <= 7; scoreCounter++) {
				// Put random score in quarterFinalScores for each team, but converts the range from [0.0-1.0) to [0-5).
				quarterFinalScores[scoreCounter] = (int)(Math.random()*5);
				// Checks for the winning team after every 2 scores are determined, it's a sudden death if there's a tie.
				if(scoreCounter % 2 != 0) {
					if (quarterFinalScores[scoreCounter - 1] > quarterFinalScores[scoreCounter]) teams4[scoreCounter/2] = teams8[scoreCounter - 1];
					else if (quarterFinalScores[scoreCounter - 1] < quarterFinalScores[scoreCounter]) teams4[scoreCounter/2] = teams8[scoreCounter];
					// Sudden death period
					else {
						// Determines at random which team scores in the sudden death period, and increments that team's score by one
						suddenDeathResult = scoreCounter - (int)(Math.random()*2);
						quarterFinalScores[suddenDeathResult]++;
						teams4[scoreCounter/2] = teams8[suddenDeathResult];
					}
					// Places the total goals from the current game and puts it into goalStatistics
					goalStatistics[tournamentCounter][statisticsCounter] = quarterFinalScores[scoreCounter - 1] + quarterFinalScores[scoreCounter];
					statisticsCounter++;
					System.out.print("[" + teams8[scoreCounter - 1] + " " + quarterFinalScores[scoreCounter - 1] + ":" + quarterFinalScores[scoreCounter] + " " + teams8[scoreCounter] + "]");
				}
			}
			System.out.print("\nSEMI-FINALS ");
			for (scoreCounter = 0; scoreCounter <= 3; scoreCounter++) {
				// Put random score in quarterFinalScores for each team, but converts the range from [0.0-1.0) to [0-5).
				semiFinalScores[scoreCounter] = (int)(Math.random()*5);
				// Checks for the winning team after every 2 scores are determined, it's a sudden death if there's a tie.
				if(scoreCounter % 2 != 0) {
					if (semiFinalScores[scoreCounter - 1] > semiFinalScores[scoreCounter]) teams2[scoreCounter/2] = teams4[scoreCounter - 1];
					else if (semiFinalScores[scoreCounter - 1] < semiFinalScores[scoreCounter]) teams2[scoreCounter/2] = teams4[scoreCounter];
					// Sudden death period
					else {
						// Determines at random which team scores in the sudden death period, and increments that team's score by one
						suddenDeathResult = scoreCounter - (int)(Math.random()*2);
						semiFinalScores[suddenDeathResult]++;
						teams2[scoreCounter/2] = teams4[suddenDeathResult];
					}
					// Places the total goals from the current game and puts it into goalStatistics
					goalStatistics[tournamentCounter][statisticsCounter] = semiFinalScores[scoreCounter - 1] + semiFinalScores[scoreCounter];
					statisticsCounter++;
					System.out.print("[" + teams4[scoreCounter - 1] + " " + semiFinalScores[scoreCounter - 1] + ":" + semiFinalScores[scoreCounter] + " " + teams4[scoreCounter] + "]");
				}
			}
			System.out.print("\nFINAL ");
			for (scoreCounter = 0; scoreCounter <= 1; scoreCounter++) {
				// Put random score in quarterFinalScores for each team, but converts the range from [0.0-1.0) to [0-5).
				finalScores[scoreCounter] = (int)(Math.random()*5);
				if(scoreCounter % 2 != 0) {
					// Checks for the winning team after every 2 scores are determined, it's a sudden death if there's a tie.
					if (finalScores[scoreCounter - 1] > finalScores[scoreCounter]) winningTeam = teams2[scoreCounter - 1];
					else if (finalScores[scoreCounter - 1] < finalScores[scoreCounter]) winningTeam = teams2[scoreCounter];
					// Sudden death period
					else {
						// Determines at random which team scores in the sudden death period, and increments that team's score by one
						suddenDeathResult = scoreCounter - (int)(Math.random()*2);
						finalScores[suddenDeathResult]++;
						winningTeam = teams2[suddenDeathResult];
					}
					// Places the total goals from the current game and puts it into goalStatistics
					goalStatistics[tournamentCounter][statisticsCounter] = finalScores[scoreCounter - 1] + finalScores[scoreCounter];
					statisticsCounter++;
					System.out.println("[" + teams2[scoreCounter - 1] + " " + finalScores[scoreCounter - 1] + ":" + finalScores[scoreCounter] + " " + teams2[scoreCounter] + "]");
				}
			}
			// Calculates the average scores per game to put in the last index of goalStatistics for the current tournament
			for (statisticsCounter = 1; statisticsCounter <= 15; statisticsCounter++) {
				totalTournamentGoals = totalTournamentGoals + goalStatistics[tournamentCounter][statisticsCounter];
			}
			goalStatistics[tournamentCounter][16] = totalTournamentGoals/15;
			// Displays the winning team of the current tournament
			System.out.println("Tournament: " + tournamentCounter + " The WINNER is " + winningTeam);
			tournamentCounter++;
			System.out.println();
		}
		// Displays the number of tournaments it took for the user's team to win, or displays that the team didn't win
		if (userInput.equalsIgnoreCase(winningTeam)) System.out.println("It took " + tournamentCounter + " tournament(s) of the game for " + winningTeam + " to win!!!");
		else System.out.println("Sorry, " + userInput + " didn't win in " + TOURNAMENT_COUNTER_MAXIMUM + " tournaments!");
		System.out.println();
		// This is the goal statistics table that's displayed at the end of the program
		System.out.println("GOAL STATS");
		System.out.println();
		// Displays the goal statistics for all the tournaments that took place
		for (tournamentStatisticsCounter = 0; tournamentStatisticsCounter < tournamentCounter; tournamentStatisticsCounter++) {
			System.out.print("[Tournament " + tournamentStatisticsCounter + "] Total goals: [");
			for (statisticsCounter = 1; statisticsCounter <= 15; statisticsCounter++) {
				System.out.print((int)goalStatistics[tournamentStatisticsCounter][statisticsCounter]);
				if(statisticsCounter != 15) System.out.print(", ");
				else System.out.print("]");
			}
			// The average is displayed with 1 decimal as per the assignment's instructions
			System.out.printf(" [Average: %.1f", goalStatistics[tournamentStatisticsCounter][16]);
			totalAverageGoals = totalAverageGoals + goalStatistics[tournamentStatisticsCounter][16];
			System.out.print("]\n");
		}
		// Calculates the average of all the average goals in the World Cup
		System.out.printf("\nAverage goals for %d tournament(s): %.1f\n", tournamentCounter, totalAverageGoals/tournamentCounter);
		// Counts which games had more goals than the total average. Displays that number afterwards.
		for (tournamentStatisticsCounter = 0; tournamentStatisticsCounter < tournamentCounter; tournamentStatisticsCounter++) {
			for (statisticsCounter = 1; statisticsCounter <= 15; statisticsCounter++) {
				if (totalAverageGoals/tournamentCounter < goalStatistics[tournamentStatisticsCounter][16]) aboveAverageMatches++;
			}
		}
		System.out.println("Total matches in all tournaments over the average goal value: " + aboveAverageMatches);
		System.out.println("\nThank you and have a nice day!");
		// Close scanner
		stringKeyboard.close();
	}

}
