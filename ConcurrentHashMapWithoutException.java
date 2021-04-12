import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapWithoutException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcurrentHashMap<Integer,String> cmap = new ConcurrentHashMap<Integer, String>();
		
		cmap.put(1, "bha");
		cmap.put(2, "aaronreddy");
		cmap.put(3, "divya");

		Iterator<String> citr = cmap.values().iterator();
		
		while(citr.hasNext()) {
			String value = citr.next();
			System.out.println("the value of cmap is:"+value);
			
			if(value.equalsIgnoreCase("aaronreddy")) {
				cmap.put(4, "krishna");
			}
		}
		
	}

}
