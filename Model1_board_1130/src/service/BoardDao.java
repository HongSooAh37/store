package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class BoardDao {

	private final String driverClassName = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&amp;characterEncoding=euckr";
	private final String username = "root";
	private final String password = "java0000";
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	// ���̺� : board , ��� : ������ ���� 
	public int updateBoard(Board board) {
		return 0;
	}
	
	// ���̺� : board , ��� : ������ ���� 
	public int deleteBoard(int boardNo) throws ClassNotFoundException, SQLException {
		System.out.println("debug> BoardDao deleteBoard() ����----");
		int rowCount = 0;
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		return rowCount;
	}
	
	// ���̺� : board , ��� : �ϳ��� ������ �������� = update
	public Board selectBoardByKey(int boardNo) {
		System.out.println("debug> BoardDao selectBoardByKey() board NO :" + boardNo);
//		1�ܰ� : �غ� �غ�
//		resultSet : ��ɿ� ���� ��ȯ ��
//		sql ���� primary key�� ������ �����͸� �������� ������, where�� ���ǿ� ����.
//		�ϳ��� �����͸� �����ͼ� �װ��� ������ ��ü�� �ʿ��ϰ� �Ǵµ� �װ��� Board�� board�� �޸𸮸�Ȯ�����ش�.
		Board board = new Board();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT board_title, board_content, board_user, board_date FROM board WHERE board_no=?";
		try{
//		2�ܰ� : db����� ���� ����
//		�������� ����� �ƴ϶� file�� �����̶�� if���� ����
			connection = this.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
			
				board.setBoardNo(boardNo);;
				board.setBoardTitle(resultSet.getString("boardTitle"));
				board.setBoardContent(resultSet.getString("boardContent"));
				board.setBoardUser(resultSet.getString("boardUser"));
				board.setBoardUser(resultSet.getString("boardDate"));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(connection, statement, resultSet);
		}
		return board;
	}
	
	// ���̺� : board , ��� : �� �������� ������ �������� 
    public List<Board> selectBoardListPerPage(int beginRow, int pagePerRow) {
    	System.out.println("debug> BoardDao selectBoardListPerPage() ����----");
//		1�ܰ� : �غ� ���� + ������ �����Ͱ� list���·� ��µǱ� ���� ���̹Ƿ� list�� ��ü�� �������ش�.
    	List<Board> list = new ArrayList<Board>();
    	Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
//		�������� db�� �÷����̶� �����༭ ����
    	String sql = "SELECT board_no AS boardNo, board_title AS boardTitle, board_user AS boardUser, board_date AS boardDate FROM board ORDER BY board_date DESC LIMIT ?, ?";
//		2�ܰ� : db���� �� ��������
    	try{
    		connection = this.getConnection();
    		statement = connection.prepareStatement(sql);
    		
    		statement.setInt(1, beginRow);
    		statement.setInt(2, pagePerRow);
    		
    		resultSet = statement.executeQuery();
    		while(resultSet.next()){
//    			LIST�� �����͸� ������ ������ BOARD�� �����ؼ� ResultSet�� �����ؼ� �����͸� ������ �ο��Ѵ�.
    			Board board = new Board();
    			board.setBoardNo(resultSet.getInt("boardNo"));
    			board.setBoardTitle(resultSet.getString("boardTitle"));
    			board.setBoardUser(resultSet.getString("boardUser"));
    			board.setBoardDate(resultSet.getString("boardDate"));
    			list.add(board);
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		this.close(connection, statement, resultSet);
    	}
    	return list;
    }
	
	// ���̺� : board, ��� : �� �������� row
	 public int selectTotalBoardCount() {
		 	System.out.println("debug> BoardDao selectTotalBoardCount() ����----");
//		 	int������ return�� ��ü�� �����Ѵ�
//		 	db����/���������� ���� ��ü ����
		 	Connection connection = null;
		 	PreparedStatement statement =null;
		 	ResultSet resultSet = null;
		 	
		 	int rowCount = 0;
		 	String sql = "SELECT COUNT(*) FROM board";
		 	
		 	try{
		 		connection = this.getConnection();
		 		statement = getConnection().prepareStatement(sql);
		 		resultSet = statement.executeQuery();
		 		if(resultSet.next()){
//		 			���ϵ� rowCount�� ���� ����� �����͸� �ο��Ѵ�.
		 			rowCount = resultSet.getInt(1);
		 		}
		 	}catch(Exception e){
		 		e.printStackTrace();
		 	}finally{
		 		this.close(connection, statement, resultSet);
		 	}
		 	return 0;
	    }
	
	// ���̺� : board , ��� : ������ �Է��ϱ�
	public int insertBoard(Board board) {
		System.out.println("debug> BoardDao insertBoard ����----");
		int rowCount = 0;
		try {
			//1�ܰ� : db����
			//2�ܰ� : ������ �ۼ�~����
			conn = this.getConnection();
			 String sql = "INSERT INTO board(board_pw, board_title, board_content, board_user, board_date) values(?,?,?,?,now())";
			 	stmt = conn.prepareStatement(sql);
			 	//------�����Ͱ� set�ؼ� �����Ѵ�.
			 	stmt.setString(1, board.getBoardPw());
			 	stmt.setString(2, board.getBoardTitle());
			 	stmt.setString(3, board.getBoardContent());
			 	stmt.setString(4, board.getBoardUser());
			    rowCount = stmt.executeUpdate();
			    System.out.println("debug> BoardDao insertBoard() rowCount : " + rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn, stmt, null);
		}
		return rowCount;
	}
	
	//db ���� �޼���
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("debug> BoardDao -----Connection ����-----");
		//����̹� �ּҸ� ã�� �����Ű�� ���ؼ� �ʿ��� �޼���
		Class.forName(driverClassName);
		conn = DriverManager.getConnection(url,username,password); 
		return conn;
	}
	//��ü ���� �޼���
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
