// Manoli Tramountanas
// CS 143
// HW Core Topics: Multi-Dimensional Arrays and Inheritance
// 
// This program will manage a "Connect 4" board,
// meaning it will update the board as asked (according to the rules)
// and track whether or not the game is over.

package HW_1.BoardGames;

public class Connect4Board extends TicTacToeBoard
{
	public Connect4Board()
	{
		// board & marked are both inherited from TicTacToeBoard
		board = new char[6][7];
		marked = 0;
		reset();
	}

	@Override
	public boolean mark(int spot, char player)
	{
		boolean success = super.mark(spot, player);
		if (success)
		{
			for(int r = board.length - 1; r >= 0; r--)
			{
				if (board[r][spot - 1] == '.')
				{
					board[r][spot - 1] = (char)(spot + ASCII_OF_ONE - 1);
					return success;
				}
			}
		}
		
		return success;
	}

	/* From Superclass:
	public boolean checkWinner()
	{
		return diagonalWin() || horizontalWin() || verticalWin();
	}
	 */
	
	@Override
	protected boolean diagonalWin()
	{
		for (int r = 0; r < board.length - 3; r++)
		{
			for (int c = 0; c < board[r].length - 3; c++)
			{
				if (board[r][c] != '.' &&
						board[r][c] == board[r + 1][c + 1] &&
						board[r][c] == board[r + 2][c + 2] &&
						board[r][c] == board[r + 3][c + 3])
				{
					return true;
				}
				
				if (board[r][c + 3] != '.' &&
						board[r][c + 3] == board[r + 1][c + 2] &&
						board[r][c + 3] == board[r + 2][c + 1] &&
						board[r][c + 3] == board[r + 3][c])
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	protected boolean horizontalWin()
	{
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length - 4; c++)
			{
				if (board[r][c] != '.' &&
						board[r][c] == board[r][c + 1] &&
						board[r][c] == board[r][c + 2] &&
						board[r][c] == board[r][c + 3])
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	protected boolean verticalWin()
	{
		for (int c = 0; c < board[0].length - 1; c++)
		{
			for (int r = 0; r < board.length - 3; r++)
			{
				if (board[r][c] != '.' &&
						board[r][c] == board[r][c + 1] &&
						board[r][c] == board[r][c + 2] &&
						board[r][c] == board[r][c + 3])
				{
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				str.append(board[r][c] + " | ");
			}
			str.append("\n" + "--  --  --  --  --  --  --");
			str.append("\n");
		}
		
		return str.toString();
	}
	
	@Override
	protected void reset()
	{
		for(int r = 0; r < board.length - 1; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				board[r][c] = '.';
			}
		}
		
		for (int c = 0; c < board[board.length - 1].length; c++)
		{
			board[board.length - 1][c] = (char) (ASCII_OF_ONE + c);
		}
	}
}
/* Output:
 * 
 * Game 1
 * 
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 1
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | . | . | . | . | . | . | 
--  --  --  --  --  --  --
r | 2 | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 1
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | . | . | . | . | . | . | 
--  --  --  --  --  --  --
B | . | . | . | . | . | . | 
--  --  --  --  --  --  --
r | 2 | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 2
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | . | . | . | . | . | . | 
--  --  --  --  --  --  --
B | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
r | r | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 2
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
B | B | . | . | . | . | . | 
--  --  --  --  --  --  --
r | r | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 3
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
B | B | 3 | . | . | . | . | 
--  --  --  --  --  --  --
r | r | r | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 3
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | 3 | . | . | . | . | 
--  --  --  --  --  --  --
B | B | B | . | . | . | . | 
--  --  --  --  --  --  --
r | r | r | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 4

Good game!
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | 3 | . | . | . | . | 
--  --  --  --  --  --  --
B | B | B | 4 | . | . | . | 
--  --  --  --  --  --  --
r | r | r | r | 5 | 6 | 7 | 
--  --  --  --  --  --  --
 * 
 * Game 2
 * 
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 1
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | . | . | . | . | . | . | 
--  --  --  --  --  --  --
r | 2 | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 2
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
r | B | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 2
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | r | . | . | . | . | . | 
--  --  --  --  --  --  --
r | B | 3 | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 3
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | r | 3 | . | . | . | . | 
--  --  --  --  --  --  --
r | B | B | 4 | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 4
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | . | . | . | . | . | 
--  --  --  --  --  --  --
1 | r | 3 | 4 | . | . | . | 
--  --  --  --  --  --  --
r | B | B | r | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 3
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | 3 | . | . | . | . | 
--  --  --  --  --  --  --
1 | r | B | 4 | . | . | . | 
--  --  --  --  --  --  --
r | B | B | r | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 3
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | 3 | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | r | . | . | . | . | 
--  --  --  --  --  --  --
1 | r | B | 4 | . | . | . | 
--  --  --  --  --  --  --
r | B | B | r | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 4
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | 3 | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | r | 4 | . | . | . | 
--  --  --  --  --  --  --
1 | r | B | B | . | . | . | 
--  --  --  --  --  --  --
r | B | B | r | 5 | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 5
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | 3 | . | . | . | . | 
--  --  --  --  --  --  --
. | 2 | r | 4 | . | . | . | 
--  --  --  --  --  --  --
1 | r | B | B | 5 | . | . | 
--  --  --  --  --  --  --
r | B | B | r | r | 6 | 7 | 
--  --  --  --  --  --  --


Player B, where would you like to go? > 4
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | 3 | 4 | . | . | . | 
--  --  --  --  --  --  --
. | 2 | r | B | . | . | . | 
--  --  --  --  --  --  --
1 | r | B | B | 5 | . | . | 
--  --  --  --  --  --  --
r | B | B | r | r | 6 | 7 | 
--  --  --  --  --  --  --


Player r, where would you like to go? > 4

Good game!
. | . | . | . | . | . | . | 
--  --  --  --  --  --  --
. | . | . | 4 | . | . | . | 
--  --  --  --  --  --  --
. | . | 3 | r | . | . | . | 
--  --  --  --  --  --  --
. | 2 | r | B | . | . | . | 
--  --  --  --  --  --  --
1 | r | B | B | 5 | . | . | 
--  --  --  --  --  --  --
r | B | B | r | r | 6 | 7 | 
--  --  --  --  --  --  --
 */
