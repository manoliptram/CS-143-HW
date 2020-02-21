package hw5.jobsimulation;

import java.util.*;

public class JobSim
{
	
	Stack<String> workers = new Stack<>();
	Queue<String> waitlist = new LinkedList<String>();
	
	Set<String> mySet = new HashSet<String>();
	
	public JobSim(int workers, int jobs)
	{
		for (int i = 1; i <= workers; i++)
		{
			if (this.workers.size() < jobs)
			{
				this.workers.add("Worker " + i);
			}
			
			else
			{
				waitlist.add("Worker " + i);
			}
		}
	}

	public String toString()
	{
		String ret = "Employed:\n";
		Iterator<String> i1 = workers.iterator();
		while(i1.hasNext())
		{
			String next = i1.next();
			if (i1.hasNext())
			{
				ret += next + ", ";
			}
			
			else
			{
				ret += next + ".\n";
			}
		}
		
		ret += "Waitlisted:\n";
		Iterator<String> wait = waitlist.iterator();
		
		while (wait.hasNext())
		{
			ret += wait.next();
			
			if (!wait.hasNext())
			{
				ret += ".";
			}
			else
			{
				ret += ", ";
			}
		}
		
		return ret;
	}

	public void cycle()
	{
		Random r = new Random();
		
		int nSided = (waitlist.size() > workers.size()) ? workers.size() : waitlist.size();
		int dieRoll = r.nextInt(nSided) + 1;
		
		ArrayList<String> hired = new ArrayList<>();
		ArrayList<String> fired = new ArrayList<>();
		
		for (int i = 0; i < dieRoll; i++)
		{
			String hire = waitlist.poll();
			String fire = workers.pop();
			
			hired.add(hire);
			fired.add(fire);
		}
		
		for (int i = 0; i < dieRoll; i++)
		{
			waitlist.add(fired.get(i));
			workers.add(hired.get(i));
		}
	}
}