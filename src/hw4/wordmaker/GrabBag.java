package hw4.wordmaker;

/*
   This class is used to make a group of data where you can
   `grab` a random value.
   @author Crystal Hess 10/29/2019
 */

import java.util.*;

public class GrabBag<E>
{
	
	private ArrayList<E> bag;

	/**
	 * Constructs a new GrabBag object.
	 */
	public GrabBag()
	{
		bag = new ArrayList<E>();
	}

	/**
	 * Adds an object to the GrabBag.
	 * @param data to be added of the appropriate type for this instance of GrabBag.
	 */
	public void add(E data)
	{
		bag.add(data);
	}

	/**
	 * @return A random element from the bag that is subsequently removed from the bag.
	 */
	public E grab()
	{
		Random r = new Random();
		E removed = bag.remove(r.nextInt(bag.size()));
		return removed;
	}

	/**
	 * @return Whether or not the GrabBag is empty (contains 0 elements).
	 */
	public boolean isEmpty()
	{
		return bag.size() == 0;
	}

	/**
	 * @Override
	 * @return The GrabBag as a String in the same format as an ArrayList.
	 */
	public String toString()
	{
		return bag.toString();
	}
}