package miniHackathon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class miniHackathon {

	public static void main(String[] args) {
		
		miniHackathon m = new miniHackathon();
    	m.loadVendorData();

    	}
	
    // this is what the vendor (Crufty-Clunky code Inc) has provided
    // loadVendorData() method as a starting point.
    
    // here are the fields required for a Customer Object:
    
    //"first_name",
    //"last_name",
    //"company_name",
    //"address",
    //"city",
    //"county",
    //"state",
    //"zip",
    //"phone1",
    //"phone2",
    //"email",
    //"web"
    //
    // Our requirements are:
    // Create  Customer objects, populate them  and utilize one of the
    // Java collection class data structures ( ArrayList or LinkedList for example) to
    // hold the Customer objects then
    
	
    // Place Order (Customer)
    //  2.The system displays the customer's information: name, street, city, zip, phone, email.
    //    given input will be last_name.
	
    void loadVendorData()
    {	
       // please map this file to your drive
    	
       String file = "/Users/katya/Python/Eclips-Perscholas/us-500.csv";
       String line;
       List<List<String>> customers = new ArrayList<>();
       
       // provide a simple lookup (use Scanner obj) as stated in this part of the BRD,
       // that will take a Last_name as input.
       
       Scanner obj = new Scanner(System.in);
       System.out.println("Enter a Last Name: ");
       String LastName  = obj.nextLine();
       // System.out.println("Last name: " + LastName);
   	
   	
       try (BufferedReader br =
            new BufferedReader(new FileReader(file))) {
            while((line = br.readLine()) != null){
            	// System.out.println(line);
            	String[] Customer = line.split("(?<=\\\"),|(?<=\\d{5}),");
            	List<String> cust = Arrays.asList(Customer);
            	customers.add(Arrays.asList(Customer));
            	 // System.out.println(cust.get(1));
            	if (("\"" + LastName +"\"").equals(cust.get(1))) {
             	   System.out.println("First name: " + cust.get(0) + 
             			", Last name: " + cust.get(1) +  
             			", Company name: " + cust.get(2) +
             			", Address: " + cust.get(3) +
             			", City: " + cust.get(4) +
             			", County: " + cust.get(5) +
             			", State: " + cust.get(6) +
             			", Zip: " + cust.get(7) +
             			", Phone 1: " + cust.get(8) +
             			", Phone 2: " + cust.get(9) +
             			", Email: " + cust.get(10) +
             			", Web: " + cust.get(10));
            }}
        } catch (Exception e){
            System.out.println(e);
        }
       
       obj.close();
           		   
       //  System.out.println(customers.get(1));
	}

}
