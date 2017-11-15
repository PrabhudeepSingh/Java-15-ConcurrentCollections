import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapDemo2 extends Thread
{
	static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

	public void run()
	{
		try { Thread.sleep(2000); }
		catch(InterruptedException ie) {}
		System.out.println("Child Thread updating Map");
		concurrentHashMap.put(103, "C");
	}

	public static void main(String[] args) throws InterruptedException
	{
		concurrentHashMap.put(101, "A");
		concurrentHashMap.put(102, "B");

		ConcurrentHashMapDemo2 thread = new ConcurrentHashMapDemo2();
		thread.start();

		Set set = concurrentHashMap.keySet();
		Iterator itr = set.iterator();

		while(itr.hasNext())
		{
			Integer val  = (Integer) itr.next();
			System.out.println("Main Thread iterating and current entry is: "+val+" = "+concurrentHashMap.get(val));
			Thread.sleep(3000);
		}

		System.out.println(concurrentHashMap);
	}
}