package HW_1.BlobSim;

public class GrowingBlob extends Blob
{
	/**
	 * Update the Blob as dictated by the subclass.
	 * For GrowingBlob, add 1 to each value within the Blob.
	 */
	public void cycle()
	{
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				grid[r][c]++;
				grid[r][c] %= 10;
			}
		}
	}
	
}
