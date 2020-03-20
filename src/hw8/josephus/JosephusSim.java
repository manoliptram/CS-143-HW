// Manoli Tramountanas
// CS 143
// HW Core Topics: Linked Lists
// 
// This program will simulate the Josephus Problem,
// in which a circle of people is cycled through according
// to a given count, with the person at the found position
// being eliminated each time until only one remains.

package hw8.josephus;

import java.util.*;
import java.io.*;

public class JosephusSim
{
	private PersonNode circle;     // a PersonNode pointer that tracks first node
	private int size;              // the number of people in the circle
	private int eliminationCount;  // the number to count to for elimination       
	private PersonNode track;      // a PersonNode pointer to help with elimination

	public JosephusSim(String fileName)
	{
		try
		{
			// load names from the file in order, generating a singly linked list of PersonNodes
			PersonNode current = circle;
			size = 0;
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNextLine())
			{
				if (circle == null)
				{
					circle = new PersonNode(file.nextLine());
					current = circle;
				}

				else
				{
					current.next = new PersonNode(file.nextLine());
					current = current.next;
				}

				size++;
			}

			// make the ring circular by attaching last node's next to front
			current.next = circle;

			// remember the last node as the one in front of the next to get eliminated
			track = current;

			// generate, print, and save the random elimination count
			Random r = new Random();
			eliminationCount = r.nextInt(size / 2) + 1;
			System.out.println("=== Elimination count is " + eliminationCount + " ===");
		}

		catch(FileNotFoundException e)
		{
			System.out.println("Something went wrong with " + fileName);
		}
	}

	public void eliminate()
	{
		// count to the elimination count
		// The found node is the one that comes immediately
		// before the one to be eliminated.
		for (int i = 1; i < eliminationCount; i++)
		{
			track = track.next;
		}

		// print who will be eliminated
		System.out.println(track.next.name + " eliminated!");

		// eliminate the person and update "front" of the circle and size
		track.next = track.next.next;
		circle = track.next;
		size--;
	}

	public boolean isOver()
	{
		// check if there's only one person left in the circle
		return size == 1;
	}

	public String toString()
	{
		// if there's only one person left, print them as the last survivor
		if (isOver())
		{
			return circle.name + " is the last survivor!";
		}

		// print the remaining survivors (watch out for infinite loop since list is circular)
		String ret = "Remaining survivors: ";
		// Iterate through the survivors and append each of their names to the return string.
		PersonNode cur = circle;
		for (int i = 1; i <= size; i++)
		{
			ret += i + "-" + cur.name + ", ";
			cur = cur.next;
		}
		// Remove the final ", " from the string, then return it
		ret = ret.substring(0, ret.length() - 2);
		return ret;
	}

}
/* Output:
=== Elimination count is 2 ===
Remaining survivors: 1-Muhammad, 2-Beza, 3-Ibrar, 4-Nur, 5-Krystal, 6-River, 7-Soham, 8-Leon, 9-Will, 10-Qiao

Continue elimination? <press enter>

Beza eliminated!
Remaining survivors: 1-Ibrar, 2-Nur, 3-Krystal, 4-River, 5-Soham, 6-Leon, 7-Will, 8-Qiao, 9-Muhammad

Continue elimination? <press enter>

Nur eliminated!
Remaining survivors: 1-Krystal, 2-River, 3-Soham, 4-Leon, 5-Will, 6-Qiao, 7-Muhammad, 8-Ibrar

Continue elimination? <press enter>

River eliminated!
Remaining survivors: 1-Soham, 2-Leon, 3-Will, 4-Qiao, 5-Muhammad, 6-Ibrar, 7-Krystal

Continue elimination? <press enter>

Leon eliminated!
Remaining survivors: 1-Will, 2-Qiao, 3-Muhammad, 4-Ibrar, 5-Krystal, 6-Soham

Continue elimination? <press enter>

Qiao eliminated!
Remaining survivors: 1-Muhammad, 2-Ibrar, 3-Krystal, 4-Soham, 5-Will

Continue elimination? <press enter>

Ibrar eliminated!
Remaining survivors: 1-Krystal, 2-Soham, 3-Will, 4-Muhammad

Continue elimination? <press enter>

Soham eliminated!
Remaining survivors: 1-Will, 2-Muhammad, 3-Krystal

Continue elimination? <press enter>

Muhammad eliminated!
Remaining survivors: 1-Krystal, 2-Will

Continue elimination? <press enter>

Will eliminated!
Krystal is the last survivor!
*/