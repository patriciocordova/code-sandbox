package code.structures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class JavaClasses {
	public static void main(String[] args) {
		JavaClasses jc = new JavaClasses();
		//jc.linkedList();
		jc.hashMap();
	}
	
	public void linkedList(){
		LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("eBay");
        linkedList.add("Paypal");
        linkedList.add("Google");
        linkedList.add("Yahoo");
        linkedList.add("IBM");
        linkedList.add("Facebook");
        
        ListIterator<String> listIterator = linkedList.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
	}
	
	public void hashMap(){
		HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
		int start=0,current=0,max=0;
		hashMap.put("a",10);
		hashMap.put("b",11);
		hashMap.put("c", 8);
		//System.out.println(hashMap.get("a"));
		
		Iterator it = hashMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
	}
}
