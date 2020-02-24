package hw5.implementingstackandqueue;

/*
MyQueue<E>()      Constructs a new queue with elements of type E 
add(E value)      Adds val to the back of the queue
remove()          Removes the first value from the queue; throws a NoSuchElementException if the queue is empty
isEmpty()         Returns true if the queue has no elements
size()            Returns the number of elements in the queue
 */

import java.util.*;

public class MyQueue<E>
{
	private ArrayList<E> queue;
	
	public MyQueue()
	{
		queue = new ArrayList<E>();
	}
	
	public void add(E value)
	{
		queue.add(value);
	}
	
	public void remove()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException("Queue is empty; can't remove.");
		}
		
		else
		{
			queue.remove(0);
		}
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public int size()
	{
		return queue.size();
	}
	
	public String toString()
	{
		return queue.toString();
	}
}