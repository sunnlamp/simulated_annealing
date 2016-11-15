package simulatedAnnealing;

public class Node {
	public int board[][] = new int[8][8]; // 8 by 8 chess board
	public int numOfAttacks = 0; // Total number of queens attacking each other
	
	public Node(){
		
	}

	public int GetAttacks(){ // Returns the number of attacks. 
		numOfAttacks = NumberOfDiagonalAttacks() + NumberOfHorizontalAttacks();
		return numOfAttacks;
	}
	
	public void AcceptState(int[][] brd){ // Copies the board of an accepted state
		for(int i = 0; i < brd.length; i++){
			for(int j = 0; j < brd[i].length; j++){
				board[i][j] = brd[i][j];
			}
		}
	}
	
	public void MoveQueen(int row, int column){ // Moves a queen at a certain row and index
		for(int i = 0; i < 8; i++){
			board[i][column] = 0;
		}
		board[row][column] = 1;
		//PrintBoard();
	}
	
	public void PrintBoard(){ // Prints the state
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}	
	}
	
	public int NumberOfDiagonalAttacks(){ // Number of diagonal attacks
		int diagonalAttacks = 0;
		int diagonalQueens = 0;
		
		int rows = board.length;
		int cols = board[0].length;
		
		for(int i = 0; i < rows; i++ ){
			for(int r = i, c = 0; r >= 0 && c < cols; r--, c++){
				if(board[r][c] == 1)
					diagonalQueens++;
			}
			if(diagonalQueens > 0)
				diagonalAttacks += (diagonalQueens - 1 ) * diagonalQueens / 2;
			diagonalQueens = 0;
		}
		
		for(int i = 1; i < cols; i++){
			for(int r = rows - 1, c = i; r >= 0 && c < cols; r--, c++){
				if(board[r][c] == 1)
					diagonalQueens++;
			}
			if(diagonalQueens > 0)
				diagonalAttacks += (diagonalQueens -1 ) * diagonalQueens / 2;
			diagonalQueens = 0;
		}

		for(int i = rows - 1; i >= 0; i--){
			for(int r = i, c = 0; r < rows && c < cols; r++, c++){
				if(board[r][c] == 1)
					diagonalQueens++;
			}
			if(diagonalQueens > 0)
				diagonalAttacks += (diagonalQueens -1 ) * diagonalQueens / 2;
			diagonalQueens = 0;
		}
		
		for(int i = cols - 1; i >= 0; i--){
			for(int r = 0, c = i; r < cols && c < cols; r++, c++){
				if(board[r][c] == 1)
					diagonalQueens++;
			}
			if(diagonalQueens > 0)
				diagonalAttacks += (diagonalQueens -1 ) * diagonalQueens / 2;
			diagonalQueens = 0;
		}
		return diagonalAttacks;
	}
	
	public int NumberOfHorizontalAttacks(){ // Number of horizontal attacks
		int horizontalAttacks = 0;
		int horizontalQueens = 0;
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == 1)
					horizontalQueens++;
			}
			horizontalAttacks += (horizontalQueens - 1) * horizontalQueens / 2;
			horizontalQueens = 0;
		}	
		return horizontalAttacks;
	}

}

