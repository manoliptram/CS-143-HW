package hw7.reviewinglistnodeandlinkedlist;

public class LinkedIntListV2
{
	private ListNode<Integer> front;
	private int size;

	public LinkedIntListV2()
	{
		front = null;
		size = 0;
	}

	public LinkedIntListV2(int val)
	{
		front = new ListNode<>(val, null);  
		size = 1;
	}

	public int get(int index)
	{
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
		}
		ListNode<Integer> cur = front;
		for (int i = 0; i < index; i++)
		{
			cur = cur.next;
		}

		return cur.data;
	}

	public void set(int index, int val)
	{
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException("Cannot add value " + val + " to LinkedIntList at index " + index + ".");
		}

		ListNode<Integer> cur = front;

		for (int i = 0; i < index; i++)
		{
			cur = cur.next;
		}

		cur.data = val;
	}

	public void add(int index, int val)
	{
		if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException("Cannot add value " + val + " to LinkedIntList at index " + index + ".");
		}

		ListNode<Integer> cur = front;

		if (index == 0)
		{
			ListNode<Integer> insert = new ListNode<>(val, front);
			front = insert;
			size++;
		}

		else
		{
			for (int i = 0; i < index - 1; i++)
			{
				cur = cur.next;
			}

			ListNode<Integer> insert = new ListNode<>(val, cur.next);
			cur.next = insert;
			size++;
		}
	}

	public int remove(int index)
	{
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException("No data at index " + index + " to remove.");
		}

		if (index == 0)
		{
			int ret = front.data;
			front = null;
			size--;
			return ret;
		}

		ListNode<Integer> cur = front;
		for (int i = 0; i < index - 1; i++)
		{
			cur = cur.next;
		}

		int ret = cur.next.data;
		cur.next = cur.next.next;
		size--;
		return ret;
	}

	public void addFront(int val)
	{
		front = new ListNode<>(val, front);
		size++;
	}

	public void addEnd(int val)
	{
		ListNode<Integer> cur = front;
		while(cur.next != null)
		{
			cur = cur.next;
		}
		cur.next = new ListNode<>(val);
		size++;
	}

	public int removeFront()
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException("Nothing to remove.");
		}
		else
		{
			int save = front.data;
			front = front.next;
			size--;
			return save;
		}
	}

	public int removeEnd()
	{
		if(size() == 0)
		{
			throw new IllegalArgumentException("Nothing to remove.");
		}
		else if(size() == 1)
		{
			return removeFront();
		}
		else
		{
			ListNode<Integer> cur = front;
			while(cur.next.next != null)
			{
				cur = cur.next;
			}
			int save = cur.next.data;
			cur.next = null;
			size--;
			return save;
		}
	}

	public boolean contains(int val)
	{
		ListNode<Integer> cur = front;
		while(cur != null)
		{
			if(cur.data == val)
			{
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	public int size()
	{
		return size;
	}

	public String toString()
	{
		if(size() == 0)
		{
			return "[]";
		}

		StringBuilder build = new StringBuilder();
		ListNode<Integer> cur = front;
		while(cur.next != null)
		{
			build.append(cur.data + ", ");
			cur = cur.next;
		}
		build.append(cur.data);
		return "[" + build.toString() + "]";
	}
}