package HW_2.setandmap;

import java.util.*;
import java.io.*;

public class ExploringSetAndMap
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//exploringSet();
		//exploringMap();

		//exploringSet("speech.txt");
		exploringMap("speech.txt");
	}

	public static void exploringSet()
	{
		int[] data = {18, 4, 97, 3, 4, 18, 72, 4, 42, 42, -3};
		List<Integer> numbers1 = new ArrayList<Integer>();
		Set<Integer> numbers2 = new HashSet<Integer>();
		ListSet numbers3 = new ListSet();

		// Iterate through data and add each term in the array to each Set
		// "For each value 'n' in "data", add 'n' to each Set being explored."
		for (int n : data)
		{
			numbers1.add(n);
			numbers2.add(n);
			numbers3.add(n);
		}

		// Print out each Collection object.
		// "numbers1" contains every term in "data" in the listed order.
		// "numbers2" and "numbers3" each contain one entry for every unique term in "data".
		System.out.println("numbers1 = " + numbers1);
		System.out.println("numbers2 = " + numbers2);
		System.out.println("numbers3 = " + numbers3);
	}

	public static void exploringMap()
	{
		Map<String, String> heros = new TreeMap<String, String>();
		
		heros.put("Batman", "Bruce Wayne");
		heros.put("Spiderman", "Peter Parker");
		heros.put("Catwoman", "Selina Kyle");
		heros.put("Ironman", "Tony Stark");
		heros.put("Superman", "Clark Kent");
		heros.put("Hulk", "Bruce Banner");
		
		// Because the Keys in a Map<K, V> are stored as a set,
		// assigning a different value to an existing Key
		// will override the current value assigned to that Key.
		// heros.put("Batman", "Terry McGinnnis");

		// A Map stores a Collection of Values as assigned to a Set of Keys.
		System.out.println("Heros = " + heros);
	}

	public static void exploringSet(String fileName) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(/* Prefix for the file address */ "C:\\Users\\Manoli Tramountanas\\Desktop\\School Documents\\Computer Science 143\\Classwork\\HW\\src\\HW_2\\setandmap\\"
				+ fileName));
		Set<String> words = new TreeSet<String>();
		
		// Process each String (word) in the file, using whitespace as a delimiter
		while (input.hasNext())
		{
			String next = input.next().toLowerCase();
			
			// Add each String found to the Set of words in the file.
			// This means that duplicates will not be stored in the Collection.
			words.add(next);
		}

		System.out.println("List of words = " + words);    
		System.out.println("Total unique words = " + words.size());  
	}

	public static void exploringMap(String fileName) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File("C:\\\\Users\\\\Manoli Tramountanas\\\\Desktop\\\\School Documents\\\\Computer Science 143\\\\Classwork\\\\HW\\\\src\\\\HW_2\\\\setandmap\\" +
				fileName));
		Map<String,Integer> words = new TreeMap<String,Integer>();

		// Process each String (word) in the file, using whitespace as a delimiter
		while (input.hasNext())
		{
			String next = input.next().toLowerCase();
			
			// Check if the current String is stored within the Set of Keys in the Map "words"
			if (!words.containsKey(next))
			{
				// If the current String is not yet a Key in "words",
				// add it to "words" with a value of 1 to indicate
				// the number of times the String has appeared in the file
				words.put(next, 1);
			}
			else
			{
				// If the current String is already a Key in "words",
				// increase the value associated with the String by 1
				// to indicate the number of times it has appeared in the file.
				int currentCount = words.get(next);
				words.put(next, currentCount + 1);
			}
		}

		System.out.println("List of words = " + words);    
		System.out.println("Total unique words = " + words.size());  
	}
}