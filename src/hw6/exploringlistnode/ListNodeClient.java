package hw6.exploringlistnode;

import hw6.buildinglinkedlist.ListNode;

public class ListNodeClient {
	public static void main(String[] args) {
		System.out.println("example1");
		example1();
		System.out.println("\nexample2");
		example2();
		System.out.println("\nexample3");
		example3();
		System.out.println("\nexample4");
		example4();
		System.out.println("\nexample5");
		example5();
	}

	public static void example1() {
		//      ListIntNode node1 = new ListIntNode(1);
		//      ListIntNode node2 = new ListIntNode(2, node1);
		//      ListIntNode list = new ListIntNode(3, node2);
		// list -> 3 -> 2 -> 1 -> /
		ListNode<Integer> node1 = new ListNode<>(1);
		ListNode<Integer> node2 = new ListNode<>(2, node1);
		ListNode<Integer> list = new ListNode<>(3, node2);
		System.out.println("list -> " + recursivePrintNodes(list));

//		ListIntNode temp = new ListIntNode(4, new ListIntNode(5));
		ListNode<Integer> temp = new ListNode<>(4, new ListNode<Integer>(5));
		
		// temp -> 4 -> 5 -> /
		System.out.println("temp -> " + recursivePrintNodes(temp));

		// list -> 3 -> 2 -> 1 -> 4 -> 5 -> /
//		ListIntNode n1a = new ListIntNode(4, new ListIntNode(5));
//		ListIntNode n2a = new ListIntNode(1, n1a);
//		ListIntNode n3a = new ListIntNode(2, n2a);
//		ListIntNode listA = new ListIntNode(3, n3a);
		
		ListNode<Integer> n1a = new ListNode<Integer>(4, new ListNode<Integer>(5));
		ListNode<Integer> n2a = new ListNode<Integer>(1, n1a);
		ListNode<Integer> n3a = new ListNode<Integer>(2, n2a);
		ListNode<Integer> listA = new ListNode<Integer>(3, n3a);
		System.out.println("list -> " + recursivePrintNodes(listA));

		// list -> 2 -> 1 -> 4 -> 5 -> /
//		ListIntNode n1b = n1a;
//		ListIntNode n2b = new ListIntNode(1, n1b);
//		ListIntNode listB = new ListIntNode(2, n2b);
		
		ListNode<Integer> n1b = n1a;
		ListNode<Integer> n2b = new ListNode<Integer>(1, n1b);
		ListNode<Integer> listB = new ListNode<Integer>(2, n2b);
		System.out.println("list -> " + recursivePrintNodes(listB));

		// list -> 2 -> 4 -> /
		// ListIntNode listC = new ListIntNode(2, new ListIntNode(4));
		ListNode<Integer> listC = new ListNode<Integer>(2, new ListNode<Integer>(4));
		System.out.println("list -> " + recursivePrintNodes(listC));

		// list -> /
//		ListIntNode listD = new ListIntNode();
		ListNode<Integer> listD = new ListNode<>();
		System.out.println("list -> " + recursivePrintNodes(listD.next));
	}

	public static void example2() {
		ListIntNode list = new ListIntNode(10, null);
		list.next = new ListIntNode(11);
		list.next.next = new ListIntNode(12);
		// list -> 10 -> 11 -> 12 -> /
		System.out.println("list -> " + printNodes(list));

		ListIntNode list1 = new ListIntNode(9, null);
		list1.next = new ListIntNode(10);
		list1.next.next = new ListIntNode(11);
		list1.next.next.next = new ListIntNode(12);
		list1.next.next.next.next = new ListIntNode(13);
		list1.next.next.next.next.next = new ListIntNode(14);
		// list -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> /
		System.out.println("list -> " + printNodes(list1));
	}

	public static void example3() {
		ListIntNode list = new ListIntNode(20, new ListIntNode(30, new ListIntNode(40)));
		// list -> 20 -> 30 -> 40 -> /
		System.out.println("list -> " + printNodes(list));

		// list -> 40 -> 30 -> 20 -> /
		ListIntNode list1 = new ListIntNode(40, new ListIntNode(30, new ListIntNode(20)));
		System.out.println("list -> " + printNodes(list1));
	}

	public static void example4() {
		ListNode<Integer> list = new ListNode<>(111);
		list.next = new ListNode<Integer>(222);
		list = new ListNode<Integer>(333, list);
		// list -> 333 -> 111 -> 222 -> /
		System.out.println("list -> " + recursivePrintNodes(list));

		// list -> 111 -> 333 -> 222 -> /
		ListNode<Integer> list1 = new ListNode<>(333);
		list1.next = new ListNode<Integer>(222);
		list1 = new ListNode<Integer>(111, list1);
		System.out.println("list -> " + recursivePrintNodes(list1));
	}

	public static void example5() {
		ListNode<String> list1 = new ListNode<>("lake", new ListNode<String>("river", new ListNode<String>("ocean")));
		// list1 -> lake -> river -> ocean -> /
		System.out.println("list1 -> " + recursivePrintNodes(list1));

		ListNode<String> list2 = new ListNode<>("sky", new ListNode<String>("mountain", new ListNode<String>("canyon")));
		// list2 -> sky -> mountain -> canyon -> /
		System.out.println("list2 -> " + recursivePrintNodes(list2));

		// list1 -> lake -> sky -> river -> mountain -> ocean -> canyon -> /
		ListNode<String> list3 = new ListNode<>("lake", new ListNode<String>("sky", new ListNode<String>("river", new ListNode<String>("mountain", new ListNode<String>("ocean", new ListNode<String>("canyon"))))));
		System.out.println("list3 -> " + recursivePrintNodes(list3));
	}

	public static String printNodes(ListIntNode list) {
		String str = "";
		while(list != null) {
			str += list.data + " -> ";
			list = list.next;
		}
		return str + "/";
	}

	public static <E> String recursivePrintNodes(ListNode<E> list) {
		if(list == null)
			return "/";
		else
			return list.data + " -> " + recursivePrintNodes(list.next);
	}
}
/* Output:
example1
list -> 3 -> 2 -> 1 -> /
temp -> 4 -> 5 -> /
list -> 3 -> 2 -> 1 -> 4 -> 5 -> /
list -> 2 -> 1 -> 4 -> 5 -> /
list -> 2 -> 4 -> /
list -> /

example2
list -> 10 -> 11 -> 12 -> /
list -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> /

example3
list -> 20 -> 30 -> 40 -> /
list -> 40 -> 30 -> 20 -> /

example4
list -> 333 -> 111 -> 222 -> /
list -> 111 -> 333 -> 222 -> /

example5
list1 -> lake -> river -> ocean -> /
list2 -> sky -> mountain -> canyon -> /
list3 -> lake -> sky -> river -> mountain -> ocean -> canyon -> /
 */