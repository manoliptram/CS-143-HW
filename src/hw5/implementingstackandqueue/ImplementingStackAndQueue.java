package hw5.implementingstackandqueue;

import java.util.*;

public class ImplementingStackAndQueue {

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
//		Stack<Integer> stack = new Stack<>();
		MyQueue<Integer> queue = new MyQueue<>();
//		Queue<Integer> queue = new LinkedList<>();

		Random r = new Random();
		Scanner console = new Scanner(System.in);

		String again = "";
		do {
			System.out.print("add, remove, or end? > ");
			again = console.nextLine().toLowerCase();
			if(again.startsWith("a")) {
				int x = r.nextInt(1000) + 1;
				stack.push(x);
				queue.add(x);
			}
			else if(again.startsWith("r")) {
				stack.pop();
				queue.remove();
			}
			System.out.println("stack = " + stack);
			System.out.println("queue = " + queue);
			
			if (!stack.isEmpty())
			{
				System.out.println("Top of stack = " + stack.peek());
			}
			else
			{
				System.out.println("Stack is empty.");
			}
		} while(again.startsWith("a") || again.startsWith("r"));

	}

}