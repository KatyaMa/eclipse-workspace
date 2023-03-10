package runner;

import java.sql.SQLException;
import java.util.ArrayList;

import Controller.ItemDaoImpl;
import Daointerface.ItemDAO;
import model.Item;

public class AccessItem {

	public static void main(String[] args) {

		// CRUD and business logic will invoke here

		// creating object
       ItemDAO itemDao = new ItemDaoImpl();
       System.out.println("--------- inserting item records ----------");
     
       ArrayList<Item> itemList = new ArrayList<Item>();

       Item b1 = new Item();
       b1.setName("Item_1");
       b1.setPrice(50.55);
       itemList.add(b1);

       Item b2 = new Item();
       b2.setName("Item_2");
       b2.setPrice(35.60);
       itemList.add(b2);

       Item b3 = new Item();
       b3.setName("Item_3");
       b3.setPrice(70.30);
       itemList.add(b3);

       Item b4 = new Item();
       b4.setName("Item_4");
       b4.setPrice(55.99);
       itemList.add(b4);

       itemDao.saveItem(itemList);
  

       /*
        * Let's get all the Items from the database. We can invoke/use the getAllItems() method in the main() method
        */
	System.out.println( " ====== Display list of all Items ====");
	try {
	   for (Item ii : itemDao.getAllItems()) {
		   String name = ii.getName();
		   double price = ii.getPrice();
	       System.out.println("======================");
	       System.out.println("Item Name :" + name + "and item price: " + price);

	   }
	} catch (ClassNotFoundException e) {
	   e.printStackTrace();
	} catch (SQLException e) {
	   e.printStackTrace();
	}
				
	
	// We can invoke/use updateItem(Items ItemObj, int id) method in AccessItem class
	System.out.println("----Item information is updating -----");
	Item Itemupdating = new Item();
	Itemupdating.setName("Updated item name");
	Itemupdating.setPrice(100.66);
	boolean result = itemDao.updateItem(Itemupdating, 3);
	System.out.println(result);


	// We can invoke/use deleteItem(int id) method in AccessItem class. We can pass id to this method. 
	boolean a = itemDao.deleteItem(4); // 4 is a id of Item
	if(a == true) {
	       System.out.println("Record is deleted");
	}
	else
	{
	       System.out.println("Record is not deleted");
	}

	
	}

}
