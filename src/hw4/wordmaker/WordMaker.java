package hw4.wordmaker;

import java.util.*;
import java.io.*;

public class WordMaker
{
	// My personal file path
	static String filePath = "C:\\Users\\Manoli Tramountanas\\Desktop\\School Documents\\Computer Science 143\\Classwork\\HW\\src\\hw4\\wordmaker\\";
	private Set<String> words;

	/**
	 * Constructs a new WordMaker given a file name
	 * for a file containing a list of words to pull from.
	 * 
	 * @param fileName
	 */
	public WordMaker(String fileName)
	{
		words = new HashSet<>();
		load(fileName);
	}

	/**
	 * Load in all words from a file with a given name
	 * in the appropriate file path.
	 * 
	 * @param fileName
	 */
	public void load(String fileName)
	{
		try
		{
			// adds all the words in the file to the word set
			Scanner file = new Scanner(new File(filePath + fileName));
			while(file.hasNext())
			{
				words.add(file.next().toLowerCase());
			}
		}

		catch(FileNotFoundException e)
		{
			System.out.println("Something went wrong with: " + filePath + fileName);
		}
	}

	/**
	 * Given a desired word length, return the first
	 * word alphabetically (lexiographically) in the given set
	 * that is of the desired length. 
	 * @param length
	 * @return The first word alphabetically in the given set of the given length.
	 */
	public String makeLexiographically(int length)
	{
		return makeLexiographically(length, "");
	}

	/**
	 * Helper method for the public makeLexiographically method.
	 * Adds a String parameter so that recursion can take place.
	 * 
	 * @param length
	 * @param word
	 * @return The first word alphabetically in the given set of the given length.
	 */
	private String makeLexiographically(int length, String word)
	{
		if(length == word.length() && words.contains(word))
		{
			return word;
		}

		if(word.length() < length)
		{
			for(char c = 'a'; c <= 'z'; c++)
			{
				word += c;
				String attempt = makeLexiographically(length, word);
				if(!attempt.equals(""))
					return attempt;
				word = word.substring(0, word.length() - 1);
			}
		}

		return "";
	}
	
	/**
	 * @param length
	 * @return A random word of the specified length from the given dictionary.
	 */
	public String makeRandomly(int length)
	{
		return makeRandomly(length, "");
	}
	
	/**
	 * Helper method from the public makeRandomly method.
	 * @param length
	 * @param word
	 * @return A random word of the specified length from the given dictionary.
	 */
	private String makeRandomly(int length, String word)
	{
		if (length == word.length() && words.contains(word))
		{
			return word;
		}
		
		if (word.length() < length)
		{
			GrabBag<Character> alphabet = new GrabBag<>();
			for (char c = 'a'; c <= 'z'; c++)
			{
				alphabet.add(c);
			}
			
			while (!alphabet.isEmpty())
			{
				word += alphabet.grab();
				String attempt = makeRandomly(length, word);
				
				if (!attempt.equals(""))
				{
					return attempt;
				}
				
				word = word.substring(0, word.length() - 1);
			}
		}
		
		return "";
	}
	
	/**
	 * @return A new GrabBag of characters containing
	 * the lowercase version of every character in the alphabet.
	 */
	private GrabBag<Character> newAlphabetBag()
	{
		GrabBag<Character> b = new GrabBag<>();
		
		for (char c = 'a'; c <= 'z'; c++)
		{
			b.add(c);
		}
		
		return b;
	}

	/**
	 * @param length
	 * @return A random word of the specified length from the given dictionary
	 * that contains no duplicate letters.
	 */
	public String makeRandomlyNoRepeats(int length)
	{
		GrabBag<Character> alphabet = newAlphabetBag();
		
		return makeRandomlyNoRepeats(length, "", alphabet);
	}
	
	/**
	 * Helper method for the public makeRandomlyNoRepeats method.
	 * @param length
	 * @param word
	 * @param alphabet
	 * @return A random word in the given dictionary of the given length
	 * that contains no duplicate letters.
	 */
	private String makeRandomlyNoRepeats(int length, String word, GrabBag<Character> alphabet)
	{
		if (length == word.length() && words.contains(word))
		{
			return word;
		}
		
		if (word.length() < length)
		{
			/* Bugfix Time!
			 * 
			 * The reason the code kept breaking was because
			 * alphabet would never be empty if you kept adding letters back
			 * in the while loop.
			 * 
			 * You needed to create a separate ArrayList with all of the
			 * characters that didn't work for that particular index in the "word" String.
			 * Then, AFTER the code exits the while loop, you needed to put all of the
			 * characters in the ArrayList back into the alphabet GrabBag,
			 * thus "backtracking" the recursion successfully.
			 */
			ArrayList<Character> invalidChars = new ArrayList<>();
			while (!alphabet.isEmpty())
			{
				char letter = alphabet.grab();
				word += letter;
				
				String attempt = makeRandomlyNoRepeats(length, word, alphabet);
				
				if (!attempt.equals(""))
				{
					return attempt;
				}
				
				word = word.substring(0, word.length() - 1);
				invalidChars.add(letter);
			}
			
			while (!invalidChars.isEmpty())
			{
				alphabet.add(invalidChars.get(0));
				invalidChars.remove(0);
			}
		}
		
		return "";
	}

	/**
	 * @return The String "This is a word maker object.".
	 */
	public String toString()
	{
		return "This is a word maker object.";
	}
}