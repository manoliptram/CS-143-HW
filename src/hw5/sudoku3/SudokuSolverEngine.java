// Manoli Tramountanas
// CS 143
// HW Core Topics: Recursive Backtracking
// 
// This program will test the added functionality of the SudokuBoard class,
// namely its ability to solve a given sudoku board.

package hw5.sudoku3;

public class SudokuSolverEngine
{

	public static void main(String[] args)
	{
		// Author's Note: This file path is unique to my own setup. Change it as you see fit.
		SudokuBoard.changeFilePath("C:\\Users\\Manoli Tramountanas\\Desktop\\School Documents\\Computer Science 143\\Classwork\\HW\\src\\hw5\\sudoku3\\testboards\\");
		
		System.out.println("Trial 1: very-fast-solve.sdk");
		SudokuBoard board1 = new SudokuBoard("very-fast-solve.sdk");
		testBoard(board1);
		
		System.out.println("Trial 2: fast-solve.sdk");
		SudokuBoard board2 = new SudokuBoard("fast-solve.sdk");
		testBoard(board2);
		
		System.out.println("Trial 3: valid-complete.sdk");
		SudokuBoard board3 = new SudokuBoard("valid-complete.sdk");
		testBoard(board3);
		
		System.out.println("Trial 4: grid-violation.sdk");
		SudokuBoard board4 = new SudokuBoard("grid-violation.sdk");
		testBoard(board4);
	}
	
	public static void testBoard(SudokuBoard b)
	{
		System.out.println("Initial board");
		System.out.println(b);
		System.out.println();

		System.out.print("Solving board...");
		boolean solved;
		long start = System.currentTimeMillis();
		
		if (b.isValid())
		{
			solved = b.solve();
		}
		
		else
		{
			solved = false;
		}
		
		long stop = System.currentTimeMillis();
		
		if (solved)
		{
			System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
		}
		
		else
		{
			System.out.println("CANNOT BE SOLVED.");
		}
		
		System.out.println();
		System.out.println(b);
	}
}

/* Output:
Trial 1: very-fast-solve.sdk
Initial board
- - - - - - - - - - - - - - - - - - 
_ | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 | 
- - - - - - - - - - - - - - - - - - 
_ | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 | 
- - - - - - - - - - - - - - - - - - 
1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 | 
- - - - - - - - - - - - - - - - - - 
_ | _ | 9 | _ | 6 | 1 | 4 | 2 | 3 | 
- - - - - - - - - - - - - - - - - - 
_ | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 | 
- - - - - - - - - - - - - - - - - - 
_ | 1 | 3 | 9 | 2 | 4 | _ | 5 | 6 | 
- - - - - - - - - - - - - - - - - - 
_ | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 | 
- - - - - - - - - - - - - - - - - - 
_ | 8 | _ | 4 | 1 | 9 | 6 | 3 | 5 | 
- - - - - - - - - - - - - - - - - - 
3 | 4 | 5 | _ | 8 | 6 | 1 | 7 | 9 | 
- - - - - - - - - - - - - - - - - - 


Solving board...SOLVED in 0.022 seconds.

- - - - - - - - - - - - - - - - - - 
5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 | 
- - - - - - - - - - - - - - - - - - 
6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 | 
- - - - - - - - - - - - - - - - - - 
1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 | 
- - - - - - - - - - - - - - - - - - 
8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 | 
- - - - - - - - - - - - - - - - - - 
4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 | 
- - - - - - - - - - - - - - - - - - 
7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 | 
- - - - - - - - - - - - - - - - - - 
9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 | 
- - - - - - - - - - - - - - - - - - 
2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 | 
- - - - - - - - - - - - - - - - - - 
3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 | 
- - - - - - - - - - - - - - - - - - 

Trial 2: fast-solve.sdk
Initial board
- - - - - - - - - - - - - - - - - - 
8 | 2 | 7 | 1 | 5 | 4 | 3 | 9 | 6 | 
- - - - - - - - - - - - - - - - - - 
9 | 6 | 5 | _ | 2 | 7 | 1 | 4 | 8 | 
- - - - - - - - - - - - - - - - - - 
3 | 4 | 1 | 6 | _ | 9 | 7 | 5 | 2 | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
6 | 1 | 8 | 9 | 7 | _ | 4 | 3 | 5 | 
- - - - - - - - - - - - - - - - - - 
7 | 8 | 6 | 2 | 3 | 5 | _ | 1 | 4 | 
- - - - - - - - - - - - - - - - - - 
1 | 5 | 4 | 7 | 9 | 6 | 8 | _ | 3 | 
- - - - - - - - - - - - - - - - - - 
2 | 3 | 9 | 8 | 4 | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 


Solving board...SOLVED in 0.016 seconds.

- - - - - - - - - - - - - - - - - - 
8 | 2 | 7 | 1 | 5 | 4 | 3 | 9 | 6 | 
- - - - - - - - - - - - - - - - - - 
9 | 6 | 5 | 3 | 2 | 7 | 1 | 4 | 8 | 
- - - - - - - - - - - - - - - - - - 
3 | 4 | 1 | 6 | 8 | 9 | 7 | 5 | 2 | 
- - - - - - - - - - - - - - - - - - 
4 | 7 | 2 | 5 | 1 | 3 | 6 | 8 | 9 | 
- - - - - - - - - - - - - - - - - - 
5 | 9 | 3 | 4 | 6 | 8 | 2 | 7 | 1 | 
- - - - - - - - - - - - - - - - - - 
6 | 1 | 8 | 9 | 7 | 2 | 4 | 3 | 5 | 
- - - - - - - - - - - - - - - - - - 
7 | 8 | 6 | 2 | 3 | 5 | 9 | 1 | 4 | 
- - - - - - - - - - - - - - - - - - 
1 | 5 | 4 | 7 | 9 | 6 | 8 | 2 | 3 | 
- - - - - - - - - - - - - - - - - - 
2 | 3 | 9 | 8 | 4 | 1 | 5 | 6 | 7 | 
- - - - - - - - - - - - - - - - - - 

Trial 3: valid-complete.sdk
Initial board
- - - - - - - - - - - - - - - - - - 
5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 | 
- - - - - - - - - - - - - - - - - - 
6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 | 
- - - - - - - - - - - - - - - - - - 
1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 | 
- - - - - - - - - - - - - - - - - - 
8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 | 
- - - - - - - - - - - - - - - - - - 
4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 | 
- - - - - - - - - - - - - - - - - - 
7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 | 
- - - - - - - - - - - - - - - - - - 
9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 | 
- - - - - - - - - - - - - - - - - - 
2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 | 
- - - - - - - - - - - - - - - - - - 
3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 | 
- - - - - - - - - - - - - - - - - - 


Solving board...SOLVED in 0.001 seconds.

- - - - - - - - - - - - - - - - - - 
5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 | 
- - - - - - - - - - - - - - - - - - 
6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 | 
- - - - - - - - - - - - - - - - - - 
1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 | 
- - - - - - - - - - - - - - - - - - 
8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 | 
- - - - - - - - - - - - - - - - - - 
4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 | 
- - - - - - - - - - - - - - - - - - 
7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 | 
- - - - - - - - - - - - - - - - - - 
9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 | 
- - - - - - - - - - - - - - - - - - 
2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 | 
- - - - - - - - - - - - - - - - - - 
3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 | 
- - - - - - - - - - - - - - - - - - 

Trial 4: grid-violation.sdk
Initial board
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | 1 | 2 | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | 3 | 2 | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | 5 | 4 | _ | 
- - - - - - - - - - - - - - - - - - 


Solving board...CANNOT BE SOLVED.

- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | 1 | 2 | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | 3 | 2 | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | 5 | 4 | _ | 
- - - - - - - - - - - - - - - - - - 
 */