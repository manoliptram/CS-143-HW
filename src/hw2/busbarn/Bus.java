package hw2.busbarn;

public class Bus implements Comparable<Bus>
{
	// class variable
	private static int nextID = 1;

	// instance variables / fields
	private int number;
	private int route;

	public Bus() {
		this.number = nextID++;
		this.route = 0;
	}  

	public int getNumber()
	{
		return this.number;
	}
	
	public int getRoute()
	{
		return this.route;
	}
	
	public void setRoute(int route)
	{
		this.route = route;
	}

	public String toString()
	{
		return "BUS #" + this.number + " traveling ROUTE #" + this.route;
	}
	
	public int compareTo(Bus b)
	{
		if (getNumber() == b.getNumber())
		{
			return 0;
		}
		
		return (getNumber() - b.getNumber()) / Math.abs(getNumber() - b.getNumber());
	}
}