package model;

public class Books {

	  private int id;
	  private int isbn;
	  private String bookName;
	// ----Constructor---
	   public Books() {
	   }

	   public Books(int isbn, String bookName) {
	       this.isbn = isbn;
	       this.bookName = bookName;
	   }
	 public Books(int id, int isbn, String bookName) {
	     this.isbn = isbn;
	     this.bookName = bookName;
	     this.id = id;
	  }
	 // getter setter methods

	  public int getId() {
	     return id;
	  }

	  public void setId(int id) {
	     this.id = id;
	  }
	  
	  public int getIsbn() {
	     return isbn;
	  }

	  public void setIsbn(int isbn) {
	     this.isbn = isbn;
	  }

	  public String getBookName() {
	     return bookName;
	  }

	  public void setBookName(String bookName) {
	     this.bookName = bookName;
	  }
	

}

/*
 The above class is our model class. It has two variables/properties to keep things simple. 
This layer should contain a simple class called Data Transfer Object(DTO) . 
This object is just a simple mapping to the table. 
Every column in the table would be a member variable in the class.
A good practice is to provide a default empty constructor, 
a full constructor with all variables and a full constructor without the id parameter.
 
 * */

