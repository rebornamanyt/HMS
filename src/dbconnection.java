import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class dbconnection {
	public Statement conmethod(){
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		//register ur driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=UTF-8","root","12345678");
			stmt= con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showInternalMessageDialog(null, e);
			
			// TODO: handle exception
		}
		return stmt;
	}
	

}
