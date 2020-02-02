// Manoli Tramountanas
// CS 143
// HW Core Topics: Setting Up My Development Environment
// 
// This program will test the functionality of a SudokuBoard class,
// which reads the input of a properly formatted file and
// converts it into a 9 x 9 Sudoku board with toString functionality.

package HW_2.sudoku1;

/**
 * <p>
 * Written by Manoli Tramountanas.
 * </p>
 * 
 * <p>
 * Main class for testing the initial draft
 * of the SudokuBoard framework.
 * </p>
 * 
 * <p>
 * Tests instantiation with the following:
 * <ul>
 * <li> A properly formatted file </li>
 * <li> A nonexistant file name </li>
 * <li> An improperly formatted file </li>
 * </ul>
 * </p>
 * 
 */
public class SudokuMain
{

	public static void main(String[] args)
	{
		SudokuBoard.changeFilePath("G:\\School\\CS-143-Workspace\\CS-143-HW\\src\\HW_2\\sudoku1\\");
		
		// Testing functionality - No catches
		SudokuBoard b = new SudokuBoard("data1.sdk");
		System.out.println(b);
		
		// Testing functionality - Catching a FileNotFoundException
		SudokuBoard b1 = new SudokuBoard("data1.sk");
		System.out.println(b1);
		
		// Testing functionality - Catching an ArrayIndexOutOfBoundsException
		SudokuBoard b2 = new SudokuBoard("data2.txt");
		System.out.println(b2);
		
		/* Author's Note: I found myself unable to submit the data2.txt file in Canvas.
		 * For clarity, here are its contents:
			2..1.5..3
			.54...71.
			.1.2.3.8.
			6.28.73.4
			.........
			1265
			1.53.98.6
			.2.7.1.6.3
			.81...24.
			7..4.2..1
		 */
	}
	
}

/* Output
- - - - - - - - - - - - - - - - - - 
2 | _ | _ | 1 | _ | 5 | _ | _ | 3 | 
- - - - - - - - - - - - - - - - - - 
_ | 5 | 4 | _ | _ | _ | 7 | 1 | _ | 
- - - - - - - - - - - - - - - - - - 
_ | 1 | _ | 2 | _ | 3 | _ | 8 | _ | 
- - - - - - - - - - - - - - - - - - 
6 | _ | 2 | 8 | _ | 7 | 3 | _ | 4 | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
1 | _ | 5 | 3 | _ | 9 | 8 | _ | 6 | 
- - - - - - - - - - - - - - - - - - 
_ | 2 | _ | 7 | _ | 1 | _ | 6 | _ | 
- - - - - - - - - - - - - - - - - - 
_ | 8 | 1 | _ | _ | _ | 2 | 4 | _ | 
- - - - - - - - - - - - - - - - - - 
7 | _ | _ | 4 | _ | 2 | _ | _ | 1 | 
- - - - - - - - - - - - - - - - - - 

Sudoku Board File Not Found.
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
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 

Sudoku Board File Improperly Formatted.
- - - - - - - - - - - - - - - - - - 
2 | _ | _ | 1 | _ | 5 | _ | _ | 3 | 
- - - - - - - - - - - - - - - - - - 
_ | 5 | 4 | _ | _ | _ | 7 | 1 | _ | 
- - - - - - - - - - - - - - - - - - 
_ | 1 | _ | 2 | _ | 3 | _ | 8 | _ | 
- - - - - - - - - - - - - - - - - - 
6 | _ | 2 | 8 | _ | 7 | 3 | _ | 4 | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
1 | 2 | 6 | 5 | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
1 | _ | 5 | 3 | _ | 9 | 8 | _ | 6 | 
- - - - - - - - - - - - - - - - - - 
_ | 2 | _ | 7 | _ | 1 | _ | 6 | _ | 
- - - - - - - - - - - - - - - - - - 
_ | _ | _ | _ | _ | _ | _ | _ | _ | 
- - - - - - - - - - - - - - - - - - 
 */