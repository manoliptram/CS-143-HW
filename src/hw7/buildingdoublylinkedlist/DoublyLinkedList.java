package hw7.buildingdoublylinkedlist;

import java.util.Iterator;

public class DoublyLinkedList<E> implements Comparable<DoublyLinkedList<E>>, Iterable<E>, List<E>
{
	
	/* Instance Variable Declaration */
	
	// Pointer for the front of this DoublyLinkedList
	private ListNode<E> front;
	// Variable to keep track of the size of this DoublyLinkedList.
	// This is in place so that size() can have an O(1) runtime.
	private int size;

	/**
	 * Creates an empty DoublyLinkedList.
	 */
	public DoublyLinkedList()
	{
		front = null;
		size = 0;
	}

	/**
	 * Constructs a new DoublyLinkedList with a value for the starting node
	 * (no preceding or proceeding values).
	 * @param val
	 */
	public DoublyLinkedList(E val)
	{
		front = new ListNode<>(val, null, null);  
		size = 1;
	}

	/**
	 * Adds a new node to the end of the DoublyLinkedList
	 * with a given data value.
	 * @param val
	 */
	public void add(E val)
	{
		// Use the other add method to add a new node at the end of the list
		add(size, val);
	}

	/**
	 * Adds a new node at a given index with a given data value.
	 * @param index
	 * @param val
	 * @throws IndexOutOfBounds if the index is invalid (not in interval [0, size]).
	 */
	public void add(int index, E val)
	{
		// If index is not within [0, size], throw an IndexOutOfBoundsException
		if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException("Cannot add at Index " + index);
		}
		
		// Add to the size value of this DoublyLinkedList
		size++;
		
		// If the index is 0, set the front of the DoublyLinkedList
		// to a new ListNode with the appropriate data and using
		// the current front of the list as the next node.
		if (index == 0)
		{
			front = new ListNode<>(val, front, null);
		}
		else
		{
			// Iterate through the list to the desired index via a storage pointer
			ListNode<E> cur = front;
			for (int i = 0; i < index - 1; i++)
			{
				cur = cur.next;
			}
			
			// Create a new ListNode to insert in the correct space
			// with the desired data value
			ListNode<E> after = cur.next;
			ListNode<E> insert = new ListNode<>(val, after, cur);
			
			// Insert the new ListNode into the correct space
			cur.next = insert;
			
			// If there is another node that should come after the inserted node,
			// set the inserted node to precede the following node.
			if (after != null)
			{
				after.prev = insert;
			}
		}   
	}

	/**
	 * @param index
	 * @return The data at the virtual index given by "index".
	 * @throws IndexOutOfBounds if "index" is invalid (not within [0, size)).
	 */
	public E get(int index)
	{
		// If index is invalid for this DoublyLinkedList, throw an IndexOutOfBoundsException
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
		}
		
		// Iterate through to the desired index via a storage pointer
		ListNode<E> cur = front;
		for (int i = 0; i < index - 1; i++)
		{
			cur = cur.next;
		}
		
		// Return the data associated with the ListNode at the desired index
		return cur.data;   
	}

	/**
	 * @param val to be found in the DoublyLinkedList.
	 * @return The virtual index of val, or -1 if not found.
	 */
	public int indexOf(E val)
	{
		// Iterate through the values in the DoublyLinkedList,
		// keeping track of the current index.
		Iterator<E> itr = iterator();
		int index = 0;
		while (itr.hasNext())
		{
			// If the value at the current index is equal to
			// the desired value, return the current index.
			E cur = itr.next();
			if (cur == val)
			{
				return index;
			}
			
			// If the return condition was not met, add to the
			// value of the current index and continue iteration
			// through the DoublyLinkedList.
			index++;
		}
		
		// If the desired value was not found, return -1.
		return -1;
	}


	/**
	 * Removes the node at a given index in the DoublyLinkedList.
	 * @param index
	 * @return The removed value.
	 * @throws IndexOutOfBounds if "index" is invalid (not in interval [0, size)).
	 */
	public E remove(int index)
	{
		// If index is invalid, throw an IndexOutOfBoundsException
		if (index > size - 1 || index < 0)
		{
			throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
		}
		
		// Subtract from the size of the list
		size--;
		
		if (index == 0)
		{
			// If the index is 0, manipulate the front of the list directly.
			// Pull the data from the front of the list.
			E data = front.data;
			
			// If there are no proceeding terms in the list,
			// make the front node null and return the pulled data.
			if (front.next == null)
			{
				front = null;
				return data;
			}
			
			// Otherwise, set the front node to the proceeding term,
			// then set its preceeding term to 0 and return the pulled data.
			else
			{
				front = front.next;
				front.prev = null;
				return data;
			}
		}
		else
		{
			// If the index is not 0, use a storage pointer to manipulate the list.
			
			// Iterate through to the node just before the desired index via the storage pointer.
			ListNode<E> cur = front;
			for (int i = 0; i < index - 1; i++)
			{
				cur = cur.next;
			}
			
			// Pull the data from the node at the desired index.
			E data = cur.next.data;
			
			// If there is no proceeding term for the desired index,
			// make the node at the desired index null and
			// return the pulled data.
			if (cur.next.next == null)
			{
				cur.next = null;
				return data;
			}
			
			// Otherwise, make the node at the desired index
			// equal to its proceeding term, then
			// return the pulled data.
			else
			{
				cur.next = cur.next.next;
				return data;
			}
		}
	}

	// TOGETHER: Allows DoublyLinkedLists to be compared/sorted
	/**
	 * Compares two DoublyLinkedLists by the number of items in each list.
	 * @param other
	 * @return A positive number if this has more items,
	 * a negative number if other has more items,
	 * and 0 if both lists have the same number of items.
	 */
	public int compareTo(DoublyLinkedList other)
	{
		return size - other.size();
	}

	// TOGETHER: Allows DoublyLinkedLists to be checked for equality
	/**
	 * Checks if two DoublyLinkedLists have the same number of items.
	 * @param other
	 * @return If this and other have the same number of items.
	 */
	public boolean equals(DoublyLinkedList other)
	{
		return compareTo(other) == 0;
	}

	// Returns the number of nodes in the list
	// O(1) because continuously tracked during construct/add/remove
	public int size()
	{
		return size;
	}

	// Returns a String representation of this data
	public String toString()
	{
		// If there are no items in this list, return "[]".
		if (size() == 0)
		{
			return "[]";
		}

		// Iterate through the list via a storage pointer
		StringBuilder build = new StringBuilder();
		ListNode<E> cur = front;
		while(cur.next != null)
		{
			// Add the data from each node to the return String as it is pulled through iteration
			build.append(cur.data + ", ");
			cur = cur.next;
		}
		build.append(cur.data);
		// Return the built return String alongside data about the size of this DoublyLinkedList
		return "[" + build.toString() + "] size=" + size();
	}

	// Returns an iterator to this DoublyLinkedList
	public Iterator<E> iterator()
	{ 
		return new DLLIterator(); 
	}

	// TOGETHER: Create an iterator for this DoublyLinkedList
	private class DLLIterator implements Iterator<E>
	{
		// TOGETHER: field to track the linked list node we have currently iterated to
		private ListNode<E> cur;
		
		public DLLIterator()
		{
			cur = front;
		}

		// TOGETHER: is there another node?
		public boolean hasNext()
		{ 
			return cur != null;
		}

		// TOGETHER: return the next piece of data in the DoublyLinkedList
		public E next()
		{
			if (!hasNext())
			{
				throw new NullPointerException("There are no more elements in the DoublyLinkedList.");
			}
			
			E data = cur.data;
			cur = cur.next;
			return data;
		}

		public void remove()
		{
			throw new UnsupportedOperationException("You should not remove using the Iterator.");
		}
	}
}