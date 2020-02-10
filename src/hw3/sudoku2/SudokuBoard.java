// Manoli Tramountanas
// CS 143
// HW Core Topics: Setting Up My Development Environment
// 
// This program will test the added functionality of SudokuBoard,
// namely its ability to understand whether or not the given sudoku board
// follows the rules of the game and whether or not the given sudoku board
// is solved.

package hw3.sudoku2;

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
	/* Instance Variable Declaration */
	
	private int[][] board;
	
	/** Notes on the "formatted" variable.
	 * 
	 * <p>
	 * Currently, all formatting issues are handled in the constructor,
	 * giving isFormatted() a straightforward O(1) runtime. For numeric values,
	 * the constructor checks if the value is greater than 9 or less than 0
	 * and changes accordingly. For non-numeric values,
	 * the constructor checks if the character matches a character
	 * named "blankSpace", whose default value is '.', and changes accordingly.
	 * The user may change blankSpace if desired
	 * using the static method changeBlankSpaceCharacter().
	 * </p>
	 */
	private boolean formatted = true;
	
	/* Class Variable Declaration */
	
	private static char blankSpace = '.';

	/** Notes on the "filePath" variable.
	 * 
	 * <p>
	 * If you wish to change the filePath for SudokuBoard objects,
	 * you may do so with the static changeFilePath() method.
	 * Example code currently exists in Main for my own unique setup.
	 * </p>
	 */
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
					if (currentRow.charAt(i) == blankSpace)
					{
						board[rowNum][i] = 0;
					}
					else if (!Character.isDigit(currentRow.charAt(i)))
					{
						formatted = false;
						board[rowNum][i] = 0;
					}
					else
					{
						board[rowNum][i] = (int) (currentRow.charAt(i) - '1' + 1);
						
						if (board[rowNum][i] > 9 || board[rowNum][i] < 0)
						{
							formatted = false;
						}
					}
				}

				rowNum++;
			}
		}

		catch (FileNotFoundException e)
		{
			System.out.println("Sudoku Board File Not Found.");
			formatted = false;
		}

		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Sudoku Board File Improperly Formatted.");
			formatted = false;
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

	/**
	 * Changes the file path for all future SudokuBoard objects in the program.
	 * @param newFilePath
	 */
	public static void changeFilePath(String newFilePath)
	{
		filePath = newFilePath;
	}
	
	/**
	 * Changes the blank space/filler character for all future SudokuBoard objects in the program.
	 * @param newBlankSpace
	 */
	public static void changeBlankSpaceCharacter(char newBlankSpace)
	{
		blankSpace = newBlankSpace;
	}

	/**
	 * Tracks and creates a 3 x 3 "mini square" from a given spot in the current SudokuBoard.
	 * @param spot
	 * @return The desired mini square.
	 */
	private int[][] miniSquare(int spot) {
		int[][] mini = new int[3][3];
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				// whoa - wild! This took me a solid hour to figure out (at least)
				// This translates between the "spot" in the 9x9 Sudoku board
				// and a new mini square of 3x3
				mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
			}
		}
		return mini;
	}

	/**
	 * Author's Note: This is being kept in here for me.
	 * You may ignore it if you like.
	 * @param valid
	 * @param solved
	 */
	public void debug(boolean valid, boolean solved)
	{
		if(valid != isValid())
		{
			System.out.println("failed isValid test");
			System.out.println("rows " + ((rowsValid()) ? "are valid" : "are not valid"));
			System.out.println("columns " + ((columnsValid()) ? "are valid" : "are not valid"));
			System.out.println("minisquares " + ((miniSquaresValid()) ? "are valid" : "are not valid"));
		}
		
		if (solved != isSolved())
		{
			System.out.println("failed isSolved test");
		}
	}
	
	/**
	 * @return If the current SudokuBoard is a valid sudoku board that can be solved.
	 */
	public boolean isValid()
	{	
		return isFormatted() &&
				columnsValid() &&
				rowsValid() &&
				miniSquaresValid();
	}
	
	/**
	 * @return If the SudokuBoard is formatted properly.
	 */
	private boolean isFormatted()
	{
		// Author's Note: See instance variable declaration
		// for more on the "formatted variable.
		return formatted;
	}
	
	/**
	 * @return If the rows of the SudokuBoard can be solved.
	 */
	private boolean rowsValid()
	{
		for (int r = 0; r < board.length; r++)
		{
			Set<Integer> values = new HashSet<>();
			for (int c = 0; c < board[r].length; c++)
			{
				if (values.contains(board[r][c]))
				{
					return false;
				}
				
				if (board[r][c] != 0)
				{
					values.add(board[r][c]);
				}
			}
		}
		
		return true;
	}
	
	/**
	 * @return If the columns of the SudokuBoard can be solved.
	 */
	private boolean columnsValid()
	{
		for (int c = 0; c < board[0].length; c++)
		{
			Set<Integer> values = new HashSet<>();
			for (int r = 0; r < board.length; r++)
			{
				if (values.contains(board[r][c]))
				{
					return false;
				}

				if (board[r][c] != 0)
				{
					values.add(board[r][c]);
				}
			}
		}
		
		return true;
	}
	
	/**
	 * @return If the mini squares of the SudokuBoard can be solved.
	 */
	private boolean miniSquaresValid()
	{
		for (int i = 1; i <= 9; i++)
		{
			int[][] miniSquare = miniSquare(i);
			Set<Integer> values = new HashSet<>();
			
			for (int r = 0; r < miniSquare.length; r++)
			{
				for (int c = 0; c < miniSquare[r].length; c++)
				{
					if (values.contains(miniSquare[r][c]))
					{
						return false;
					}
					
					if (miniSquare[r][c] != 0)
					{
						values.add(miniSquare[r][c]);
					}
				}
			}
		}
		
		return true;
	}

	/**
	 * @return Whether or not the SudokuBoard is solved.
	 */
	public boolean isSolved()
	{
		if (!isValid())
		{
			return false;
		}
		
		Map<Integer, Integer> numOccurences = new HashMap<>();
		
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				if (board[r][c] == 0)
				{
					return false;
				}
				if (numOccurences.containsKey(board[r][c]))
				{
					numOccurences.put(board[r][c], numOccurences.get(board[r][c]) + 1);
				}
				else
				{
					numOccurences.put(board[r][c], 1);
				}
			}
		}
		
		for (int i = 1; i <= 9; i++)
		{
			if (!numOccurences.containsKey(i))
			{
				return false;
			}
			
			if (numOccurences.get(i) != 9)
			{
				return false;
			}
		}
		
		return true;
	}
}