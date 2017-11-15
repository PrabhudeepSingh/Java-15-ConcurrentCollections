import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapDemo1
{
	public static void main(String[] args) 
	{
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

		concurrentHashMap.put(101, "A");
		concurrentHashMap.put(102, "B");
		concurrentHashMap.putIfAbsent(103, "C");
		concurrentHashMap.putIfAbsent(101, "P");
		System.out.println(concurrentHashMap);

		concurrentHashMap.remove(101, "P");
		concurrentHashMap.replace(102, "B", "T");
		System.out.println(concurrentHashMap);
	}
}