// Manoli Tramountanas
// CS 143
// HW Core Topics: Fundamentals of ArrayList

// This program will test a custom class, ArrayIntList,
// which is designed to function almost identically to ArrayList
// (albeit with less functionality).

package hw0.ArrayIntList;

/**
 * The main class for this program.
 * @author Manoli Tramountanas
 *
 */
public class ExploringArrayList
{
	public static void main(String[] args)
	{
		ArrayIntList myList = new ArrayIntList();
		
		// Anticipated output: 0
		System.out.println(myList.size());
		
		for (int i = 1; i <= 21; i++)
		{
			myList.add(i*10);
		}
		
		// Anticipated output: [10, 20, ..., 210]
		System.out.println(myList.toString());
		
		myList.add(3, 42);
		// Anticipated output: [10, 20, 30, 42, 40, ..., 210]
		System.out.println(myList.toString());
		// Anticipated output: 42
		System.out.println(myList.get(3));
		// Anticipated output: 3
		System.out.println(myList.indexOf(42));
		
		myList.remove(3);
		// Anticipated output: [10, 20, ..., 210]
		System.out.println(myList.toString());
	}
}
/* Output:
0
[10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210]
[10, 20, 30, 42, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210]
42
3
[10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210]
 */

// translation from array to ArrayList:
//    String[]          => ArrayList<String>
//    new String[10]    => new ArrayList<String>()
//    a.length          => list.size()
//    a[i]              => list.get(i)
//    a[i] = value;     => list.set(i, value);
// new operations:
//     list.remove(i);     --remove the ith value
//     list.add(value);    --appends a value
//     list.add(i, value); --adds at an index
//     list.clear()        --remove all value