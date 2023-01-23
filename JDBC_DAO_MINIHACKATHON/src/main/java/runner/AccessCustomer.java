package runner;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.CustomerDaoImpl;
import Daointerface.CustomerDAO;
import model.Customer;


public class AccessCustomer {

	public static void main(String[] args) {
		
		 // creating object
		   CustomerDAO customerDAO = new CustomerDaoImpl();
	       System.out.println("--------- inserting customer records ----------");
	     
	       ArrayList<Customer> CustomerList = new ArrayList<Customer>();

	       Customer c1 = new Customer();
	       c1.setEmail("email_1@gmail.com");
	       c1.setFname("First_name_1");
	       c1.setLname("Last_name_1");
	       CustomerList.add(c1);

	       Customer c2 = new Customer();
	       c2.setEmail("email_2@gmail.com");
	       c2.setFname("First_name_2");
	       c2.setLname("Last_name_2");
	       CustomerList.add(c2);

	       Customer c3 = new Customer();
	       c3.setEmail("email_3@gmail.com");
	       c3.setFname("First_name_3");
	       c3.setLname("Last_name_3");
	       CustomerList.add(c3);

	       Customer c4 = new Customer();
	       c4.setEmail("email_4@gmail.com");
	       c4.setFname("First_name_4");
	       c4.setLname("Last_name_4");
	       CustomerList.add(c4);

	       customerDAO.saveCustomer(CustomerList);
	       
	       /*
	        * Let's get all the Customer from the database. We can invoke/use the getAllCustomers() method in the main() method
	        */
		System.out.println( " ====== Display list of all Customers ====");
		try {
		   for (Customer cc : customerDAO.getAllCustomers()) {
			   String email = cc.getEmail();
		       String fname = cc.getFname();
		       String lname = cc.getLname();
		       System.out.println("======================");
		       System.out.println("email:" + email + ", Customer name: " + fname + "and Customer last name: " + lname);
	
		   }
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		
		// We can invoke/use updateCustomer(Customer CustomerObj, int id) method in AccessCustomer class
		System.out.println("----Customer information is updating -----");
		Customer Customerupdating = new Customer();
		Customerupdating.setEmail("updated_email@gmail.com");
		Customerupdating.setFname("Updated_f_name");
		Customerupdating.setLname("Updated_l_name");
		boolean result = customerDAO.updateCustomer(Customerupdating, 3);
		System.out.println(result);


		// We can invoke/use deleteCustomer(int id) method in AccessCustomer class. We can pass id to this method. 
		boolean a = customerDAO.deleteCustomer(4); // 4 is a id of Customer
		if(a == true) {
		       System.out.println("Record is deleted");
		}
		else
		{
		       System.out.println("Record is not deleted");
		}

	
	 }
	       
	


}
