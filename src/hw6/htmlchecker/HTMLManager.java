// Manoli Tramountanas
// CS 143
// HW Core Topics: Stacks and Queues
// 
// This program will check a sequential series
// of HTML tags and fix that series such that
// the series demonstrates valid HTML syntax.

package hw6.htmlchecker;

import java.util.*;

public class HTMLManager
{
	private Queue<HTMLTag> tags;

	/**
	 * Constructs a new HTMLManager.
	 * @param html The queue of HTMLTags to manage.
	 */
	public HTMLManager(Queue<HTMLTag> html)
	{
		// Throw an IllegalArgumentException if the given queue is null
		if (html == null)
		{
			throw new IllegalArgumentException("Cannot construct an HTML Manager with a null queue of HTMLTags.");
		}
		else
		{
			tags = html;
		}
	}

	/**
	 * @return The current queue of HTMLTags for this instance of HTMLManager.
	 */
	public Queue<HTMLTag> getTags()
	{
		return tags;
	}

	public String toString()
	{
		String ret = "";
		// Iterate through the current queue of HTMLTags
		Iterator<HTMLTag> itr = tags.iterator();
		while(itr.hasNext())
		{
			// Add the trimmed version of each tag to the return string
			ret += itr.next().toString().trim();
		}

		return ret;
	}

	/**
	 * Fixes the given queue of HTMLTags to conform to proper HTML syntax.
	 */
	public void fixHTML()
	{
		// Stack for polled opening tags
		Stack<HTMLTag> unclosedOpeners = new Stack<>();
		// Queue that will eventually replace "tags"
		Queue<HTMLTag> newTags = new LinkedList<HTMLTag>();
		// Iterator for the current queue of HTMLTags
		Iterator<HTMLTag> itr = tags.iterator();

		// Iterate through the current queue of HTMLTags
		while(itr.hasNext())
		{
			HTMLTag temp = itr.next();
			
			// For an opening tag, add a copy to the stack to remember to close it,
			// then add it to the new queue
			if (temp.isOpening())
			{
				unclosedOpeners.add(temp);
				newTags.add(temp);
			}
			// Possible cases for a closing tag
			if (temp.isClosing())
			{
				// Proceed if the stack isn't empty
				// If it is, the closing tag shouldn't be added to the new queue
				if (!unclosedOpeners.isEmpty())
				{
					// Pop the last opening tag from the stack
					HTMLTag lastOpening = unclosedOpeners.pop();
					// If the previous opening tag from the stack matches this closing tag,
					// add the closing tag to the new queue
					if (lastOpening.matches(temp))
					{
						newTags.add(temp);
					}
					// Otherwise, add the correct closing tag to the new queue
					else
					{
						newTags.add(lastOpening.getMatching());
					}
				}
			}
			// For a self-closing tag, simply add it to the new queue
			if (temp.isSelfClosing())
			{
				newTags.add(temp);
			}
			
			itr.remove();
		}

		// Change the iterator to iterate through the stack of unclosed opening tags
		itr = unclosedOpeners.iterator();

		// Iterate through the unclosed opening tags
		while(itr.hasNext())
		{
			// For each unclosed opening tag,
			// add the corresponding closing tag to the new queue,
			// then remove that opening tag from the stack
			newTags.add(itr.next().getMatching());
			itr.remove();
		}

		// Reset "tags" to the new, fixed queue
		tags = newTags;
	}
}
/* Output:
===============================
Processing C:\Users\Manoli Tramountanas\Desktop\School Documents\Computer Science 143\Classwork\HW\src\hw6\htmlchecker\tests\test1.html...
===============================
HTML: <b><i><br /></b></i>
Checking HTML for errors...
HTML after fix: <b><i><br /></i></b>
----> Result matches Expected Output!

===============================
Processing C:\Users\Manoli Tramountanas\Desktop\School Documents\Computer Science 143\Classwork\HW\src\hw6\htmlchecker\tests\test2.html...
===============================
HTML: <a><a><a></a>
Checking HTML for errors...
HTML after fix: <a><a><a></a></a></a>
----> Result matches Expected Output!

===============================
Processing C:\Users\Manoli Tramountanas\Desktop\School Documents\Computer Science 143\Classwork\HW\src\hw6\htmlchecker\tests\test3.html...
===============================
HTML: <br /></p></p>
Checking HTML for errors...
HTML after fix: <br />
----> Result matches Expected Output!

===============================
Processing C:\Users\Manoli Tramountanas\Desktop\School Documents\Computer Science 143\Classwork\HW\src\hw6\htmlchecker\tests\test4.html...
===============================
HTML: <div><div><ul><li></li><li></li><li></ul></div>
Checking HTML for errors...
HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
----> Result matches Expected Output!

===============================
Processing C:\Users\Manoli Tramountanas\Desktop\School Documents\Computer Science 143\Classwork\HW\src\hw6\htmlchecker\tests\test5.html...
===============================
HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
Checking HTML for errors...
HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
----> Result matches Expected Output!

===============================
        All tests passed!
===============================
 */