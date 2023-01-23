package Daointerface;

import java.sql.SQLException;
import java.util.List;

import model.Item;

public interface ItemDAO {

	 /** This is the method to be used to list down all the records from the Items table.*/
	   List<Item> getAllItems() throws ClassNotFoundException, SQLException;

	/** This method to be used to create a record in the Items table. */
	   void saveItem(List<Item> ItemList);

	/** This is the method to be used to delete a record from the Student table corresponding to a passed Items id. */
	   boolean deleteItem(int id);

	/** This is the method to be used to update a record into the Items table. */
	   boolean updateItem(Item Item, int id);


}
