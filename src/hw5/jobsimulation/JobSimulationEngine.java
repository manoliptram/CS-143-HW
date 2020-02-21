package hw5.jobsimulation;

import java.util.*;

public class JobSimulationEngine
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		// Start a simulation with 10 workers, 6 jobs
		JobSim simulation = new JobSim(10, 6);
		System.out.println("As the simulation begins");
		System.out.println(simulation);

		String again = "";
		do
		{
			simulation.cycle();
			System.out.println();
			System.out.println(simulation);
			System.out.print("Press enter to cycle, anything else to quit...");
			again = console.nextLine();
		} while(again.equals(""));

		System.out.println("Simulation Ended");
	}
}
