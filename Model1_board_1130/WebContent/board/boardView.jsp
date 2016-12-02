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
/* boardNo�� null�̸� list�� redirect�����ش�. */
if(request.getParameter("boardNo") == null) {
    response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
} 

else {
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    System.out.println("debug> boardView.jsp  boardNo : " + boardNo);
    /* PAGE��û�� ó���� DAO�� ȣ���Ѵ�. */
    /* dao���� ó���Ǿ� return�� ���� board[dto]�� �����Ѵ�. */
    /* dto�� ����� ���� jsp�� ���ȭ������ �����ͼ� �����ش�. */
    BoardDao boardDao = new BoardDao();
    
    System.out.println("debug> boardView.jsp  boarddao : " + boardDao);
    
    Board board = boardDao.selectBoardByKey(boardNo);
%>
<!-- �ȵ����� : java���� html���� �󿡵� ������ ���Ѿ� �����͸� ������ �� �ִµ�
	'}'�� �ȿ� ���� �ʱ� ������ java������ ������� �ʾҴ�.[�ذ�]  -->
	<!-- ���� ��û���� �ʾƵ� import �Ǿ��ֱ� ������ board���� ���� �����͸� ������ ���ִ�  -->
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
	   <a href="<%=request.getContextPath()%>/board/boardModifyForm.jsp?boardNo=<%=board.getBoardNo()%>">����</a>
       <a href="<%=request.getContextPath()%>/board/boardRemoveForm.jsp?boardNo=<%=board.getBoardNo()%>">����</a>
    </div>
<%
}
%>    
</body>
</html>