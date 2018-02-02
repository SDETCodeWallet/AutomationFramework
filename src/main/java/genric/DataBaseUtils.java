package genric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svnmage1.7_1", "root", "admin");
		Class.forName("com.mysql.jdbc.Driver"); 
		
		Statement st=con.createStatement();
		ResultSet test=st.executeQuery("select* from admin_role");
		System.out.println(test.getString(1)+test.getString(2)); 
		con.close();
		
	}
}
