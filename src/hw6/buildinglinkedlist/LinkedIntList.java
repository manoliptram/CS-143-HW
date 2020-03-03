package hw6.buildinglinkedlist;

public class LinkedIntList
{
	private ListNode<Integer> front;

	public LinkedIntList()
	{
		front = null;
	}

	public LinkedIntList(int val)
	{
		front = new ListNode<>(val, null);  
	}

	public void addFront(int val)
	{
		front = new ListNode<Integer>(val, front);
	}

	public void addEnd(int val)
	{
		if (front == null)
		{
			front = new ListNode<Integer>(val);
		}
		
		else if (front.next == null)
		{
			front.next = new ListNode<Integer>(val);
		}
		
		else
		{
			ListNode<Integer> temp = front.next;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new ListNode<Integer>(val);
		}
	}

	public int removeFront()
	{
		int removed = front.data;
		front = front.next;
		return removed;
	}

	public int removeEnd()
	{
		int removed;
		
		if (front == null)
		{
			return 0;
		}
		
		if (front.next == null)
		{
			removed = front.data;
			front = null;
			return removed;
		}
		
		ListNode<Integer> temp = front;
		while (temp.next.next != null)
		{
			temp = temp.next;
		}
		removed = temp.next.data;
		temp.next = null;
		return removed;
	}

	public boolean contains(int val)
	{
		ListNode<Integer> temp = front;
		while(temp != null)
		{
			if (temp.data == val)
			{
				return true;
			}
			temp = temp.next;
		}
		
		return false;
	}

	public int size()
	{
		ListNode<Integer> temp = front;
		int size = 0;
		while(temp != null)
		{
			size++;
			temp = temp.next;
		}
		
		return size;
	}

	public String toString()
	{
		String ret = "[";
		ListNode<Integer> temp = front;
		while (temp != null)
		{
			ret += temp.data;
			
			if (temp.next != null)
			{
				ret += ", ";
			}
			
			temp = temp.next;
		}
		ret += "]";
		return ret;
	}
}
/* Output:
[] size=0

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > af
Add what? > 2
[2] size=1

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > af
Add what? > 3
[3, 2] size=2

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > ae
Add what? > 5
[3, 2, 5] size=3

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > rf
Removed 3
[2, 5] size=2

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > re
Removed 5
[2] size=1

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > re
Removed 2
[] size=0

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > c
Contains what? > 
4
List does not contain 4
[] size=0

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > af
Add what? > 5
[5] size=1

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > c
Contains what? > 
5
List contains 5
[5] size=1

Options: (af) add to front (ae) add to end (rf) remove front (re) remove end (c) contains (d) done
What do? > d
[5] size=1
 */