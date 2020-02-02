package HW_2.setandmap;

import java.util.*;

public class ListSet
{
	private ArrayList<Integer> data;

	public ListSet() {
		data = new ArrayList<>();
	}

	public void add(int val)
	{
		if (!data.contains(val))
		{
			data.add(val);
		}
	}

	public boolean contains(int val)
	{
		return data.contains(val);
	}

	public void remove(int val)
	{
		data.remove(val);
	}

	public void clear()
	{
		data.clear();
	}

	public int size()
	{
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public String toString() {
		return data.toString();
	}

}