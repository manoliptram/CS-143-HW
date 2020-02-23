package hw5.exploringgenericsanditerators;

import java.util.*;

public class ExploringGenerics {

	public static void main(String[] args) {
		ArrayIntList numbers = new ArrayIntList();
		//MyArrayList<Integer> numbers = new MyArrayList<>();

		System.out.println(numbers);
		for(int i = 1; i <= 5; i++) {
			numbers.add(i * 100);
		}
		System.out.println(numbers);
		numbers.add(25);
		numbers.remove(0);
		numbers.remove(3);
		System.out.println(numbers);
	}

}