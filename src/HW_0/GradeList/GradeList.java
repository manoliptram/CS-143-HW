// Manoli Tramountanas
// CS 143
// HW Core Topics: Fundamentals of ArrayList

// This program will test a custom class, GradeList,
// which is designed to read and store a list of grades of unspecified length
// and perform specified tasks related to the list.

package HW_0.GradeList;

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Storage object for a list of grades.
 * 
 * @author Manoli Tramountanas
 *
 */
public class GradeList
{
	private List<Double> grades;

	/**
	 * Constructs a new GradeList object.
	 */
	public GradeList()
	{
		grades = new ArrayList<Double>();
	}

	/**
	 * Reads grades from a given file in this subpackage.
	 * @param fileName
	 */
	public void readGrades(String fileName)
	{
		try
		{
			File file = new File("C:\\Users\\Manoli Tramountanas\\Desktop\\School Documents\\Computer Science 143\\Classwork\\HW\\src\\HW_0\\GradeList\\" + fileName);
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextDouble())
			{
				grades.add(sc.nextDouble());
			}
		}
		catch (FileNotFoundException fnf)
		{
			System.out.println(fnf.getMessage());
		}
	}

	/**
	 * Calculates the average of all grades within the GradeList.
	 * @return the average of all grades within the GradeList.
	 */
	public double calcAverage()
	{
		if (grades.size() == 0)
		{
			return 0.0;
		}
		
		double average = 0;
		
		for (int i = 0; i < grades.size(); i++)
		{
			average += grades.get(i);
		}
    	
		average = average / grades.size();
		
		return average;
	}

	/**
	 * Drops the lowest grade in the GradeList.
	 * If multiple grades are tied for the lowest,
	 * removes all of those grades.
	 * If there are no grades in the GradeList,
	 * returns the maximum value of a double.
	 * @return The value of the removed lowest grade(s).
	 */
	public double dropLowest()
	{
		if (grades.size() == 0)
		{
			return Double.MAX_VALUE;
		}
		
		double lowestGrade = 0.0;
    	
		for (int i = 0; i < grades.size(); i++)
		{
			if (i == 0)
			{
				lowestGrade = grades.get(i);
			}
			else if (grades.get(i) < lowestGrade)
			{
				lowestGrade = grades.get(i);
			}
		}
		
		removeAllGrades(lowestGrade);
    	
		return lowestGrade;
	}

	/**
	 * Adds a given grade to the GradeList.
	 * @param grade
	 */
	public void addGrade(double grade)
	{
		grades.add(grade);
	}

	/**
	 * Removes all instances of a given grade from the GradeList.
	 * @param grade
	 * @return If the given grade was found in the GradeList.
	 */
	public boolean removeAllGrades(double grade)
	{
		boolean found = false;
		
		for (int i = 0; i < grades.size(); i++)
		{
			if (grades.get(i) == grade)
			{
				found = true;
				grades.remove(i);
				i--;
			}
		}
		
		return found;
	}

	/**
	 * Prints all grades in the GradeList in order from lowest to highest.
	 */
	public void printSortedGrades()
	{
		List<Double> sortedGrades = new ArrayList<Double>();
		
		for (int i = 0; i < grades.size(); i++)
		{
			sortedGrades.add(grades.get(i));
		}
		
		sortedGrades.sort(null);
		
		String sortedString = "[";
		
		for (int i = 0; i < sortedGrades.size(); i++)
		{
			sortedString += sortedGrades.get(i) + ", ";
		}
		
		sortedString = sortedString.substring(0, sortedString.length()-2);
		sortedString += "]";
		
		System.out.println(sortedString);
	}

	/**
	 * @return A string in the format of "[Grade 1, Grade 2, ..., Grade n]"
	 * for this GradeList containing n grades.
	 */
	public String toString()
	{
		if (grades.size() == 0)
		{
			return "[]";
		}
		
		String gradesString = "[";
		
		for (int i = 0; i < grades.size(); i++)
		{
			gradesString += grades.get(i) + ", ";
		}
		
		gradesString = gradesString.substring(0, gradesString.length()-2);
		gradesString += "]";
		
		return gradesString;
	}
}
/* Output
*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 1
Enter a filename to read the grades from:
grades.dat
***** Reading in grades from grades.dat *****

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 5
[98.0, 100.0, 70.0, 84.0, 50.0, 99.0, 91.0, 92.0]

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 2
Enter a grade to add: 60.0
***** Adding grade 60.0 *****

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 6
[50.0, 60.0, 70.0, 84.0, 91.0, 92.0, 98.0, 99.0, 100.0]

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 3
Enter a grade to remove: 99.0
***** Removed ALL occurances of 99.0 *****

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 5
[98.0, 100.0, 70.0, 84.0, 50.0, 91.0, 92.0, 60.0]

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 4
Lowest grade dropped: 50.0

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 5
[98.0, 100.0, 70.0, 84.0, 91.0, 92.0, 60.0]

*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 7
Average is 85.00
*************************************
1. Read grades from file
2. Add grade
3. Remove all grades
4. Drop lowest grade
5. Display grades
6. Sort grades
7. Calculate average
8. Exit
*************************************

Enter your numerical choice: 8
Goodbye!
 */
