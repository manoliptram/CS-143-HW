// Manoli Tramountanas
// CS 143
// HW Core Topics: Setting Up My Development Environment
// 
// This program will print "Hello World" to the console 5 times.
// It will continue to do so until the user gives an input other than "Yes" (case insensitive).

package HW_0;

// Imports
import java.util.Scanner;

/**
 * The main class used for Homework 0, "Setting Up Your Dev Environment".
 * @author Manoli Tramountanas
 *
 */
public class TestMain
{
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
		String input = "Yes";	// Default input is set to "Yes" to meet the conditions for starting the while loop.
		
		while (input.equalsIgnoreCase("Yes"))	// Repeat as long as the user input remains "Yes" (case insensitive).
		{
			for (int i = 0; i < 5; i++)		// Print "Hello World" to the console 5 times.
			{
				System.out.println("Hello World!");
			}
			System.out.println("Do you want to see \"Hello World\" again?");	// Ask the user if they would like to see "Hello World" again.
			input = scanner.nextLine();		// Takes the next line of the console as user input (after the enter key is pressed).
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