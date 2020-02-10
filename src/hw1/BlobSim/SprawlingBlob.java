package hw1.BlobSim;

public class SprawlingBlob extends Blob {
	/**
	 * 
	 */
	public void cycle()
	{
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				if (grid[r][c] != 0)
				{
					sprawlSpace(r, c);
				}
			}
		}
		
		mod100();
	}
	
	private void sprawlSpace(int r, int c)
	{
			if ((r + 1) < grid.length)
			{
				grid[r + 1][c] += grid[r][c];
			}
			
			if (r > 0)
			{
				grid[r - 1][c] += grid[r][c];
			}
			
			if ((c + 1) < grid[r].length)
			{
				grid[r][c + 1] += grid[r][c];
			}
			
			if (c > 0)
			{
				grid[r][c - 1] += grid[r][c];
			}
			
			grid[r][c] = 0;
	}
	
	private void mod100()
	{
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				grid[r][c] %= 100;
			}
		}
	}
}
