// Manoli Tramountanas
// CS 143
// HW Core Topics: Fundamentals of ArrayList

// This program will test a custom class, ArrayIntList,
// which is designed to function almost identically to ArrayList
// (albeit with less functionality).

package HW_0.ArrayIntList;

public interface IntList {
	public void add(int value);
	public String toString();
	
	public int size();
	public int get(int index);
	public int indexOf(int value);
	
	public void add(int index, int value);
	public void remove(int index);
}