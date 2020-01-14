// Manoli Tramountanas
// CS 143
// HW Core Topics: Fundamentals of ArrayList

// This program will test a custom class, ArrayIntList,
// which is designed to function almost identically to ArrayList
// (albeit with less functionality).

package HW_0.ArrayIntList;

public class SimpleArrayIntList
{
	// Fields
	int[] currentData;
	int size;
	
	// Constructors
	public SimpleArrayIntList()
	{
		currentData = new int[20];
		size = 0;
	}
	
	// Accessors
	public void add(int newEntry)
	{
		if (size == currentData.length)
		{
			int[] newData = new int[currentData.length + 1];
			
			for (int i = 0; i < currentData.length; i++)
			{
				newData[i] = currentData[i];
			}
			
			newData[currentData.length] = newEntry;
			
			currentData = newData;
			size++;
		}
		
		else
		{
			currentData[size] = newEntry;
			size++;
		}
	}
	
	
	// Mutators
	
	// toString
	public String toString()
	{
		String output = "[";
		
		for (int i = 0; i < size; i++)
		{
			output += currentData[i] + ", ";
		}
		
		output = output.substring(0, output.length()-2);
		output += "]";
		
		return output;
	}
}
