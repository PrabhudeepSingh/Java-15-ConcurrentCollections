import java.util.*;
import java.util.concurrent.*;

class CopyOnWriteArrayList2
{
	public static void main(String[] args) 
	{
		CopyOnWriteArrayList obj = new CopyOnWriteArrayList();
		obj.add("A");
		obj.add("B");

		System.out.println(obj);

		Iterator itr = obj.iterator();

		while(itr.hasNext())
		{	
			String str = (String) itr.next();

			if(str.equals("B"))
			{
				//itr.remove();  ->  RE: UnsupportedOperationException
			}
		}	

		System.out.println(obj);	
	}
}

// If we replace CopyOnWriteArrayList with ArrayList then we will not get any UnsupportedOperationException.