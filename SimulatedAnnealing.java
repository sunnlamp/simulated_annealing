package simulatedAnnealing;

import java.util.Random;
import java.util.Scanner;

public class SimulatedAnnealing {
	
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in); // Can be used to track each iteration
				
	    int temperature = 10000; // Starting temperature is 10000

		Node currentState = new Node();	// Current State 
		PlaceQueens(currentState.board); // Place queens randomly for the current state
		
		while(currentState.GetAttacks() != 0){ // Keep running until there are 0 attacks. Not guaranteed to reach 0...
			for(int i = 0; i < 8; i++){	// Check possible states for each queen
				Node possibleNextState = new Node(); // Create a possible state
				possibleNextState.AcceptState(currentState.board); // Possible state should start with the same board as the current state
				
				for(int j = 0; j < 8; j++){
					
					//kb.nextLine();

					System.out.println("CS board: ");
					currentState.PrintBoard();
					
					possibleNextState.MoveQueen(j, i); // Move queens one tile at a time to generate different possible states
					
					System.out.println("PNS board: ");
					possibleNextState.PrintBoard();
					
					System.out.println("T: " + temperature + "  [" + i + " , " + j + "]: PNS:" + possibleNextState.GetAttacks() + "  CS: " + currentState.GetAttacks());
					
					if(possibleNextState.GetAttacks() < currentState.GetAttacks()){ // If the possible state is better take it. It is Hill Climbing up to this point

						currentState.AcceptState(possibleNextState.board); // Since the possible next state is better, assign its board to current state
						System.out.println("PNS is BETTER.");

					} else{ // Implement Simulated Annealing formula to determine whether your program should accept a worse state
						System.out.println("PNS is WORSE, Check probability of accepting:");
						
						// Your code here...
						// Calculate deltaE
						// Depending on the temperature value, 
						// AcceptanceProbability function should decide to whether take a worse state or not
					}
					
					if(currentState.GetAttacks() == 0) // If there are 0 attacks terminate
						break;
				}
			}
		}
		
		currentState.PrintBoard();
		System.out.println("Number of total attacks: " + currentState.GetAttacks() + "\n");
		System.out.println("Took " + (10000 - temperature) + " iterations to solve it.");

	}
	
	public static boolean AcceptanceProbability(int deltaE, int temperature){
		
		// Your code here...
		// You must have a double probability weight value k 
		// k will have a constant value depending on temperature
		// for temperatures above 5000, k must be 0.2
		// for temperatures between 2500 and 5000 k must be 0.1
		// for temperatures between 100 and 2500 k must be 0.05 
		// for temperatures under 100 k must be 0.
		// Multiply k with deltaE to find acceptance probability (Do not use Math.exp())

	}

	public static void PlaceQueens(int [][] brd){
		Random rand = new Random();
		for(int i = 0; i < brd[0].length; i++){
			brd[rand.nextInt(8)][i] = 1;
		}
	}
	

}
