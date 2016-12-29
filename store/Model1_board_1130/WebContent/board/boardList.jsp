<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<!-- service ��Ű���� ��ü �ҷ��� -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>BOARD LIST</title>
</head>
<body>
<h1>BOARD LIST</h1>
<%
//����������[����������]
int currentPage = 1;
if(request.getParameter("currentPage") != null) {
	//������������ ���������ͼ� int����ȯ �Ѵ�.
    currentPage = Integer.parseInt(request.getParameter("currentPage"));
	System.out.println("debug> boardList.jsp  currentPage : " + currentPage);
}
//Dao�� �����ؼ� totalRowCount�޼��带 ȣ���Ѵ�.
//�������� �ȿ� �� �ִ�[limit] ����� ���� �����Ѵ�. => pagePerRow
//(�����ִ� ������ ����-1)*page�� limit�� ������ page
BoardDao boardDao = new BoardDao();
int totalRowCount = boardDao.selectTotalBoardCount();
int pagePerRow = 10; 
int beginRow = (currentPage-1)*pagePerRow;
List<Board> list = boardDao.selectBoardListPerPage(beginRow, pagePerRow);
%>
 
    <div>��ü���� �� : <%=totalRowCount%>/<%=list.size()%></div>
    <table border="1">
        <thead>
            <tr>
                <th>boardTitle</th>
                <th>boardUser</th>
                <th>boardDate</th>
            </tr>
        </thead>
        <tbody>
<%	/* --for�� for each ����---
		=for ��/list/set 
 		=for each collection�� �ҷ� �� �� �ִ�. */
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
        <a href="<%=request.getContextPath()%>/board/boardAddForm.jsp">�Խñ� �Է�</a>
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
            <a href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage-1%>">����</a>
<%
        }
        if(currentPage < lastPage) {
%>
 
            <a href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage+1%>">����</a>
<%
        }
%>
    </div>
</body>
</html>
