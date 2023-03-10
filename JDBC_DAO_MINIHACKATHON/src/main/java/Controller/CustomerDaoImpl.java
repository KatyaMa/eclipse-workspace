package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Daointerface.CustomerDAO;
import Daointerface.ConnectionDAO;
import model.Customer;

public class CustomerDaoImpl extends ConnectionDAO implements CustomerDAO {

	public void saveCustomer(List<Customer> CustomerList) {
		try {
			Connection con = ConnectionDAO.getConnection();
			for (Customer b : CustomerList) {
				String sqlQuery = "INSERT INTO Customer (email, fname, lname) VALUES (?,?,?)";
				PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
				prepStmt.setString(1, b.getEmail());
				prepStmt.setString(2, b.getFname());
				prepStmt.setString(3, b.getLname());
				int affectedRows = prepStmt.executeUpdate();
				System.out.println(affectedRows + " row(s) affected !!!");
			}
		} catch (ClassNotFoundException e) {
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public List<Customer> getAllCustomers() {
		try {
			Connection connection = ConnectionDAO.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
			List boollist = new ArrayList();
			while (rs.next()) {
				Customer c = new Customer();
				c.setEmail(rs.getString("email"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				boollist.add(c);
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

	public boolean updateCustomer(Customer CustomerObj, int id) {
		try {
			Connection connection = ConnectionDAO.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("UPDATE Customer SET email=?, fname=?, lname=? WHERE id=?");
			ps.setString(1, CustomerObj.getEmail());
			ps.setString(2, CustomerObj.getFname());
			ps.setString(3, CustomerObj.getLname());
			ps.setInt(3, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}

	public boolean deleteCustomer(int id) {
		try {
			Connection connection = ConnectionDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
		}
		return false;
	}

}
