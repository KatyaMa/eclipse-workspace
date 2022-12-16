package Type_Casting;

public class AutoTypeConversion {

	public static void main(String[] args) {

		// Example: Implicit Type Casting

		   int x = 20;
	       double y = 40.5;
	       long p = 30;
	       float q = 10.60f;
	       // int z = x + y; (1) // Error; cannot convert from double to int.
	       double z = x + y;
	       System.out.println("Sum of two numbers: " + z);

	    // long r = p - q; // (2) // Error; cannot convert from float to long.
	       float r = p - q;
	       System.out.println("Subtraction of two numbers: " + r);
	 

	   // Example: Automatic Type Promotion
	       byte b = 42;
	       char c = 'a';  // 'a' = 97
	       short s = 1024;
	       int i = 50000;
	       float f = 5.67f;
	       double d = .1234;
	// Expression:
	       double result = (f * b) + (i / c) - (d * s);
	//Result after all the promotions are done.
	       System.out.println("result = " + result);  // result = 626.7784146484375
	       System.out.println(i/c);
	       System.out.println(i/515);
	}

}
