// Manoli Tramountanas
// CS 143
// HW Core Topics: Setting Up My Development Environment
// 
// This program will print "Hello World" to the console 5 times.
// It will continue to do so until the user gives an input other than "Yes" (case insensitive).

package hw0.HelloWorld;

// Imports
import java.util.Scanner;

/**
 * The main class used for Homework 0, "Setting Up Your Dev Environment".
 * @author Manoli Tramountanas
 *
 */
public class TestMain
{
	public int[][] matrixAdd(int[][] a, int[][] b)
	{
		int[][] c = {{}};
		return c;
	}
	
	/**
	 * A scanner used to detect user input.
	 */
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * The executed method for this program.
	 * Prints "Hello World" to the console 5 times,
	 * then continues to do so until the user
	 * gives an input other than "Yes" (case insensitive).
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Default input is set to "Yes" to meet the conditions for starting the while loop.
		String input = "Yes";
		
		// Repeat as long as the user input remains "Yes" (case insensitive).
		while (input.equalsIgnoreCase("Yes"))
		{
			// Print "Hello World" to the console 5 times.
			for (int i = 0; i < 5; i++)	
			{
				System.out.println("Hello World!");
			}
			
			// Ask the user if they would like to see "Hello World" again.
			System.out.println("Do you want to see \"Hello World\" again?");
			
			// Takes the next line of the console as user input (after the enter key is pressed).
			input = scanner.nextLine();
		}
	}
}

/*
Hello World!
Hello World!
Hello World!
Hello World!
Hello World!
Do you want to see "Hello World" again?
Yes
Hello World!
Hello World!
Hello World!
Hello World!
Hello World!
Do you want to see "Hello World" again?
No
*/