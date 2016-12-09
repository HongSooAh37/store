package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DriverDB {
//01단계 드라이버로딩과 02단계 DB연결 처리메서드 선언
	public Connection driverDbcon() throws ClassNotFoundException, SQLException{
		System.out.println("debug> 드라이버로딩과DB연결 실행 driverDbcon DriverDB.java");
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
