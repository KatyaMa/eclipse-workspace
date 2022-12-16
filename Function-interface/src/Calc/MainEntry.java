package Calc;

import java.util.Scanner;

public class MainEntry {

	public static void main(String[] args) {
		// Create a class called: MainEntry. 
		//In this class, implement the compute() method four times by using blocks to add, subtract, multiply, and divide. 
		// Then ask the user to enter a series of numbers, and ask what they would like to do with the numbers. 
		// In the case of compute()divide, only allow for two numbers.
		
		Calc<Integer> sum = new Calc<Integer>() {

			@Override
			public Integer compute(Integer[] a) {
				int sum = 0;
				for (int i : a) {
					sum += i;
				}
				return sum;
			}
		};

		Calc<Integer> subtract = new Calc<Integer>() {

			@Override
			public Integer compute(Integer[] a) {
				int sum = 0;
				for (int i : a) {
					sum -= i;
				}
				return sum;
			}
		};

		Calc<Integer> multiply = new Calc<Integer>() {

			@Override
			public Integer compute(Integer[] a) {
				int prod = 1;
				for (int i : a) {
					prod *= i;
				}
				return prod;
			}
		};

		Calc<Integer> divide = new Calc<Integer>() {

			@Override
			public Integer compute(Integer[] a) {
				// if (a.length != 2) {
				// System.out.println("For division, enter only 2 integers.");
				// System.exit(1);
				// }

				return a[0] / a[1];
			}
		};
		Scanner scan = new Scanner(System.in);

		String op;
		while (true) {
			System.out.println("What computation? Enter operand symbol:");
			op = scan.nextLine();

			if (op.equals("/")) {
				System.out.println("Enter two integers");
				break;
			} else if (op.equals("+") || op.equals("-") || op.equals("*")) {
				System.out.println("Enter array of integers separated by commas:");
				break;
			} else {
				System.out.println("Please enter valid operand: +, -, /, *");
				continue;
			}
		}
		
		while (true) {
			String[] s = scan.nextLine().split(",");
			Integer[] int_array = new Integer[s.length];
			for (int i = 0; i < s.length; i++) {
				try {
					int_array[i] = Integer.valueOf(s[i]);
				} catch (Exception e) {
				   System.out.println("Only integers accepted. Try again.");
				   continue;
				   
				}
			}

			switch (op) {
			case "+":
				System.out.println("Sum of array is: " + sum.compute(int_array));
				break;
			case "-":
				System.out.println("Difference of array is: " + subtract.compute(int_array));
				break;
			case "*":
				System.out.println("Product of array is: " + multiply.compute(int_array));
				break;
			case "/":
				if (int_array.length != 2) {
					System.out.println("Try entering numbers again. Only enter 2 numbers.");
					continue;
				}
				if (int_array[1] == 0) {
					System.out.println("Cannot divide by zero. Enter new numbers");
					continue;
				}

				System.out.println("Integer division of the 2 numbers is: " + divide.compute(int_array));
				break;

			}
				System.exit(0);
		}			

}
	
}