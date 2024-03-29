//************************************************************
//* NOTE: For grading your program we will use an original   *
//*       copy of this file. You will not hand this file in. *
//************************************************************

// YOU MAY ASSUME THE PUZZLES WILL ONLY CONTAIN DIGITS 0 - 9
// inclusive. 0 represents an empty cell and 1 - 9 are cells
// that have already been assigned a digit.
public class SudokuPuzzles {
	
	// Simple Puzzle #1
	// MAKE SURE YOU SUBMIT YOUR PROGRAM TO SOLVE puzzle1!
	public static int[][] puzzle1 = {
    									{0,2,9,0,0,3,0,0,5},
    									{5,0,7,0,0,0,0,9,0},
    									{6,0,0,0,0,9,4,2,0},
    									{3,0,2,0,0,4,0,0,0},
    									{0,0,5,0,3,0,7,0,0},
    									{0,0,0,5,0,0,6,0,2},
    									{0,9,8,4,0,0,0,0,3},
    									{0,3,0,0,0,0,1,0,6},
    									{2,0,0,3,0,0,9,4,0}
    								};
    
	// Simple Puzzle #2
	public static int[][] puzzle2 = {
    									{0,0,0,0,6,0,0,0,9},
    									{0,6,0,0,0,0,3,0,1},
    									{2,0,0,0,0,9,8,0,0},
    									{1,9,6,0,0,2,0,0,8},
    									{0,0,0,3,0,8,0,0,0},
    									{8,0,0,9,0,0,1,7,5},
    									{0,0,1,7,0,0,0,0,4},
    									{6,0,7,0,0,0,0,8,0},
    									{4,0,0,0,9,0,0,0,0}
       								};

	// Difficult, but has solution! Takes several minutes to solve.
	public static int[][] puzzle3 = {
									{0,0,0,0,0,0,0,0,0},
									{0,0,0,0,0,3,0,8,5},
									{0,0,1,0,2,0,0,0,0},
									{0,0,0,5,0,7,0,0,0},
									{0,0,4,0,0,0,1,0,0},
									{0,9,0,0,0,0,0,0,0},
									{5,0,0,0,0,0,0,7,3},
									{0,0,2,0,1,0,0,0,0},
									{0,0,0,0,4,0,0,0,9}
								};


	// Puzzle with NO solution!
	public static int[][] puzzleX = {
    									{0,0,9,0,0,6,0,0,3},
    									{0,3,0,0,1,0,2,0,0},
    									{4,0,0,0,2,0,0,8,0},     
    									{0,0,0,1,0,4,0,0,8},
    									{0,2,0,0,0,0,4,7,0},
    									{0,0,0,6,0,0,0,0,5},
    									{2,0,0,0,0,0,0,0,6},
    									{3,0,1,4,5,0,7,0,9},
    									{0,7,0,8,0,0,0,0,0}
    								};
	public static int[][] puzzle4 = {
		{0,0,0,0,9,6,0,7,1},
		{0,1,0,8,0,0,0,0,0},
		{0,0,0,0,7,0,5,0,2},
		{0,0,0,4,5,0,9,0,0},
		{1,0,5,0,3,7,2,0,0},
		{0,0,0,0,0,9,0,0,0},
		{8,0,4,3,0,0,0,0,0},
		{0,2,0,0,8,0,0,6,4},
		{7,0,0,0,4,0,0,0,3}
	};

}   