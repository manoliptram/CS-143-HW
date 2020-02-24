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
}
