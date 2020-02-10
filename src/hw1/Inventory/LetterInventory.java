// Manoli Tramountanas
// CS 143
// HW Core Topics: Interfaces, File Input, and int/char Conversion.
// 
// This program will store the count of different letters in the alphabet
// (case-insensitive) as given by the user or program.

package hw1.Inventory;

/**
 * Stores the count of different letters in the alphabet
 * (case-insensitive) as given by the user or program.
 * @author Manoli Tramountanas
 *
 */
public class LetterInventory implements Inventory
{
	private int[] letters;

	/**
	 * Constructs a new LetterInventory for default inventory values of 0 for all characters.
	 */
	public LetterInventory()
	{
		letters = new int[26];
	}
	
	/**
	 * Adds to the inventory count of a given letter.
	 * If a different character is given, does nothing.
	 * @param c (char)
	 */
	public void add(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			letters[c - 'a']++;
		}
	}
	
	/**
	 * Adds to the inventory count of a given letter.
	 * If a different character is given, does nothing.
	 * @param c (char)
	 */
	public void subtract(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			if (letters[c - 'a'] > 0)
			{
				letters[c - 'a']--;
			}
		}
	}
	
	/**
	 * Returns the count of a given letter within the inventory.
	 * If the given character is not a letter, print to the console and return 0.
	 * @param c (char)
	 * @return The count of a given letter within the inventory.
	 */
	public int get(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			return letters[c - 'a'];
		}
		
		System.out.println("LetterInventory does not track the given character (\'" + c + "\').");
		return 0;
	}
	
	/**
	 * Sets the count of a given letter to a given value.
	 * If the given character is not a letter, print to the console.
	 * @param c (char)
	 * @param count (int)
	 */
	public void set(char c, int count)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			letters[c - 'a'] = count;
		}
		else
		{
			System.out.println("LetterInventory does not track the given character (\'" + c + "\').");
		}
	}
	
	/**
	 * @return Whether or not the LetterInventory contains the given character.
	 * @param c (char)
	 */
	public boolean contains(char c)
	{
		if (Character.isLetter(c))
		{
			c = Character.toLowerCase(c);
			return letters[c - 'a'] != 0;
		}
		
		return false;
	}
	
	/**
	 * @return The number of letters in the LetterInventory.
	 */
	public int size()
	{
		int size = 0;
		
		for (int i = 0; i < letters.length; i++)
		{
			size += letters[i];
		}
		
		return size;
	}
	
	/**
	 * @return Whether or not the LetterInventory is empty (contains no characters).
	 */
	public boolean isEmpty()
	{
		return letters.length == 0;
	}

	/**
	 * @return The letter inventory as a String of format
	 * "[aaabbbccc...zzz]" for each letter repeated a number
	 * of times equal to its count in the inventory.
	 */
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
[a]
[]
[]
[accccccc]
Number of Cs: 7
Size of Inventory = 8
"This inventory contains at least 1 !" is false
"This inventory contains at least 1 a" is true
"This inventory contains at least 1 A" is true
"This inventory is empty" is false
 */