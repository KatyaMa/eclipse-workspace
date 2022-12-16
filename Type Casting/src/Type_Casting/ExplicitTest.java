package Type_Casting;

public class ExplicitTest {

	public static void main(String[] args) {
		
		double d = 100.04;
	       // explicit type casting
	       long l = (long)d;
	       int i = (int)l;
	       System.out.println("Double value "+d);
	       System.out.println("Long value "+l); // fractional part lost.
	       System.out.println("Int value "+i);  // fractional part lost.

	byte b;
	int z = 257;
	double dou = 323.142;
	System.out.println("Conversion of int to byte.");
	b = (byte) z;
	System.out.println("i = " + z + " b = " + b);
	/*
	 In this example program, when the value 257 is cast into a byte variable,
	  the output is 1, which is the remainder of the division of 257 by 256 
	  (the range of a byte). 
	 */
	System.out.println("Conversion of double to int.");

	z = (int) dou;
	System.out.println("d = " + dou + " b = " + z);
	System.out.println("Conversion of double to byte.");

	b = (byte) dou;
	System.out.println("d = " + dou + " b = " + b);


	}

}
