package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DriverDB {
//01�ܰ� ����̹��ε��� 02�ܰ� DB���� ó���޼��� ����
	public Connection driverDbcon() throws ClassNotFoundException, SQLException{
		System.out.println("debug> ����̹��ε���DB���� ���� driverDbcon DriverDB.java");
		Connection reconn = null;
		Class.forName("com.mysql.jdbc.Driver");

		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		reconn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		return reconn;
	}
	
	
	
}
