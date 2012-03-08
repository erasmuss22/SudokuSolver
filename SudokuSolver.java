///////////////////////////////////////////////////////////////////////////////
// 
// Title:            Sudoku Solver
// Files:            SudokuSolver.java, SudokuPuzzles.java
// Semester:         Fall 2010
//
// Author:           Erin Rasmussen ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Jim Skrentny
// Lab Section:      313

//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * The class SudokuSolver takes pre-made puzzles of the popular game and solves
 * them using a basic, brute-force algorithm. The class combines multiple methods
 * to obtain the desired result with no user input necessary.  For all methods, 
 * int r and c denote row and column in all cases.
 * 
 * <p>Bugs: Solve time for Puzzle3 is long. Code not as efficient as desired.
 *
 * @author Erin Rasmussen
 */

public class SudokuSolver {
	/**
	 * This method takes a pre-made puzzle and assigns it to an array to be used
	 * throughout the program.  The array is 2-dimensional and acts as a coordinate
	 * system. The variable grid must be declared and have equal dimensions to puzzle.
	 *
	 * @param (int [][] grid) grid is a 9x9 array that gets its values based
	 * on the chosen puzzle.
	 * @param (int[][] puzzle) 1 of a few pre-made sudoku boards that when chosen,
	 * is assigned into the array grid.
	 */
	public static void initializeGrid(int[][] grid, int[][] puzzle) {
		for(int r = 0; r < puzzle.length; r++){
			for(int c = 0; c < puzzle[0].length; c++){
				grid[r][c] = puzzle[r][c];
			}
		}
	}

	/**
	 * This method displays the variable grid in a way that separates the puzzle
	 * into 9 regions, making it much easier to read through.  Before calling this
	 * method, the grid must be initialized with a pre-made puzzle. Zeroes are 
	 * displayed as blank spaces.
	 * 
	 * @param (int[][] grid) grid is the whole puzzle itself and based on each
	 * row and column, different formatting is used.
	 */
	public static void displayGrid(int[][] grid) {
		System.out.println("+---+---+---+");
		for (int r = 0; r < grid.length; r++){				//for ever new row, | is placed for style
			System.out.print("|");
			for (int c = 0; c < grid[0].length; c++){
				if (grid[r][c] == 0){						//zeroes are displayed as blanks
					System.out.print(" ");
				}
				else {
					System.out.print(grid[r][c]);
				}
				if (c == 2 || c == 5 || c == 8){			//the grid is divided into 9 regions on the sides by |
					System.out.print("|");
				}
			}
			System.out.println();
			if (r == 2 || r == 5 || r == 8){				//the 9 regions are separated above and below by this
				System.out.println("+---+---+---+");
			}

		}

	}

	/**
	 * This method creates an array of the coordinates of all empty cells. 
	 * The list is necessary in order to solve the puzzle. The grid and array
	 * of empty cells must be declared before using this method.
	 * 
	 * @param (int[][] grid) grid is the puzzle to solve and any values of zero
	 * are looked at by this method.
	 * @param (int[][] emptyCells) emptyCells is an array to be filled with the
	 * coordinates of empty cells in the puzzle. A maximum of 81 empties are possible
	 * so a companion variable is required.
	 * @return int getEmptyCells is the total amount of empty cells out of 81
	 */
	public static int getEmptyCells(int[][] grid, int[][] emptyCells) {
		int total = 0;
		int x = 0;
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[0].length; c++){			//goes through and fills array with coordinates of 
				if (grid[r][c] == 0){							//all empty cells.
					total++;
					emptyCells[x][0] = r;
					emptyCells[x][1] = c;
					x++;
				}
			}
		}
		return total;
	}

	/**
	 * This method checks if the list of numbers has any repeated values.
	 * To use this, an array of either a row, column, or region must be
	 * created.  The method checks every number in the array not equal to 0.
	 *
	 * @param (int[][] digitsList) a 1 dimensional array of digits in a row,
	 * column, or region.
	 * @return boolean hasNoDuplicates: returns true if there aren't any repeated
	 * values
	 */
	private static boolean hasNoDuplicates(int[] digitsList) {
		for(int r = 0; r < digitsList.length; r++){
			for(int c = r + 1; c < digitsList.length; c++){
				if((digitsList[r] == digitsList[c]) && (digitsList[r] != 0 || digitsList[c] != 0)){
					return false;
				}
			}
		}  
		return true;
	}

	/**
	 * This method checks the current row for any repeated values.  It requires
	 * the grid to be initialized and an input of the current row. It calls the method
	 * hasNoDuplicates to see if any values are repeated.
	 *
	 * @param (int[][] grid) the puzzle to be solved
	 * @param (int currentRow) the row to be checked for repeat values
	 * @return boolean checkCurrentRow: returns true if no values repeat
	 */
	private static boolean checkCurrentRow(int[][] grid, int currentRow) {
		int[]rowDigits = new int[grid.length];
		for (int c = 0; c < grid[0].length; c++){
			rowDigits[c] = grid[currentRow][c];	
		}
		if (hasNoDuplicates(rowDigits)) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks the current column for any repeated values.  It requires
	 * the grid to be initialized and an input of the current column. It calls the method
	 * hasNoDuplicates to see if any values are repeated.
	 *
	 * @param (int[][] grid) the puzzle to be solved
	 * @param (int currentCol) the column to be checked for repeat values
	 * @return boolean checkCurrentCol: returns true if no values repeat
	 */
	private static boolean checkCurrentCol(int[][] grid, int currentCol) {
		int[]colDigits = new int[grid.length];
		for (int r = 0; r < grid.length; r++){
			colDigits[r] = grid[r][currentCol];	
		}
		if (hasNoDuplicates(colDigits)) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks the current region for any repeated values. A region
	 * is a 3x3 area defined by the formatting from displayGrid. It requires
	 * the grid to be initialized, an input of the current row, and an input of current
	 * column. It calls the method hasNoDuplicates to see if any values are repeated.
	 *
	 * @param (int[][] grid) the puzzle to be solved
	 * @param (int currentRow) the row to be checked for repeat values
	 * @param (int currentCol) the current column to define the region based
	 * on the row.
	 * @return boolean checkCurrentRegion: returns true if no values repeat
	 */
	private static boolean checkCurrentRegion(int[][] grid, int currentRow,
			int currentCol) {
		int x = 0;
		int[] currentRegion = new int[grid.length];
		if ((currentRow >= 0 && currentRow < 3) && (currentCol >= 0 && currentCol < 3)){
			for (int r = 0; r < 3; r++){
				for (int c = 0; c < 3; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 3 && currentRow < 6) && (currentCol >= 0 && currentCol < 3)){
			for (int r = 3; r < 6; r++){
				for (int c = 0; c < 3; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 6 && currentRow < 9) && (currentCol >= 0 && currentCol < 3)){
			for (int r = 6; r < 9; r++){
				for (int c = 0; c < 3; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 0 && currentRow < 3) && (currentCol >= 3 && currentCol < 6)){
			for (int r = 0; r < 3; r++){
				for (int c = 3; c < 6; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 0 && currentRow < 3) && (currentCol >= 6 && currentCol < 9)){
			for (int r = 0; r < 3; r++){
				for (int c = 6; c < 9; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 3 && currentRow < 6) && (currentCol >= 3 && currentCol < 6)){
			for (int r = 3; r < 6; r++){
				for (int c = 3; c < 6; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 3 && currentRow < 6) && (currentCol >= 6 && currentCol < 9)){
			for (int r = 3; r < 6; r++){
				for (int c = 6; c < 9; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else if ((currentRow >= 6 && currentRow < 9) && (currentCol >= 3 && currentCol < 6)){
			for (int r = 6; r < 9; r++){
				for (int c = 3; c < 6; c++){
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		else {
			for (int r = 6; r < 9; r++){			//there is probably a more efficient way of checking regions
				for (int c = 6; c < 9; c++){		//but this guarantees to check all regions based on current row/column
					currentRegion[x] = grid[r][c];
					x++;
				}
			}
		}
		if (hasNoDuplicates(currentRegion)){
			return true;
		}


		return false;

	}

	/**
	 * This method uses each of the previous methods to check for repeated
	 * values.  It checks the row, column, and region and returns true if
	 * everything is consistently true. It requires the grid to be initialized
	 * and an input of the current row and column.
	 *
	 * @param (int[][] grid) the puzzle to be solved
	 * @param (int currentCol) the column to be checked for repeat values
	 * @param (int currentRow) the row to be checked for repeat values
	 * @return boolean isConsistent: returns true if no values repeat
	 */
	public static boolean isConsistent(int[][] grid, int currentRow,
			int currentCol) {
		if (checkCurrentRow(grid, currentRow) && checkCurrentCol(grid, currentCol) &&
				checkCurrentRegion(grid, currentRow, currentCol)){
			return true;
		}

		return false;
	}

	/**
	 * This method makes uses brute force to solve the sudoku puzzle. This uses 
	 * the method isConsistent to call the other methods that check for repeat values.
	 * Depending on the return value of this, the method changes the value of each empty
	 * cell accordingly.  This requires the grid to be initialized, the array of empty cells
	 * to be initialized, and the amount of empty cells to be initialized.
	 *
	 * @param (int[][] grid) the puzzle to be solved
	 * @param (int[][] emptyCells) the coordinates of empty cells in the grid
	 * @param (int numEmptyCells) the companion variable to emptyCells which
	 * keeps track of the amount of empty cells in the entire grid.
	 * @return boolean solvePuzzle: returns true if the puzzle has been solved
	 */
	public static boolean solvePuzzle(int[][] grid, int[][] emptyCells,
			int numEmptyCells) {
		int r = 0;
		while (numEmptyCells > 0){						//when there are no more empty cells, the puzzle stops solving
			int x = emptyCells[r][0];
			int y = emptyCells[r][1];
			if (grid[x][y] != 9) {
				grid[x][y] = grid[x][y] + 1;
				if (isConsistent(grid, x, y)){
					r++;
					numEmptyCells--;
				}
				else {
					while (!isConsistent(grid, x, y)  && grid[x][y] < 10){
						grid[x][y] = grid[x][y] + 1;
					}
					if (!isConsistent(grid, x, y) || grid[x][y] > 9){
						grid[x][y] = 0;
						r--;
						numEmptyCells++;								//if something is inconsistent, empty cells
						if (r < 0){										//must change to keep while loop going
							return false;
						}				
					}
					else {
						r++;
						numEmptyCells--;
					}
				}
			}
			else {
				grid[x][y] = 0;
				r--;
				numEmptyCells++;
				if (r < 0){
					return false;
				}				
			}

		}
		return true;
	}

	/**
	 * The main method calls the methods initializeGrid, getEmptyCells, diplayGrid
	 * and solvePuzzle to solve the puzzle.  If the puzzle is solveable, it displays
	 * the solved puzzle using the displayGrid method.
	 *
	 */
	public static void main(String[] args) {

		final int SIZE = 9;
		int[][] puzzle  = SudokuPuzzles.puzzle4;			//chooses between 4 pre-made puzzles
		int[][] grid    = new int[SIZE][SIZE];				//the array used to store the puzzle
		int[][] emptyCellsList = new int[SIZE*SIZE][2];     //list of cells without prefilled coordinates
		int numEmptyCells = 0;								//companion variable for emptyCellsList, total empties

		initializeGrid(grid, puzzle);
		numEmptyCells = getEmptyCells(grid, emptyCellsList);
		System.out.println("The puzzle:");		
		displayGrid(puzzle);
		if (solvePuzzle(grid, emptyCellsList, numEmptyCells)) {
			System.out.println("has been solved:");
			displayGrid(grid);
		}
		else {
			System.out.println("cannot be solved!");
		}
	}

}
