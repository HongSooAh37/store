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
	
	// 테이블 : board , 기능 : 데이터 수정 
	public int updateBoard(Board board) {
		return 0;
	}
	
	// 테이블 : board , 기능 : 데이터 삭제 
	public int deleteBoard(int boardNo) throws ClassNotFoundException, SQLException {
		System.out.println("debug> BoardDao deleteBoard() 실행----");
		int rowCount = 0;
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, stmt, rs);
		}
		return rowCount;
	}
	
	// 테이블 : board , 기능 : 하나의 데이터 가져오기 = update
	public Board selectBoardByKey(int boardNo) {
		System.out.println("debug> BoardDao selectBoardByKey() board NO :" + boardNo);
//		1단계 : 준비물 준비
//		resultSet : 명령에 대한 반환 값
//		sql 문은 primary key를 가지고 데이터를 가져오기 때문에, where의 조건에 들어간다.
//		하나의 데이터를 가져와서 그값을 저장할 객체가 필요하게 되는데 그것을 Board의 board로 메모리를확보해준다.
		Board board = new Board();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT board_title, board_content, board_user, board_date FROM board WHERE board_no=?";
		try{
//		2단계 : db연결및 쿼리 실행
//		데이터의 목록이 아니라 file의 개념이라면 if문을 쓴다
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
	
	// 테이블 : board , 기능 : 한 페이지의 데이터 가져오기 
    public List<Board> selectBoardListPerPage(int beginRow, int pagePerRow) {
    	System.out.println("debug> BoardDao selectBoardListPerPage() 실행----");
//		1단계 : 준비물 생성 + 가져올 데이터가 list형태로 출력되기 위한 것이므로 list형 객체를 선언해준다.
    	List<Board> list = new ArrayList<Board>();
    	Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
//		쿼리문을 db에 컬럼명이랑 맞춰줘서 실행
    	String sql = "SELECT board_no AS boardNo, board_title AS boardTitle, board_user AS boardUser, board_date AS boardDate FROM board ORDER BY board_date DESC LIMIT ?, ?";
//		2단계 : db연결 및 쿼리실행
    	try{
    		connection = this.getConnection();
    		statement = connection.prepareStatement(sql);
    		
    		statement.setInt(1, beginRow);
    		statement.setInt(2, pagePerRow);
    		
    		resultSet = statement.executeQuery();
    		while(resultSet.next()){
//    			LIST를 데이터를 저장할 공간인 BOARD를 생성해서 ResultSet로 접근해서 데이터를 가져와 부여한다.
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
	
	// 테이블 : board, 기능 : 한 페이지의 row
	 public int selectTotalBoardCount() {
		 	System.out.println("debug> BoardDao selectTotalBoardCount() 실행----");
//		 	int형으로 return될 객체를 선언한다
//		 	db연결/쿼리문장을 위한 객체 선언
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
//		 			리턴될 rowCount에 쿼리 실행된 데이터를 부여한다.
		 			rowCount = resultSet.getInt(1);
		 		}
		 	}catch(Exception e){
		 		e.printStackTrace();
		 	}finally{
		 		this.close(connection, statement, resultSet);
		 	}
		 	return 0;
	    }
	
	// 테이블 : board , 기능 : 데이터 입력하기
	public int insertBoard(Board board) {
		System.out.println("debug> BoardDao insertBoard 실행----");
		int rowCount = 0;
		try {
			//1단계 : db연결
			//2단계 : 쿼리문 작성~실행
			conn = this.getConnection();
			 String sql = "INSERT INTO board(board_pw, board_title, board_content, board_user, board_date) values(?,?,?,?,now())";
			 	stmt = conn.prepareStatement(sql);
			 	//------데이터가 set해서 들어가야한다.
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
	
	//db 연결 메서드
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("debug> BoardDao -----Connection 실행-----");
		//드라이버 주소를 찾아 실행시키기 위해서 필요한 메서드
		Class.forName(driverClassName);
		conn = DriverManager.getConnection(url,username,password); 
		return conn;
	}
	//객체 종료 메서드
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
