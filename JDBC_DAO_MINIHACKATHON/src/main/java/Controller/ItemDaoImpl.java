package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Daointerface.ItemDAO;
import Daointerface.ConnectionDAO;
import model.Item;

public class ItemDaoImpl extends ConnectionDAO implements ItemDAO{

	public void saveItem(List<Item> ItemList) {
	       try {
	          Connection con = ConnectionDAO.getConnection();
	          for(Item i: ItemList) {
	              String sqlQuery = "INSERT INTO Item (name,price) VALUES (?,?)";
	              PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
	              prepStmt.setString(1,  i.getName());
	              prepStmt.setDouble(2, i.getPrice());
	              int affectedRows = prepStmt.executeUpdate();
	              System.out.println(affectedRows + " row(s) affected !!");
	          }
	       }
	       catch (ClassNotFoundException e)
	       {
	       } catch (SQLException throwables) {
	           throwables.printStackTrace();
	       }
	   }

	   public List<Item> getAllItems() {
	       try {
	           Connection connection = ConnectionDAO.getConnection();
	           Statement stmt = connection.createStatement();
	           ResultSet rs = stmt.executeQuery("SELECT * FROM Item");
	           List boollist = new ArrayList();
	           while(rs.next())
	           {
	               Item i = new Item();
	               i.setName( rs.getString("name") );
	               i.setPrice( rs.getDouble("price") );
	               boollist.add(i);
	           }
	           return boollist;

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	           System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	       return null;
	   }
	   
	   

	   public boolean updateItem(Item ItemObj, int id){
	        try {
	            Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement ps = connection.prepareStatement("UPDATE Item SET name=?, price=? WHERE id=?");
	            ps.setString(1, ItemObj.getName());
	            ps.setDouble(2, ItemObj.getPrice());
	            ps.setInt(3, id);
	           int i = ps.executeUpdate();
	           if(i == 1) {
	               return true;
	           }
	       }
	       catch (ClassNotFoundException e)
	       {
	           e.printStackTrace();
	       }
	       catch (SQLException e) {
	           e.printStackTrace();
	           System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	       }
	       return false;
	   }

	   
	   
	   
	   public boolean deleteItem(int id) {
	       try {
	           Connection connection = ConnectionDAO.getConnection();
	           PreparedStatement ps = connection.prepareStatement("DELETE FROM Item WHERE id=?");
	           ps.setInt(1, id);
	           int i = ps.executeUpdate();
	           if(i == 1) {
	               return true;
	           }
	       } catch (ClassNotFoundException e)
	       {
	           e.printStackTrace();
	       }
	       catch (SQLException ex) {
	           System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
	       }
	       return false;
	   }

}
