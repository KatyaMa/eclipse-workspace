package FunctionJavaUtil;

import java.util.function.Function;
/* The Function interface consists of the 4 methods
apply()
andThen()
compose()
identity() */

public class Func_interface_compose {

	public static void main(String[] args) {
		
		// Lab 3 ===================   compose() method
		// https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
		
		// Function which takes in a number and returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // INSERT CODE TO TRIPLE THE VALUE OF THE HALF FUNCTION 
        
        half = half.compose(a-> a * 3);
        System.out.println(half.apply(5));

	}

}
