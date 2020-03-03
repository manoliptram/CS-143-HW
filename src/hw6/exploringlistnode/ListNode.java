package hw6.exploringlistnode;

// ListNode is a class for storing a single node of a linked list.
// It has two public data fields for 1) the data and 2) the link
// to the next node in the list.

public class ListNode<E> {
	public E data;          // data stored in this node
	public ListNode<E> next;  // link to next node in the list

	// post: constructs a node with null data and null link
	public ListNode() {
		this(null, null);
	}

	// post: constructs a node with given data and null link
	public ListNode(E data) {
		this(data, null);
	}

	// post: constructs a node with given data and given link
	public ListNode(E data, ListNode<E> next) {
		this.data = data;
		this.next = next;
	}
}