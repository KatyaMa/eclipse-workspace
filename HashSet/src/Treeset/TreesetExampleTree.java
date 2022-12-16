package Treeset;

import java.util.TreeSet;

public class TreesetExampleTree {

	public static void main(String[] args) {
		// first() - returns the first element of the set.
		// last() - returns the last element of the set.
		TreeSet<Integer> numbers = new TreeSet<>();
		numbers.add(2);
		numbers.add(5);
		numbers.add(6);
		System.out.println("TreeSet: " + numbers); // TreeSet: [2, 5, 6]

		// Using the first() method
		int first = numbers.first();
		System.out.println("First Number: " + first);  // First Number: 2
		
		// Using the last() method
		System.out.println("Last Number: " + numbers.last()); // Last Number: 6
		
		
		
		
	}

}
