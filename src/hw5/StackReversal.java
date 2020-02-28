package hw5;

import java.util.*;

public class StackReversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		
		s.add(3);
		s.add(5);

		insertAtBottom(4, s);

		System.out.println(s);

		s = reverse(s);

		System.out.println("Reversed: " + s);
	}

	public static void insertAtBottom(int val, Stack<Integer> s)
	{
		if (s.isEmpty())
		{
			s.add(val);
			return;
		}

		int temp = s.pop();
		insertAtBottom(val, s);
		s.add(temp);
	}

	private static Stack<Integer> reverse(Stack<Integer> s)
	{
		if (s.size() == 0)
		{
			return new Stack<Integer>();
		}
		int temp = s.pop();
		Stack<Integer> ret = reverse(s);
		ret.add(0, temp);
		return ret;
	}
}
