import java.util.*;
import java.util.concurrent.*;

class CopyOnWriteArrayList1 extends Thread
{
	static CopyOnWriteArrayList list = new CopyOnWriteArrayList();

	public void run()
	{
		try{ Thread.sleep(2000); }
		catch(InterruptedException ie){}
		System.out.println("Child Thread updating list");
		list.add("C");
	}	

	public static void main(String[] args) throws InterruptedException
	{
		list.add("A");
		list.add("B");	

		CopyOnWriteArrayList1 thread = new CopyOnWriteArrayList1();
		thread.start();

		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			String str = (String) itr.next();
			System.out.println("Main Thread iterating and Current Object is: "+str);
			Thread.sleep(3000);
		}

		System.out.println(list);
	}
}