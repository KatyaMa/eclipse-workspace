package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


//  Tests for getNameAtIndex()
//  Test 1 Data: 
//  Input = 2
//    Expected = “Tony”
//  Test 2 Data:
//  Input = 0
//    Expected = “Mike”

//  Test for addName()
//  Note: use getNames() to check results
//  Test Data:
//  Input = “Jared”
//  Expected = Last entry of getNames() arraylist should be “Jared”

public class testThisTest {
	
	@Test
	public void getNameAtIndexTest() {
		System.out.println("getNameAtIndex Test");
		testThis tester = new testThis();
		
		assertEquals("Tony",tester.getNameAtIndex(2));
		assertEquals("Mike",tester.getNameAtIndex(0));
		
		tester.addEntryToArray("Jared");
		assertEquals("Jared",tester.getNameAtIndex(3));
		
		System.out.println("getNames= "+tester.getNames());
	}


}
