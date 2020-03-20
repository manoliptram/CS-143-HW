package hw8.josephus;

import java.util.*;

public class JosephusDriver
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		String filePath = "G:\\School\\CS-143-Workspace\\CS-143-HW\\src\\hw8\\josephus\\";
		JosephusSim simulation = new JosephusSim(filePath + "people.txt");

		while (!simulation.isOver())
		{
			System.out.println(simulation);
			System.out.println("\nContinue elimination? <press enter>");
			console.nextLine(); // make the user hit enter to continue
			simulation.eliminate();
		}

		System.out.println(simulation);
	}

}