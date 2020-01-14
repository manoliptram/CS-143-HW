package HW_1.Inventory;

import java.util.*;
import java.io.*;

public class InventoryEngine {
	
	public static void main(String [] args)
	{
		Inventory inv = new ABCInventory();
		testInventory(inv);
		populate(inv, "alphabet.txt");
		System.out.println(inv);
	}
	
	public static void populate(Inventory inv, String fileName)
	{
		try
		{
			Scanner file = new Scanner(new File("G:\\School\\CS-143-Workspace\\CS-143-HW\\src\\HW_1\\Inventory\\data\\"
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
		inv.add('b');
		inv.subtract('A');
		inv.set('c', 23);
		
		System.out.println(inv);
		
		inv.set('a', 0);
		inv.set('b', 0);
		inv.set('c', 0);
	}
}