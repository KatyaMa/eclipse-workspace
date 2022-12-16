package Operators;

public class BitwiseOperatorsDemo {

	public static void main(String[] args) {
		

		   int x = 58; //111010
	       int y =13; //1101
	       System.out.println("x & y : " + (x & y)); //returns 8 = 1000
	       System.out.println("x | y : " + (x | y)); //63=111111
	       System.out.println("x ^ y : " + (x ^ y)); //55=11011
	       System.out.println("~x : " + (~x));  //-59
	       System.out.println("x << y : " + (x << y));
	       System.out.println("x >> y : " + (x >> y));
	       
	       // Example: Ternary Operator 

	       int age = 18;
	       String result = age < 100 ?
	               "Less than 100" : "Greater than 100";
	       System.out.println(result); //Less than 100
	       
	       // Example:  Unary Operators

	       int sum = +1;
	       // sum is now 1
	       System.out.println(sum);

	       sum--;
	       // sum is now 0
	       System.out.println(sum);

	       sum++;
	       // sum is now 1
	       System.out.println(sum);

	       sum = -sum;
	       // sum is now -1
	       System.out.println(sum);

	       boolean result2 = false;
	       // false
	       System.out.println(result2);
	       // true
	       System.out.println(!result2);
	 



	}

}
