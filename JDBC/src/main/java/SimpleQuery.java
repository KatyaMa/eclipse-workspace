import java.sql.*;

public class SimpleQuery {

		static String connectionUrl = "jdbc:mysql://localhost/classicmodels";
	    static String userName = "root";
	    static String userPass = "password";
	    static Connection con=null;
	    
	public static void main(String[] args) throws Exception {
		/*
		 * mysql> describe employees;
		+----------------+--------------+------+-----+---------+-------+
		| Field          | Type         | Null | Key | Default | Extra |
		+----------------+--------------+------+-----+---------+-------+
		| employeeNumber | int(11)      | NO   | PRI | NULL    |       |
		| lastName       | varchar(50)  | NO   |     | NULL    |       |
		| firstName      | varchar(50)  | NO   |     | NULL    |       |
		| extension      | varchar(10)  | NO   |     | NULL    |       |
		| email          | varchar(100) | NO   |     | NULL    |       |
		| officeCode     | varchar(10)  | NO   | MUL | NULL    |       |
		| reportsTo      | int(11)      | YES  | MUL | NULL    |       |
		| jobTitle       | varchar(50)  | NO   |     | NULL    |       |
		| VacationHours  | int(11)      | YES  |     | 20      |       |
		+----------------+--------------+------+-----+---------+-------+

		WHAT You need to do:

		Write a query to display (employeeNumber,lastName,firstName,VacationHours)  
		where VacationHours >  20

		 */
		 try {
             con = DriverManager.getConnection(connectionUrl, userName, userPass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Step 3: Creating statement
        Statement st = con.createStatement();

        // Step 4: Executing the query and storing the
        // result
        ResultSet rs = st.executeQuery(
            " SELECT employeeNumber, lastName, firstName, VacationHours from employees WHERE VacationHours > 20");
       
        
        // Step 5: Processing the results
        while (rs.next()) {
            System.out.println("Begin New Record");
           // FILL IN CODE HERE
            System.out.println(rs.getInt("employeeNumber"));
            System.out.println(rs.getString("lastname"));
            System.out.println(rs.getString("firstName"));
            System.out.println(rs.getInt("VacationHours"));

        }

        // Step 6: Closing the connections
        // using close() method to release memory resources
        con.close();
    
    // Display message for successful execution of program
    System.out.println("JDBC query completed");
    
		
		
	}

}
