package service;

public class Board {
	private int boardNo;
	private String boardPw;
	private String boardTitle;
	private String boardContent;
	private String boardUser;
	private String boardDate;
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		System.out.println("debug> Board set_boardNo : " + boardNo);
		this.boardNo = boardNo;
	}
	
	public String getBoardPw() {
		return boardPw;
	}
	
	public void setBoardPw(String boardPw) {
		System.out.println("debug> Board set_boardPw : " + boardPw );
		this.boardPw = boardPw;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardTitle(String boardTitle) {
		System.out.println("debug> Board set_boardTitle : " + boardTitle );
		this.boardTitle = boardTitle;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	public void setBoardContent(String boardContent) {
		System.out.println("debug> Board set_oardContent : " + boardContent );
		this.boardContent = boardContent;
	}
	
	public String getBoardUser() {
		return boardUser;
	}
	
	public void setBoardUser(String boardUser) {
		System.out.println("debug> Board set_boardUser : " + boardUser );
		this.boardUser = boardUser;
	}
	
	public String getBoardDate() {
		return boardDate;
	}
	
	public void setBoardDate(String boardDate) {
		System.out.println("debug> Board set_boardDate : " + boardDate );
		this.boardDate = boardDate;
	}
}
