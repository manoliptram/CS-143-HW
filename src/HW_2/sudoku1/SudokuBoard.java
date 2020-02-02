// Manoli Tramountanas
// CS 143
// HW Core Topics: Setting Up My Development Environment
// 
// This program will test the functionality of a SudokuBoard class,
// which reads the input of a properly formatted file and
// converts it into a 9 x 9 Sudoku board with toString functionality.

package HW_2.sudoku1;

import java.util.*;
import java.io.*;

/**
 * <p>
 * Written by Manoli Tramountanas.
 * </p>
 * 
 * <p>
 * Framework for a 9 x 9 Sudoku board as read from a given, formatted file.
 * </p>
 */
public class SudokuBoard
{
	
	private int[][] board;
	
	// Author's Note: If you wish to change the filePath, you may do so with the static changeFilePath method in Main.
	// Example code currently exists in Main for my own unique setup.
	private static String filePath = "";
	
	/**
	 * Constructs a new SudokuBoard for a given file in the filePath.
	 * @param fileName
	 */
	public SudokuBoard(String fileName)
	{
		try
		{
			board = new int[9][9];
			int rowNum = 0;
			Scanner s = new Scanner(new File(filePath + fileName));
			
			while (s.hasNextLine())
			{
				String currentRow = s.nextLine();
				
				for (int i = 0; i < currentRow.length(); i++)
				{
					if (!Character.isDigit(currentRow.charAt(i)))
					{
						board[rowNum][i] = 0;
					}
					else
					{
						board[rowNum][i] = (int) (currentRow.charAt(i) - '1' + 1);
					}
				}
				
				rowNum++;
			}
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("Sudoku Board File Not Found.");
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Sudoku Board File Improperly Formatted.");
		}
		
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		s.append("- - - - - - - - - - - - - - - - - - ");
		s.append('\n');
		
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				if (board[r][c] == 0)
				{
					s.append("_ | ");
				}
				else
				{
					s.append(board[r][c] + " | ");
				}
			}
			
			s.append("\n- - - - - - - - - - - - - - - - - - ");
			s.append('\n');
		}
		
		return s.toString();
	}
	
	public static void changeFilePath(String newFilePath)
	{
		filePath = newFilePath;
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