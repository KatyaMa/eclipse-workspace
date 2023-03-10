package runner;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.BookDaoImpl;
import Daointerface.BookDao;
import model.Books;
/*
 Insert Books Record
 By using saveBook(List<Books> BookList) method, let's add a few records in the database.
 */
public class AccessBook {

	public static void main(String[] args) {
		// CRUD and business logic will invoke here

		 // creating object
	       BookDao bookDao = new BookDaoImpl();
	       System.out.println("--------- inserting book records ----------");
	     
	       ArrayList<Books> BookList = new ArrayList<Books>();

	       Books b1 = new Books();
	       b1.setIsbn(120);
	       b1.setBookName("Java Book");
	       BookList.add(b1);

	       Books b2 = new Books();
	       b2.setIsbn(300);
	       b2.setBookName("Python Book");
	       BookList.add(b2);

	       Books b3 = new Books();
	       b3.setIsbn(365);
	       b3.setBookName("JavaScript Book");
	       BookList.add(b3);

	       Books b4 = new Books();
	       b4.setIsbn(256);
	       b4.setBookName("SQL Book");
	       BookList.add(b4);

	       bookDao.saveBook(BookList);
	  

	       /*
	        * Let's get all the books from the database. We can invoke/use the getAllBooks() method in the main() method
	        */
		System.out.println( " ====== Display list of all books ====");
		try {
		   for (Books cc : bookDao.getAllBooks()) {
		     int ISBN = cc.getIsbn();
		       String BookName = cc.getBookName();
		       System.out.println("======================");
		       System.out.println("ISBN Number :" + ISBN + "and Book name: " + BookName);
	
		   }
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		
		// We can invoke/use updateBook(Books bookObj, int id) method in AccessBook class
		System.out.println("----Book information is updating -----");
		Books Bookupdating = new Books();
		Bookupdating.setIsbn(3);
		Bookupdating.setBookName("Algorithms Book");
		boolean result = bookDao.updateBook(Bookupdating, 3);
		System.out.println(result);


		// We can invoke/use deleteBook(int id) method in AccessBook class. We can pass id to this method. 
		boolean a = bookDao.deleteBook(4); // 4 is a id of book
		if(a == true) {
		       System.out.println("Record is deleted");
		}
		else
		{
		       System.out.println("Record is not deleted");
		}

	
	 }
}
