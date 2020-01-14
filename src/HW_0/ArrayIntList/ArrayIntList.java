// Manoli Tramountanas
// CS 143
// HW Core Topics: Fundamentals of ArrayList

// This program will test a custom class, ArrayIntList,
// which is designed to function almost identically to ArrayList
// (albeit with less functionality).

package HW_0.ArrayIntList;

/**
 * A custom class designed to function similarly to ArrayList.
 * @author Manoli Tramountanas
 *
 */
public class ArrayIntList implements IntList
{
	// Array of integers
	private int[] data;
	
	// Current number of elements in the list
	private int size;
	
	public static final int CAPACITY = 20;
	
	/**
	 * Constructs an ArrayIntList object.
	 */
	public ArrayIntList()
	{
		data = new int[20];
		size = 0;
	}

	/**
	 * @return the current size of the ArrayIntList.
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * @param index an index within the bounds of the ArrayIntList.
	 * @return the value assigned to the given index.
	 */
	public int get(int index)
	{
		checkIndex(index);
		return data[index];
	}
	
	/**
	 * Finds the first index that has been assigned a given value.
	 * Returns -1 if the value is not contained within the ArrayIntList.
	 * 
	 * @param value
	 */
	public int indexOf(int value)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] == value)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Adds a given value to the end of the ArrayIntList.
	 * This method does allow for the storage of
	 * more than 20 data pairs within the ArrayIntList.
	 * 
	 * @param value
	 */
	public void add(int value)
	{
		if (size == data.length)
		{
			int[] newData = new int[data.length + 1];
			
			for (int i = 0; i < data.length; i++)
			{
				newData[i] = data[i];
			}
			
			newData[data.length] = value;
			
			data = newData;
			size++;
		}
		
		else
		{
			data[size] = value;
			size++;
		}
	}
	
	/**
	 * Adds a given value to the ArrayIntList, assigning it to a given index.
	 * This method does allow for the storage of
	 * more than 20 data pairs within the ArrayIntList.
	 * 
	 * @param index
	 * @param value
	 */
	public void add(int index, int value)
	{
		if (index < 0)
		{
			checkIndex(index);
		}
		
		size++;
		int[] newData = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			if (i == index)
			{
				newData[i] = value;
			}
			else if (i > index)
			{
				newData[i] = data[i-1];
			}
			else
			{
				newData[i] = data[i];
			}
		}
		
		data = newData;
	}
	
	/**
	 * Removes a data pair assigned to a given index from the ArrayIntList.
	 * 
	 * @param index
	 */
	public void remove(int index)
	{
		checkIndex(index);
		
		data[index] = 0;
		
		for (int i = index + 1; i < size; i++)
		{
			data[i - 1] = data[i];
		}
		
		size--;
	}
	
	/**
	 * @return the ArrayIntList as a String of format "[get(0), get(1), ..., get(size - 1)]".
	 */
	public String toString()
	{
		String output = "[";
		
		for (int i = 0; i < size; i++)
		{
			output += data[i] + ", ";
		}
		
		output = output.substring(0, output.length()-2);
		output += "]";
		
		return output;
	}
	
	// post: throws an IndexOutOfBoundsException if the given index is
	//       not a legal index of the current list
	private void checkIndex(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	// NOTE: The checkCapacity method isn't used in this version of ArrayIntList
	// because the methods allow for a capacity equal to the capacity of
	// an int array.

	// post: checks that the underlying array has the given capacity,
	//       throwing an IllegalStateException if it does not
	private void checkCapacity(int capacity)
	{
		if (capacity > data.length)
		{
			throw new IllegalStateException("would exceed list capacity");
		}
	}
}