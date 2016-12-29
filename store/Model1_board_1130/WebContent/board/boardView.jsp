<%@ page language = "java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardView</title>
</head>
<body>
<h1>BOARD VIEW</h1>
<%
/* boardNo가 null이면 list로 redirect시켜준다. */
if(request.getParameter("boardNo") == null) {
    response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
} 

else {
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    System.out.println("debug> boardView.jsp  boardNo : " + boardNo);
    /* PAGE요청을 처리할 DAO를 호출한다. */
    /* dao에서 처리되어 return된 값을 board[dto]에 저장한다. */
    /* dto에 저장된 값을 jsp의 출력화면으로 가져와서 보여준다. */
    BoardDao boardDao = new BoardDao();
    
    System.out.println("debug> boardView.jsp  boarddao : " + boardDao);
    
    Board board = boardDao.selectBoardByKey(boardNo);
%>
<!-- 안된이유 : java문을 html문법 상에도 적용을 시켜야 데이터를 가져올 수 있는데
	'}'의 안에 있지 않기 때문에 java문법이 적용되지 않았다.[해결]  -->
	<!-- 따로 요청하지 않아도 import 되어있기 때문에 board에서 직접 데이터를 가져올 수있다  -->
	<div>boardNo : </div>
    <div><%=board.getBoardNo() %></div>
	
	<div>boardTitle : </div>
    <div><%=board.getBoardTitle() %></div>
    
    <div>boardContent : </div>
    <div><%=board.getBoardContent() %></div>
    
    <div>boardUser : </div>
    <div><%=board.getBoardUser() %></div>
    
    <div>boardDate : </div>
    <div><%=board.getBoardDate() %></div>
    
   	<div>
	   <a href="<%=request.getContextPath()%>/board/boardModifyForm.jsp?boardNo=<%=board.getBoardNo()%>">수정</a>
       <a href="<%=request.getContextPath()%>/board/boardRemoveForm.jsp?boardNo=<%=board.getBoardNo()%>">삭제</a>
    </div>
<%
}
%>    
</body>
</html>