// Manoli Tramountanas
// CS 143
// HW Core Topics: Interfaces, File Input, and int/char Conversion.

package hw1.Inventory;

import java.util.*;
import java.io.*;

public class ABCInventory implements Inventory {
	private int As;
	private int Bs;
	private int Cs;
	
	/**
	 * Constructs a new ABCInventory for default inventory values of 0 for all characters.
	 */
	public ABCInventory()
	{
		As = 0;
		Bs = 0;
		Cs = 0;
	}
	
	/**
	 * Adds to the inventory count of either a, b, or c.
	 * If a different character is given, print to the console.
	 * @param c
	 */
	public void add(char c)
	{
		c = Character.toLowerCase(c);
		switch (c)
		{
		case 'a':
			As++;
			break;
			
		case 'b':
			Bs++;
			break;
			
		case 'c':
			Cs++;
			break;
			
		default:
			break;
		}
	}
	
	/**
	 * Subtracts from the inventory count of either a, b, or c.
	 * If a different character is given, print to the console.
	 * @param c
	 */
	public void subtract(char c)
	{
		c = Character.toLowerCase(c);
		switch (c)
		{
		case 'a':
			As--;
			break;
			
		case 'b':
			Bs--;
			break;
			
		case 'c':
			Cs--;
			break;
			
		default:
			break;
		}
	}
	
	public int get(char c)
	{
		c = Character.toLowerCase(c);
		switch (c)
		{
		case 'a':
			return As;
			
		case 'b':
			return Bs;
			
		case 'c':
			return Cs;
			
		default:
			System.out.println("Invalid Character Entered: ABCInventory tracks only As, Bs, and Cs.");
			return -1;
		}
	}
	
	public void set(char c, int count)
	{
		c = Character.toLowerCase(c);
		switch (c)
		{
		case 'a':
			As = count;
			break;
			
		case 'b':
			Bs = count;
			break;
			
		case 'c':
			Cs = count;
			break;
			
		default:
			System.out.println("Invalid Character Entered: ABCInventory tracks only As, Bs, and Cs.");
		}
	}
	
	public boolean contains(char c)
	{
		c = Character.toLowerCase(c);
		switch (c)
		{
		case 'a':
			return As != 0;
			
		case 'b':
			return Bs != 0;
			
		case 'c':
			return Cs != 0;
			
		default:
			System.out.println("Invalid Character Entered: ABCInventory tracks only As, Bs, and Cs.");
			return false;
		}
	}
	
	public int size()
	{
		return As + Bs + Cs;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public String toString()
	{
		return "[A=" + As + ", B=" + Bs + ", C=" + Cs +"]";
	}
}
