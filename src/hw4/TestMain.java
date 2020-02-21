package hw4;

import java.util.*;
import java.io.*;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(createPath(1, "something.txt"));
		
		System.out.println(createPath(5, "otherthing.text"));
	}
	
	public static String createPath(int fileDepth, String fileName)
	{
		return helper(fileDepth) + fileName;
	}
	
	private static String helper(int currentDepth)
	{
		if (currentDepth == 0)
		{
			return "";
		}
		
		return helper(currentDepth - 1) + "folder" + currentDepth + "/";
	}
	public Map<String, Integer> paintByNumber(Map<Integer, Integer> appearances,
			Map<Integer, String> colorVals)
	{
		TreeMap<String, Integer> occurencesByColor = new TreeMap<>();
		
		for (Integer key : colorVals.keySet())
		{
			if (appearances.containsKey(key))
			{
				occurencesByColor.put(colorVals.get(key), appearances.get(key));
			}
			
			else
			{
				occurencesByColor.put(colorVals.get(key), 0);
			}
		}
		
		ArrayList<String> maxEntry = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : occurencesByColor.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(occurencesByColor.get(maxEntry.get(0))) > 0)
		    {
		        maxEntry.clear();
		        maxEntry.add(entry.getKey());
		    }
		    
		    else if (entry.getValue().compareTo(occurencesByColor.get(maxEntry.get(0))) == 0)
		    {
		    	maxEntry.add(entry.getKey());
		    }
		}
		
		for (String s : maxEntry)
		{
			System.out.println(s + " has the most spaces to color!");
		}

		
		// print something here
		
		return occurencesByColor;
	}
}
