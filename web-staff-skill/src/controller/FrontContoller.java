package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FrontContollerServlet", urlPatterns = { "/FrontContollerServlet" })
public class FrontContoller extends HttpServlet {
	
	public void dopro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("debug> FrontController doPro() 메서드 실행");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String map = uri.substring(context.length());
		
		System.out.println("debug> FrontController dopro uri : " + uri);
		System.out.println("debug> FrontController dopro context: " + context);
		System.out.println("debug> FrontController dopro map : " + map);
		
		Controller controller = null;
		String view = null;
		
		switch(map){
		case "/StaffInsert.do" :
			System.out.println("debug> FrontController dopro() staffInsert.do 호출");
			controller = new InsertStaffServlet();
			view = controller.play(request);
	
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug> FrontController doGet() 메서드 실행");
		dopro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug> FrontController doPost() 메서드 실행");
		dopro(request,response);
	}

}
