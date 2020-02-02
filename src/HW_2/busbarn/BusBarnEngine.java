package HW_2.busbarn;

import java.util.*;
import java.io.*;

public class BusBarnEngine
{

	public static void main(String[] args)
	{
		Random rand = new Random();
		Set<Bus> barn = new TreeSet<>();
		Map<Integer,String> routes = new HashMap<>();

		addBuses(barn, rand);
		setRoutes(routes, "routes.txt");
//		printBarn(barn);
		printBarnRoutes(barn, routes);
	}

	public static void addBuses(Set<Bus> barn, Random r)
	{
		// Adds 1-10 busses (randomly determined) to the bus barn
		int bussesToAdd = r.nextInt(10) + 1;
		
		for (int i = 0; i < bussesToAdd; i++)
		{
			Bus b = new Bus();
			// Sets route to random number between 100 and 130 (inclusive)
			b.setRoute(r.nextInt(31) + 100);
			barn.add(b);
		}
	}

	public static void printBarn(Set<Bus> barn)
	{
		System.out.println("\nBuses at the Bus Barn");
		System.out.println("=====================");
		for(Bus b : barn) {
			System.out.println(b);
		}
		
		if(barn.isEmpty())
		{
			System.out.println("The bus barn is empty!");
		}
	}

	public static void setRoutes(Map<Integer,String> routes, String fileName)
	{
		try
		{
			Scanner file = new Scanner(new File("G:\\School\\CS-143-Workspace\\CS-143-HW\\src\\HW_2\\busbarn\\"
					+ fileName));
			while (file.hasNextInt())
			{
				int routeNum = file.nextInt();
				//removes empty next line character
				String trash = file.nextLine();
				String route = file.nextLine();
				routes.put(routeNum, route);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(fileName + " not found.");
		}
	}
	
	public static void printBarnRoutes(Set<Bus> barn, Map<Integer, String> routes)
	{
		System.out.println("Buses at the Bus Barn");
		System.out.println("=====================");
		
		for (Bus b : barn)
		{
			System.out.print(b);
			
			if (routes.containsKey(b.getRoute()))
			{
				System.out.print(" (" + routes.get(b.getRoute()) + ")");
			}
			
			System.out.println();
		}
	}

}