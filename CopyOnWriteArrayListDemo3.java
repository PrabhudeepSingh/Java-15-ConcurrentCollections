import java.util.*;
import java.util.concurrent.*;

class CopyOnWriteArrayList3
{
	public static void main(String[] args) 
	{
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		
		list.add("A");
		list.add("B");
		list.add("C");

		Iterator itr = list.iterator();

		list.add("D");		

		while(itr.hasNext())
			System.out.println((String) itr.next());
	}	
}

/*  Every update operation will be performed on a seprated cloned copy.
	Hence, any update to the list after getting it's iterator will not be reflected to the iterator.	*/   