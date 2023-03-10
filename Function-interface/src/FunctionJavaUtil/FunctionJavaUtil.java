package FunctionJavaUtil;
//Importing interface
import java.util.function.Function;

/*
 Methods in Function Interface

- apply()
- andThen()
- compose()
- identity()
 */
public class FunctionJavaUtil {

	public static void main(String[] args) {
		// Lab1

		//https://www.geeksforgeeks.org/function-interface-in-java-with-examples/

		//Functional Interface Via apply() method
		
		// Function which takes in a number and returns half of it
        //Function<Integer, Double> half = a -> a / 2.0;
        Function<Double, Double> half = a -> a / 2.0;
        Double dblInput= 58.5;

        // Applying the function to get the result
        Double dd = half.apply(dblInput);
        System.out.println(dd);  // 29.25
		
		
        // Lab 2 =============================================
        // https://www.geeksforgeeks.org/functional-interfaces-java/

        // lambda expressions to implement a user defined functional interface.

        // Single Abstract Method (SAM) types or interfaces

        // benefit of functional interfaces is an use lambda expressions to instantiate them 
        // and avoid using bulky anonymous class implementation.
        
        int a = 5;

        Square s = (int x) -> x * x;  

        // parameter passed and return type must be same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);  // 25
	}
}
interface Square {
	int calculate(int x);
}
