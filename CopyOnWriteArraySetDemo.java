import java.util.*;
import java.util.concurrent.*;

class CopyOnWriteArraySetDemo extends Thread
{
	static CopyOnWriteArraySet set = new CopyOnWriteArraySet();

	public void run()
	{
		try{ Thread.sleep(2000);}
		catch(Exception e) {}
		System.out.println("Child Thread updating set.");
		set.add("C");
		set.add("D");
	}

	public static void main(String[] args) throws Exception
	{
		set.add("A");
		set.add("B");
		set.add("C");

		CopyOnWriteArraySetDemo thread = new CopyOnWriteArraySetDemo();
		thread.start();
		Iterator itr = set.iterator();

		while(itr.hasNext())
		{
			String str = (String) itr.next();
			System.out.println("Main Thread iterating and current object is: "+str);
			Thread.sleep(3000);
		}	

		System.out.println(set);
	}
}

