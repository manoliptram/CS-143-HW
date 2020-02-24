package hw5.exploringgenericsanditerators;

import java.util.*;

public class ExploringIterators
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		GrabBag<String> things = new GrabBag<>();
		populate(things, 5, rand);
		
//		System.out.println(things);
//		
//		for (String s : things)
//		{
//			System.out.println(s);
//		}
		
		Iterator<String> it = things.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	public static void populate(GrabBag<String> bag, int num, Random r)
	{
		for (int i = 0; i < num; i++)
		{
			bag.add("Thing-" + (r.nextInt(100) + 1));
		}
	}
}