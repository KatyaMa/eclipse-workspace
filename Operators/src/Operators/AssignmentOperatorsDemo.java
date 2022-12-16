package Operators;

public class AssignmentOperatorsDemo {

	public static void main(String[] args) {
		
	       //   Assigning Primitive Values
		   int j, k;
		   j = 10; // j gets the value 10.
		   j = 5; // j gets the value 5. The previous value is overwritten.
		   k = j; // k gets the value 5.
		   System.out.println("j is : " + j);
		   System.out.println("k is : " + k);

		       //              Multiple Assignments
		   k = j = 10; // (k = (j = 10))
		   System.out.println("j is : " + j);
		   System.out.println("k is : " + k);
		   
		//  Auto-generated method stub
	       int x, y = 10, z = 5;
	         x = y + z;
	         System.out.println("+ operator resulted in " + x);
	         x = y - z;
	         System.out.println("- operator resulted in " + x);
	         x = y * z;
	         System.out.println("* operator resulted in " + x);
	         x = y / z;
	         System.out.println("/ operator resulted in " + x);
	         x = y % z;
	         System.out.println("% operator resulted in " + x);
	         x = y++;
	         System.out.println("Postfix ++ operator resulted in " + x);
	         x = ++z;
	         System.out.println("Prefix ++ operator resulted in " + x);
	         x = -y;
	         System.out.println("Unary operator resulted in " + x);
	         // Some examples of special Cases
	         int tooBig = Integer.MAX_VALUE + 1; // -2147483648 which is
	         // Integer.MIN_VALUE.
	         int tooSmall = Integer.MIN_VALUE - 1; // 2147483647 which is
	         // Integer.MAX_VALUE.
	         System.out.println("tooBig becomes " + tooBig);
	         System.out.println("tooSmall becomes " + tooSmall);
	         System.out.println(4.0 / 0.0); // Prints: Infinity
	         System.out.println(-4.0 / 0.0); // Prints: -Infinity
	         System.out.println(0.0 / 0.0); // Prints: NaN
	         double d1 = 12 / 8; // result: 1 by integer division. d1 gets the value
	         // 1.0.
	         double d2 = 12.0F / 8; // result: 1.5
	         System.out.println("d1 is " + d1);
	         System.out.println("d2 is " + d2);
	  
	}

}
