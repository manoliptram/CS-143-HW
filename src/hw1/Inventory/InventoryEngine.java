package hw1.Inventory;

import java.util.*;
import java.io.*;

public class InventoryEngine {
	
	public static void main(String [] args)
	{
		Inventory inv = new InventoryLog();
		testInventory(inv);
//		populate(inv, "alphabet.txt");
//		System.out.println(inv);
	}
	
	public static void populate(Inventory inv, String fileName)
	{
		try
		{
			Scanner file = new Scanner(new File("C:\\School\\CS-143-Workspace\\CS-143-HW\\src\\hw1\\Inventory\\data\\"
			+ fileName));
			
			while (file.hasNextLine())
			{
				String line = file.nextLine();
				for (int i = 0; i < line.length(); i++)
				{
					inv.add(line.charAt(i));
				}
			}
		}
		catch (FileNotFoundException fnf)
		{
			System.out.println(fnf.getMessage());
		}
	}
	
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
	}
}