package FunctionJavaUtil;

//https://www.geeksforgeeks.org/function-interface-in-java-with-examples/

//Java Program to illustrate compose() method

//Importing Function interface
import java.util.function.Function;

public class Func_interface_compose {

	public static void main(String[] args) {
		
		// Lab 3 ============================================


		// Function which takes in a number and
        // returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // INSERT CODE TO TRIPLE THE VALUE OF THE HALF FUNCTION 
        

        // Applying the function to get the result
        System.out.println(half.apply(5));

	}

}
