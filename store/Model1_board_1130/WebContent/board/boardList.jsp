<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<!-- service 패키지를 전체 불러옴 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD LIST</title>
</head>
<body>
<h1>BOARD LIST</h1>
<%
//현재페이지[시작페이지]
int currentPage = 1;
if(request.getParameter("currentPage") != null) {
	//시작페이지의 값을가져와서 int형변환 한다.
    currentPage = Integer.parseInt(request.getParameter("currentPage"));
	System.out.println("debug> boardList.jsp  currentPage : " + currentPage);
}
//Dao를 선언해서 totalRowCount메서드를 호출한다.
//한페이지 안에 들어갈 최대[limit] 목록의 수를 지정한다. => pagePerRow
//(현재있는 페이지 수에-1)*page의 limit의 지정한 page
BoardDao boardDao = new BoardDao();
int totalRowCount = boardDao.selectTotalBoardCount();
int pagePerRow = 10; 
int beginRow = (currentPage-1)*pagePerRow;
List<Board> list = boardDao.selectBoardListPerPage(beginRow, pagePerRow);
%>
 
    <div>전체행의 수 : <%=totalRowCount%>/<%=list.size()%></div>
    <table border="1">
        <thead>
            <tr>
                <th>boardTitle</th>
                <th>boardUser</th>
                <th>boardDate</th>
            </tr>
        </thead>
        <tbody>
<%	/* --for문 for each 차이---
		=for 맵/list/set 
 		=for each collection만 불러 올 수 있다. */
            for(int i = 0; i < list.size(); i++) {
%>
                <tr>
                    <td><a href="<%=request.getContextPath()%>/board/boardView.jsp?boardNo=<%=list.get(i).getBoardNo()%>"><%=list.get(i).getBoardTitle()%></a></td>
                    <td><%=list.get(i).getBoardUser()%></td>
                    <td><%=list.get(i).getBoardDate()%></td>
                </tr>
<%        
            }
%>
        </tbody>
    </table>
 
    <div>
        <a href="<%=request.getContextPath()%>/board/boardAddForm.jsp">게시글 입력</a>
    </div>
<%
    int lastPage = totalRowCount/pagePerRow;
    if(totalRowCount%pagePerRow != 0) {
        lastPage++;
    }
%>
    <div>
<%
        if(currentPage>1) {
%>
            <a href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<%
        }
        if(currentPage < lastPage) {
%>
 
            <a href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
        }
%>
    </div>
</body>
</html>
