<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="service.BoardDao" %>
<jsp:useBean id="board" class="service.Board"/>
<jsp:setProperty name="board" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<%
request.setCharacterEncoding("euc-kr");

	String boardPw = request.getParameter("boardPw");
	System.out.println("debug> boardAddAction boardPw:" + boardPw);
	
	String boardTitle = request.getParameter("boardTitle");
	System.out.println("debug> boardAddAction boardTitle:" + boardTitle);
	
	String boardContent = request.getParameter("boardContent");
	System.out.println("debug> boardAddAction boardContent:" + boardContent);
	
	String boardUser = request.getParameter("boardUser");
	System.out.println("debug> boardAddAction boardUser:" + boardUser);
	
	BoardDao dao = new BoardDao();
	dao.insertBoard(board);
	//list로 
	response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
	
	
%>
</body>
</html>
