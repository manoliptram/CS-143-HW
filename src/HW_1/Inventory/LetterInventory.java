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
		
	}
	
	public void subtract(char c)
	{
		
	}
	
	public int get(char c)
	{
		
	}
	
	public void set(char c, int count)
	{
		
	}
	
	public boolean contains(char c)
	{
		
	}
	
	public boolean isEmpty()
	{
		
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
