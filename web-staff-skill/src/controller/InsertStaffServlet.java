package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Staff;




@WebServlet("/InsertStaff")
public class InsertStaffServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("debug> InsertStaffServlet doPost()½ÇÇà");
	request.setCharacterEncoding("euc-kr");
	
	String name = request.getParameter("name");
	String sn = request.getParameter("sn");
	String religion = request.getParameter("religion");
	int skill = (Integer.parseInt(request.getParameter("skill")));
	String graduateday = request.getParameter("graduateday");
	int school = (Integer.parseInt(request.getParameter("shcool")));
	
	System.out.println("debug> InsertStaffServlet param = name : "+name);
	System.out.println("debug> InsertStaffServlet param = sn : "+sn);
	System.out.println("debug> InsertStaffServlet param = religion : "+religion);
	System.out.println("debug> InsertStaffServlet param = skill : "+skill);
	System.out.println("debug> InsertStaffServlet param = graduateday : "+graduateday);
	
	Staff staff = new Staff();
	staff.setName(name);
	staff.setSn(sn);
	staff.setGraduateday(graduateday);
	staff.setSchool(school);
	staff.setReligion(religion);
	
	
	}

}
