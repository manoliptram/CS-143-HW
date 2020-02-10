package hw1.BoardGames;

public class TicTacToeBoard
{
	protected char[][] board;
	protected int marked;
	
	// (char) 49 = '1'
	protected final int ASCII_OF_ONE = 49;

	public TicTacToeBoard()
	{
		board = new char[3][3];
		marked = 0;
		reset();
		// TODO: Generate {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
		
	}

	public boolean mark(int spot, char player)
	{
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				if (board[r][c] == (char)(spot + (ASCII_OF_ONE - 1)))
				{
					board[r][c] = player;
					marked++;
					return true;
				}
			}
		}
		
		return false;
	}

	public boolean isFull()
	{
		return marked == (board.length * board[0].length);
	}

	public boolean checkWinner()
	{
		return diagonalWin() || horizontalWin() || verticalWin();
	}

	protected boolean diagonalWin()
	{
		return (board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
				(board[2][0] == board[1][1] && board[2][0] == board[0][2]);
	}
	
	protected boolean horizontalWin()
	{
		for (int r = 0; r < board.length; r++)
		{
			if (board[r][0] == board[r][1] && board[r][0] == board[r][2])
			{
				return true;
			}
		}
		
		return false;
	}
	
	protected boolean verticalWin()
	{
		for (int c = 0; c < board[0].length; c++)
		{
			if (board[0][c] == board[1][c] && board[0][c] == board[2][c])
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGameOver()
	{
		return isFull() || checkWinner();
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				str.append(board[r][c] + " | ");
			}
			str.append("\n" + "--  --  --  --");
			str.append("\n");
		}
		
		return str.toString();
	}
	
	protected void reset()
	{
		int val = 0;
		for (int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < board[r].length; c++)
			{
				board[r][c] = (char) (ASCII_OF_ONE + val);
				val++;
			}
		}
	}

}
