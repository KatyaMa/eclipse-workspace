package TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class maincomparator {

	public static void main(String[] args) {
		/* 
		 * Example Two: TreeMap Comparator.
		 * TreeMap elements are sorted in ascending order. However, we can also customize the ordering of keys. 
		 * For this, we need to create our comparator class based on which keys in a TreeMap are sorted. 
		 */
		
		 // Creating a TreeMap with a customized comparator
	       TreeMap<String, Integer> numbers = new TreeMap<>(new CustomComparator());

	       numbers.put("First", 1);
	       numbers.put("Second", 2);
	       numbers.put("Third", 3);
	       numbers.put("Fourth", 4);
	       System.out.println("TreeMap: " + numbers); 
	       // TreeMap: {Third=3, Second=2, Fourth=4, First=1}

		       }
		  
	}




