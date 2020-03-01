package hw6.htmlchecker;

import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html)
  {
	  tags = html;
  }
  
  public Queue<HTMLTag> getTags()
  {
	  return tags;
  }
  
  public String toString()
  {
	  String ret = "";
	  Iterator<HTMLTag> itr = tags.iterator();
	  while(itr.hasNext())
	  {
		  ret += itr.next().toString().trim();
	  }
	  
	  return ret;
  }
  
  public void fixHTML()
  {
	  
  }
}
