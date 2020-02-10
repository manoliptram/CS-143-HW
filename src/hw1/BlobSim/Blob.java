// Manoli Tramountanas
// CS 143
// HW Core Topics: Abstract Classes and Comparable<T>.
// 
// This program will cycle two different Blobs
// (a PowerBlob and a FlippingBlob) a number of times
// as given by the user (at least one). It will also
// print the Blobs, their weights, and how they compare.

package hw1.BlobSim;

import java.util.*;
import java.io.*;

/**
 * A type of 5 x 5 matrix of integers that
 * updates according to a pattern as defined
 * by the Blob subtype. Blobs are comparable
 * by weight, which is the sum of all terms
 * contained in a Blob.
 * 
 * @author Manoli Tramountanas
 *
 */
public abstract class Blob implements Comparable<Blob> {
	protected int[][] grid;

	public Blob() {
		grid = new int[5][5];
	}

	public void load(String fileName) {
		try {
			Scanner file = new Scanner(new File("G:\\School\\CS-143-Workspace\\CS-143-HW\\src\\hw1\\BlobSim\\blobs\\" + fileName));

			for(int r = 0; r < grid.length; r++) {
				for(int c = 0; c < grid[0].length; c++) {
					grid[r][c] = file.nextInt();
				}
			}

		} catch(FileNotFoundException e) {
			System.out.println("Cannot load: " + fileName);
		} catch(InputMismatchException e) {
			System.out.println(fileName + " does not meet format expectations.");
		}
	}
	
	public abstract void cycle();
	
	public int compareTo(Blob b)
	{
		if (weight() < b.weight())
		{
			return -1;
		}
		if (weight() > b.weight())
		{
			return 1;
		}
		return 0;
	}
	
	public int weight()
	{
		int total = 0;
		
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				total += grid[r][c];
			}
		}
		
		return total;
	}

	public String toString() {
		String build = " -----------------\n";
		for(int r = 0; r < grid.length; r++) {
			build += "|\t";
			for(int c = 0; c < grid[0].length; c++) {
				// Replace all instances of '0' in the blob with '-'.
				String spot = grid[r][c] == 0 ? "-" : ""+grid[r][c];
				build += spot + "\t";
			}
			build += "|\n";
		}
		build += " -----------------\n";
		return build;
	}
}

/* Output
 * 
 * Tested with:
 * 

public static void main(String[] args) {
		Blob b1 = new PowerBlob(),
			 b2 = new FlippingBlob();
		
		System.out.println("Start");
		
		b1.load("blob1.blb");
		b2.load("blob3.blb");
		
		System.out.println("\nBlob 1\n" + b1);
		System.out.println("\nBlob 2\n" + b2);
		
		System.out.println("Simulation for a " + b1.getClass().getSimpleName() + " (1) and a " + b2.getClass().getSimpleName() + " (2).");
		
		Scanner console = new Scanner(System.in);
		int cycles = 0;
		
		do
		{
			b1.cycle();
			b2.cycle();
			cycles++;
			
			System.out.println("\nBlob 1 after cycle " + cycles + "\n" + b1);
			System.out.println("Current Weight = " + b1.weight());
			
			System.out.println("\nBlob 2 after cycle " + cycles + "\n" + b2);
			System.out.println("Current Weight = " + b2.weight());
			
			if (b1.compareTo(b2) == 0)
			{
				System.out.println("\nBlob 1 and Blob 2 have the same weight.");
			}
			else
			{
				String result = (b1.compareTo(b2) > 0) ? "greater than the weight of Blob 2.": "less than the weight of Blob 2.";
				System.out.println("\nThe weight of Blob 1 is " + result);
			}
			
			System.out.println("\nWould you like to cycle the blob again?");
		}
		// Author's Note: The Blobs cycle on "Yes" (case insensitive) rather than ""
		while (console.next().equalsIgnoreCase("Yes"));
		
		System.out.println("Finish\n");
		System.out.println("\nBlob 1\n" + b1);
		System.out.println("\nBlob 2\n" + b2);
	}

 * 
 * Result:
 * 

Start

Blob 1
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	2	2	2	2	2	|
|	1	2	3	4	5	|
|	6	7	8	9	-	|
 -----------------


Blob 2
 -----------------
|	4	-	-	-	9	|
|	8	2	1	-	-	|
|	-	1	2	3	-	|
|	9	-	2	-	5	|
|	1	7	3	9	5	|
 -----------------

Simulation for a PowerBlob (1) and a FlippingBlob (2).

Blob 1 after cycle 1
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	2	2	2	2	2	|
|	1	2	3	4	5	|
|	6	7	8	9	-	|
 -----------------

Current Weight = 60

Blob 2 after cycle 1
 -----------------
|	4	1	1	1	9	|
|	8	2	-	1	1	|
|	1	-	2	3	1	|
|	9	1	2	1	5	|
|	-	7	3	9	5	|
 -----------------

Current Weight = 77

The weight of Blob 1 is less than the weight of Blob 2.

Would you like to cycle the blob again?
Yes

Blob 1 after cycle 2
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	4	4	4	4	4	|
|	1	4	9	16	25	|
|	36	49	64	81	-	|
 -----------------

Current Weight = 310

Blob 2 after cycle 2
 -----------------
|	4	-	-	-	9	|
|	8	2	1	-	-	|
|	-	1	2	3	-	|
|	9	-	2	-	5	|
|	1	7	3	9	5	|
 -----------------

Current Weight = 71

The weight of Blob 1 is greater than the weight of Blob 2.

Would you like to cycle the blob again?
Yes

Blob 1 after cycle 3
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	64	64	64	64	64	|
|	1	64	729	4096	15625	|
|	46656	117649	262144	531441	-	|
 -----------------

Current Weight = 978730

Blob 2 after cycle 3
 -----------------
|	4	1	1	1	9	|
|	8	2	-	1	1	|
|	1	-	2	3	1	|
|	9	1	2	1	5	|
|	-	7	3	9	5	|
 -----------------

Current Weight = 77

The weight of Blob 1 is greater than the weight of Blob 2.

Would you like to cycle the blob again?
Yes

Blob 1 after cycle 4
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	6777216	6777216	6777216	6777216	6777216	|
|	1	6777216	7483647	7483647	7483647	|
|	7483647	7483647	7483647	7483647	-	|
 -----------------

Current Weight = 93048831

Blob 2 after cycle 4
 -----------------
|	4	-	-	-	9	|
|	8	2	1	-	-	|
|	-	1	2	3	-	|
|	9	-	2	-	5	|
|	1	7	3	9	5	|
 -----------------

Current Weight = 71

The weight of Blob 1 is greater than the weight of Blob 2.

Would you like to cycle the blob again?
Yes

Blob 1 after cycle 5
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	7483647	7483647	7483647	7483647	7483647	|
|	1	7483647	7483647	7483647	7483647	|
|	7483647	7483647	7483647	7483647	-	|
 -----------------

Current Weight = 97287417

Blob 2 after cycle 5
 -----------------
|	4	1	1	1	9	|
|	8	2	-	1	1	|
|	1	-	2	3	1	|
|	9	1	2	1	5	|
|	-	7	3	9	5	|
 -----------------

Current Weight = 77

The weight of Blob 1 is greater than the weight of Blob 2.

Would you like to cycle the blob again?
No
Finish


Blob 1
 -----------------
|	1	1	1	1	1	|
|	-	-	-	-	-	|
|	7483647	7483647	7483647	7483647	7483647	|
|	1	7483647	7483647	7483647	7483647	|
|	7483647	7483647	7483647	7483647	-	|
 -----------------


Blob 2
 -----------------
|	4	1	1	1	9	|
|	8	2	-	1	1	|
|	1	-	2	3	1	|
|	9	1	2	1	5	|
|	-	7	3	9	5	|
 -----------------
 * 
 * Author's Note: Sorry the Blob formatting is so off in the output,
 * but it was really fun to let the PowerBlob get out of hand
 * with 7 orders of magnitude (and really interesting to see the
 * resulting pattern!).
 */