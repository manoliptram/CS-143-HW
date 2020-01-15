// Manoli Tramountanas
// CS 143
// HW Core Topics: Interfaces, File Input, and int/char Conversion.

package HW_1.Inventory;

import java.util.*;
import java.io.*;

public class LetterInventory implements Inventory
{
	private int[] letters;

	public LetterInventory()
	{
		letters = new int[26];
	}
	
	public void add(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			letters[c - 'a']++;
		}
	}
	
	public void subtract(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			letters[c - 'a']--;
		}
	}
	
	public int get(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			return letters[c - 'a'];
		}
		
		return 0;
	}
	
	public void set(char c, int count)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			letters[c - 'a'] = count;
		}
	}
	
	public boolean contains(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			return letters[c - 'a'] != 0;
		}
		
		return false;
	}
	
	public boolean isEmpty()
	{
		return letters.length == 0;
	}

	public String toString()
	{
		StringBuilder toReturn = new StringBuilder("[");
		for (int i = 0; i < letters.length; i++)
		{
			for (int count = 0; count < letters[i]; count++)
			{
				toReturn.append((char) ('a' + i));
			}
		}
		return toReturn.append("]").toString();
	}
}
