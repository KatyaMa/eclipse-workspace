package TreeMap;

import java.util.TreeMap;

public class exampleTreemapOne {

	public static void main(String[] args) {
		/*
		 - remove(key) - returns and removes the entry associated with the specified key from a TreeMap.
		 - remove(key, value) - removes the entry from the map only if the specified key is associated with the specified value and returns a boolean value.
		 */
		TreeMap<String, Integer> numbers = new TreeMap<>();
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		System.out.println("TreeMap: " + numbers);  // TreeMap: {one=1, three=3, two=2}
		
		Integer value = numbers.remove("one");
		System.out.println("Removed value: " + value);  //  Removed value: 1
		
		Boolean result = numbers.remove("two", 2);
		System.out.println("Is the entry {Three=3} removed? " + result); // Is the entry {Three=3} removed? true
		System.out.println("Updated TreeMap: " + numbers);  // Updated TreeMap: {three=3}
		
		/*
		 *  Example Two: Methods for Navigation.
		 - firstKey() - returns the first key of the map.
		 - firstEntry() - returns the key/value mapping of the first key of the map.
		 - lastKey() - returns the last key of the map.
		 - lastEntry() - returns the key/value mapping of the last key of the map.
		 */
		
		 TreeMap<String, Integer> numbers2 = new TreeMap<>();
	        numbers2.put("First", 1);
	        numbers2.put("Second", 2);
	        numbers2.put("Third", 3);
	        System.out.println("TreeMap: " + numbers2); // TreeMap: {First=1, Second=2, Third=3}

	        // Using the firstKey() method
	        System.out.println("First Key: " + numbers2.firstKey());  // First Key: First
	        System.out.println("First Entry: " + numbers2.firstEntry());  // First Entry: First=1
	        System.out.println("Last Key: " + numbers2.lastKey());  // Last Key: Third
	        System.out.println("Last Entry: " + numbers2.lastEntry());  // Last Entry: Third=3

		
	}

}
