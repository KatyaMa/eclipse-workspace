package Daointerface;

import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface CustomerDAO {

	 /** This is the method to be used to list down all the records from the Customers table.*/
	   List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException;

	/** This method to be used to create a record in the Customers table. */
	   void saveCustomer(List<Customer> CustomerList);

	/** This is the method to be used to delete a record from the Student table corresponding to a passed Customers id. */
	   boolean deleteCustomer(int id);

	/** This is the method to be used to update a record into the Customers table. */
	   boolean updateCustomer(Customer Customer, int id);

}
