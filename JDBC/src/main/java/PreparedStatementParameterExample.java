import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementParameterExample {

	Connection connection = null;
    String driverName = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost/classicmodels";
    String userName = "root";
    String userPass = "password";

    public PreparedStatementParameterExample() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(connectionUrl, userName, userPass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    } 
	public static void main(String[] args) throws SQLException {


		// WHAT YOU NEED TODO:
		// Please implement
		//
		// Update   a row
		// Delete   a row

		//At first create table named student in MySql database and insert values into it as.
		/*
		CREATE TABLE student (
		  RollNo int(9)  PRIMARY KEY NOT NULL,
		  Name tinytext NOT NULL,
		  Course varchar(25) NOT NULL,
		  Address text
		 );
		*/
		PreparedStatementParameterExample ptmtExample = new PreparedStatementParameterExample();
        Connection con = ptmtExample.getConnection();
        ResultSet resultSet = null;
        // Writing a parameterised query in prepared Statement
        String insertQuery = "INSERT INTO student(RollNo,Name,Course,Address) VALUES(?,?,?,?)";
        String deleteRow = "DELETE from student WHERE Name = ?";
        
        try {
            // Compiling query String
            PreparedStatement statement = con.prepareStatement(insertQuery);
            // setting parameter to the query
            statement.setInt(1, 3);
            statement.setString(2, "Name 3");
            statement.setString(3, "Course 3");
            statement.setString(4, "Address 3");
            //Updating Query
            statement.executeUpdate();
            
           PreparedStatement preparedStatement = con.prepareStatement(deleteRow);
           preparedStatement.setString(1, "Name 2");
           int row = preparedStatement.executeUpdate();
           // rows affected
           System.out.println("Rows deleted: " + row);

            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            con.close();
        }
	}

}
