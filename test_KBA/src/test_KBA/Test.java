package test_KBA;

import java.util.StringJoiner;

public class Test {

	public static void main(String[] args) {

		// #1
		StringJoiner myJoiner = new StringJoiner(":", "{", "}" );
		StringJoiner myJoiner2 = new StringJoiner(",", "[", "]" );
		
		myJoiner.add("Name").add("Michael");
		System.out.println(myJoiner);   // {Name:Michael}
		
		myJoiner2.add("LastName").add("Jackson");
		System.out.println(myJoiner2);   // [LastName,Jackson]
		
		System.out.println(myJoiner.merge(myJoiner2).toString());  // {Name:Michael:LastName,Jackson}
		
		// #2
		StringBuffer myStrBuff = new StringBuffer("135");
		myStrBuff.replace(0, 5, "6789").insert(0, "12345"); // replace = 6789 insert = 123456789
		System.out.println(myStrBuff);
		System.out.println(myStrBuff.reverse().delete(0, 5)); // reverse = 987654321, delete = 4321
		
		
		// #3
		 //int x = 4;
	     //    int y = 0;
	      //  for (; y < 12; ++y) {
	      //      if (y % x == 0)
	     //           continue;
	      //      else if (y == 8)
	      //          break;
	       //     else

	       //         System.out.print(y + " ");  // 1 2 3 5 6 7 9 10 11 
	       //  }
	        
	        
	        // #3
	        int x = 2;
	        int y = 0;
	        for (; y < 10; ++y) {
	            if (y % x == 0)
	                continue;
	            else if (y == 8)
	                break;
	            else

	                System.out.print(y + " ");
	        }
	}

}
