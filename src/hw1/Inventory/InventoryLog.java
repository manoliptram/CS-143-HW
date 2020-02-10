// Manoli Tramountanas
// CS 143
// HW Core Topics: Interfaces, File Input, and int/char Conversion.
// 
// This program will store characters as given by the user or program,
// as well as return the quantity of various characters within the instance if asked.

package hw1.Inventory;

// Imports
import java.util.*;

/**
 * Stores characters as given by the user or program,
 * as well as return the quantity of various characters
 * contained if asked by the user or program.
 * 
 * Case insensitive for alphabetic characters.
 * 
 * @author Manoli Tramountanas
 *
 */
public class InventoryLog implements Inventory
{
	// Class Variables
	private List<Character> chars;
	
	/**
	 * Constructs a new InventoryLog.
	 */
	public InventoryLog()
	{
		chars = new ArrayList<Character>();
	}
	
	/**
	 * Adds a given character to the InventoryLog.
	 * @param c (char)
	 */
	public void add(char c)
	{
		chars.add(c);
	}
	
	/**
	 * Deletes all instances of a given character from the InventoryLog.
	 * @param c (char)
	 */
	public void subtract(char c)
	{
		for (int i = 0; i < chars.size(); i++)
		{
			if (chars.get(i) == c)
			{	
				chars.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * @return The number of instances a given character appears in the InventoryLog.
	 */
	public int get(char c)
	{
		return numInstances(c, chars);	
//		int val = 0;
//		for (int i = 0; i < chars.size(); i++)
//		{
//			if (chars.get(i) == c)
//			{
//				val++;
//			}
//		}
//		
//		return val;
	}
	
	/**
	 * @param c (char)
	 * @param ar (List<Character>)
	 * @return The number of instances a given character appears in a given List<Character>.
	 */
	private int numInstances(char c, List<Character> ar)
	{
		if (ar.size() == 0)
		{
			return 0;
		}
		
		if (ar.get(ar.size() - 1) == c)
		{
			return numInstances(c, ar.subList(0, ar.size() - 1)) + 1;
		}
		
		return numInstances(c, ar.subList(0,  ar.size() - 1));
	}
	
	/**
	 * Sets the number of instances of a given character to a given count.
	 * If the count is greater than the current number of instances of the character,
	 * add instances to the end of the InventoryLog until the count is equal.
	 * If the count is less than the current number of instances of the character,
	 * subtract instances from beginning to end of the InventoryLog until the count is equal.
	 * 
	 * @param c (char)
	 * @param count (int)
	 */
	public void set(char c, int count)
	{
		if (get(c) < count)
		{
			add(c);
			set(c, count);
		}
		else if (get(c) > count)
		{
			chars.remove(c);
			set(c, count);
		}
	}
	
	/**
	 * @return Whether or not the InventoryLog contains the given character.
	 * @param c (char)
	 */
	public boolean contains(char c)
	{
		return chars.contains(c);
	}
	
	/**
	 * @return The number of characters in the InventoryLog.
	 */
	public int size()
	{
		return chars.size();
	}
	
	/**
	 * @return Whether or not the InventoryLog is empty (contains no characters).
	 */
	public boolean isEmpty()
	{
		return chars.size() == 0;
	}
	
	/**
	 * Return the InventoryLog as a String of format
	 * "[aaabbbccc...]" where all characters in the InventoryLog are printed
	 * in the order that they were entered into the InventoryLog.
	 */
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("[");
		
		for (int i = 0; i < chars.size(); i++)
		{
			str.append(chars.get(i));
		}
		
		str.append("]");
		return str.toString();
	}
}

/*
 * Tested with the following method:
	public static void testInventory(Inventory inv)
	{
		inv.add('a');
		inv.add('!');
		
		System.out.println(inv);
		
		inv.subtract('A');
		
		System.out.println(inv);
		
		inv.subtract('a');
		
		System.out.println(inv);
		
		inv.add('A');
		inv.set('c', 7);
		
		System.out.println(inv);
		
		System.out.println("Number of Cs: " + inv.get('c'));
		System.out.println("Size of Inventory = " + inv.size());
		System.out.println("\"This inventory contains at least 1 !\" is " + inv.contains('!'));
		System.out.println("\"This inventory contains at least 1 a\" is " + inv.contains('a'));
		System.out.println("\"This inventory contains at least 1 A\" is " + inv.contains('A'));
		System.out.println("\"This inventory is empty\" is " + inv.isEmpty());
 * Output:
[a!]
[a!]
[!]
[!Accccccc]
Number of Cs: 7
Size of Inventory = 9
"This inventory contains at least 1 !" is true
"This inventory contains at least 1 a" is false
"This inventory contains at least 1 A" is true
"This inventory is empty" is false
 */
