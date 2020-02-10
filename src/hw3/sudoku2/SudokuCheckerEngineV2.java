// Manoli Tramountanas
// CS 143
// HW Core Topics: Setting Up My Development Environment
// 
// This program will test the added functionality of SudokuBoard,
// namely its ability to understand whether or not the given sudoku board
// follows the rules of the game and whether or not the given sudoku board
// is solved.

package hw3.sudoku2;

public class SudokuCheckerEngineV2 {

	public static void main(String[] args) {
		// Author's Note: This file path is unique to my own personal setup
		// Feel free to change it as needed here.
		SudokuBoard.changeFilePath("C:\\Users\\Manoli Tramountanas\\Desktop\\School Documents\\Computer Science 143\\Classwork\\HW\\src\\hw3\\sudoku2\\");

		// Note that here I am calling the board object SudokuBoard
		// if you named your class something different, you should
		// find and replace all `SudokuBoard` with your class name
		boolean allTests = true;

		// an empty board is valid, but not solved
		System.out.print("Checking empty board...");
		SudokuBoard board1 = new SudokuBoard("boards/empty.sdk");
		assert board1.isValid() : "isValid: should be true";
		assert !board1.isSolved() : "isSolved: should be false";
		if(board1.isValid() && !board1.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			// Author's Note: You'll see this debug method pop up quite frequently in this class.
			// Its purpose is to print to the console in case a given SudokuBoard
			// does not pass the tests it was given, assuming assertions are disabled.
			board1.debug(/* Desired value of isValid() */ true,
					/* Desired value of isSolved() */ false);
			allTests = false;
		}

		// an incomplete, valid board is valid, but not solved
		System.out.print("Checking incomplete, valid board...");
		SudokuBoard board2 = new SudokuBoard("boards/valid-incomplete.sdk");
		assert board2.isValid() : "isValid: should be true";
		assert !board2.isSolved() : "isSolved: should be false";
		if(board2.isValid() && !board2.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board2.debug(true, false);
			allTests = false;
		}

		// a complete, valid board is valid and solved
		System.out.print("Checking complete, valid board...");
		SudokuBoard board3 = new SudokuBoard("boards/valid-complete.sdk");
		assert board3.isValid() : "isValid: should be true";
		assert board3.isSolved() : "isSolved: should be true";
		if(board3.isValid() && board3.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board3.debug(true, true);
			allTests = false;
		}

		// a board with dirty data is not valid and not solved
		System.out.print("Checking dirty data board...");
		SudokuBoard board4 = new SudokuBoard("boards/dirty-data.sdk");
		assert !board4.isValid() : "isValid: should be false";
		assert !board4.isSolved() : "isSolved: should be false";
		if(!board4.isValid() && !board4.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board4.debug(false, false);
			allTests = false;
		}

		// a board with a row violation is not valid and not solved
		System.out.print("Checking row violating board...");
		SudokuBoard board5 = new SudokuBoard("boards/row-violation.sdk");
		assert !board5.isValid() : "isValid: should be false";
		assert !board5.isSolved() : "isSolved: should be false";
		if(!board5.isValid() && !board5.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board5.debug(false, false);
			allTests = false;
		}

		// a board with a column violation is not valid and not solved
		System.out.print("Checking col violating board...");
		SudokuBoard board6 = new SudokuBoard("boards/col-violation.sdk");
		assert !board6.isValid() : "isValid: should be false";
		assert !board6.isSolved() : "isSolved: should be false";
		if(!board6.isValid() && !board6.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board6.debug(false, false);
			allTests = false;
		}

		// a board with both a row and a column violation is not valid and not solved
		System.out.print("Checking row&col violating board...");
		SudokuBoard board7 = new SudokuBoard("boards/row-and-col-violation.sdk");
		assert !board7.isValid() : "isValid: should be false";
		assert !board7.isSolved() : "isSolved: should be false";
		if(!board7.isValid() && !board7.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board7.debug(false, false);
			allTests = false;
		}

		// a board with a mini-square violation is not valid and not solved
		System.out.print("Checking mini-square violating board...");
		SudokuBoard board8 = new SudokuBoard("boards/grid-violation.sdk");
		assert !board8.isValid() : "isValid: should be false";
		assert !board8.isSolved() : "isSolved: should be false";
		if(!board8.isValid() && !board8.isSolved()) 
			System.out.println("passed.");
		else {
			System.out.println("failed.");
			board8.debug(false, false);
			allTests = false;
		}       

		if(allTests)
			System.out.println("**** HORRAY: ALL TESTS PASSED ****");
	}
}

/* Output:
Checking empty board...passed.
Checking incomplete, valid board...passed.
Checking complete, valid board...passed.
Checking dirty data board...passed.
Checking row violating board...passed.
Checking col violating board...passed.
Checking row&col violating board...passed.
Checking mini-square violating board...passed.
**** HORRAY: ALL TESTS PASSED ****
 */