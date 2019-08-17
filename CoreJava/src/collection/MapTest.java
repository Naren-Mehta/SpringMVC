package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		Integer x1 = 1000;
		Integer y1 = 1000;

		Float f = 10.0f;
		Float f1 = 10.0f;

		String s1 = new String("Hello");
		StringBuffer sb1 = new StringBuffer("Hello");
		StringBuffer sb2 = new StringBuffer("Hello");

//		System.out.println(x1 == y1);
		System.out.println(sb1.equals(s1));

//		Map<Integer, String> m= new HashMap<Integer, String>();
//		m.put(101, "A");
//		m.put(102, "B");
//		m.put(103, "C");
//		m.put(104, "D");
//		m.put(105, "E");
//		m.put(106, "F");
//		
//		System.out.println(m);
//		
//		System.out.println("\n Iterate via first method.");
//
//		Set<Entry<Integer, String>> s= m.entrySet();
//		
//		Iterator i = s.iterator();
//		
//		while(i.hasNext()){
//			Entry<Integer, String> e= (Entry<Integer, String>) i.next();
//			System.out.println(e.getKey() +" "+ e.getValue());
//		}
//		
//		System.out.println("\n Iterate via second method.");
//		
//		Set<Integer> s1= m.keySet();
//		Iterator i1= s1.iterator();
//		while(i1.hasNext()) {
//			Integer x= (Integer) i1.next();
//			System.out.println(x+ " " + m.get(x));
//		}

	}

}
