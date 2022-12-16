package HashMap;

import java.util.HashMap;

public class ExampleOneHashMap {

	public static void main(String[] args) {
		//Example One: Remove HashMap Elements.
		HashMap<Integer, String> languages = new HashMap<>();
		languages.put(1, "Java");
		languages.put(2, "Python");
	    languages.put(3, "JavaScript");
	    languages.put(4, "C Sharp");

	    System.out.println("HashMap: " + languages);
	    // output: HashMap: {1=Java, 2=Python, 3=JavaScript, 4=C Sharp}
	    
	    // remove element associated with key 2
	    String value = languages.remove(2);
	    System.out.println("Removed value: " + value);
	    System.out.println("Updated HashMap: " + languages);
	    
	    // Example two
	    
	    HashMap<String, String> newHashMap = new HashMap<>();
	    newHashMap.put("Key1", "Lenovo");
	    newHashMap.put("Key2", "Motorola");
	    newHashMap.put("Key3", "Nokia");
	    newHashMap.put("Key4", null);
	    newHashMap.put(null, "Sony");
	    System.out.println("Original map contains:" + newHashMap);
	    
	    //getting size of Hashmap
	    System.out.println("Size of original Map is: "+ newHashMap.size());
	    
	    //copy contains of one Hashmap to another
	    HashMap<String, String> copyHashMap = new HashMap<>();
	    copyHashMap.putAll(newHashMap);
	    System.out.println("copyHashMap mappings= " + copyHashMap);
	    
	     //Removal of null key
	    String nullKeyValue = copyHashMap.remove(null);
	    System.out.println("copyHashMap null key value = " + nullKeyValue);
	    System.out.println("copyHashMap after removing null key = " + copyHashMap);
	    System.out.println("Size of copyHashMap is:" + copyHashMap.size());
	  

	}

}
