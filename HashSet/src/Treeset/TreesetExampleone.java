package Treeset;

import java.util.TreeSet;

import java.util.Iterator;

public class TreesetExampleone {

	public static void main(String[] args) {
		// Example one: Iterate Through TreeSet.

		TreeSet<Integer> num_Treeset = new TreeSet<>();
		num_Treeset.add(20);
	       num_Treeset.add(5);
	       num_Treeset.add(15);
	       num_Treeset.add(25);
	       num_Treeset.add(10);

	       // Call iterator() method to define Iterator for TreeSet
	       Iterator<Integer> iter_set = num_Treeset.iterator();
	       
	       System.out.print("TreeSet using Iterator: ");
	       // Access TreeSet elements using Iterator

	       while (iter_set.hasNext()) {
	    	   System.out.print(iter_set.next() + ", ");
	       }
	       
	       // Example two: Remove Elements
	       // remove() - removes the specified element from the set.
	       // removeAll() - removes all the elements from the set.
	       TreeSet<Integer> numbers = new TreeSet<>();
	        numbers.add(2);
	        numbers.add(5);
	        numbers.add(6);
	        System.out.println("TreeSet: " + numbers);

	        // Using the remove() method
	        boolean value1 = numbers.remove(5);
	        System.out.println("Is 5 removed? " + value1);  // Is 5 removed? true

	        // Using the removeAll() method
	        boolean value2 = numbers.removeAll(numbers);
	        System.out.println("Are all elements removed? " + value2);  // Are all elements removed? true
	   

	}

}
