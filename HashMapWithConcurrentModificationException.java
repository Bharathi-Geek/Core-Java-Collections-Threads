import java.util.HashMap;
import java.util.Iterator;

public class HashMapWithConcurrentModificationException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"bharathi");
		map.put(2, "Aaron");
		map.put(3, "divyareddy");
		
		Iterator<String> itr = map.values().iterator();
		while(itr.hasNext()) {
			String value = (String) itr.next();
			System.out.println("the value is:"+value);
			
			if(value.equalsIgnoreCase("Aaron")) {
				map.put(4, "krishnareddy");
			}
			
		}
		
		
	}

}
