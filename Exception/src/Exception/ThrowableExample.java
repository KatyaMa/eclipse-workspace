package Exception;
import java.io.*;

public class ThrowableExample extends Throwable{

	public static void main(String[] args) throws Exception {
		
		/*
		Java Exception --  Description
		
	ArithmeticException -- Arithmetic error (divide-by-zero).
	ArrayIndexOutOfBoundsException -- Array index is out-of-bounds.
	IllegalArgumentException -- Illegal argument used to call a method.
	IllegalThreadStateException -- Requested operation not compatible with current thread state.
	IndexOutOfBoundsException -- Some type of index is out-of-bounds.
	NullPointerException -- Invalid use of a null reference.
	NumberFormatException -- Invalid conversion of a string to a numeric format.
	StringIndexOutOfBoundsException -- Attempt to index outside the bounds of a string.
	TypeNotPresentException -- Type not found.
	
	!!!  What are checked exceptions? 
	Checked exceptions are checked at compile-time. 
	It means if a method is throwing a checked exception then it should handle the exception using try-catch block or 
	it should declare the exception using throws keyword, otherwise the program will give a compilation error.

			 */
		
		// BEGIN LAB 3
		

	try {

        testException();
    }

    catch (Throwable e) {

        // Print using tostring()
        System.out.println("Exception: "
                        + e.toString());
    }
}

// Method which throws Exception
public static void testException() throws Exception{
    // WHAT YOU NEED to do:  code this method
	throw new Exception(); 
}}
