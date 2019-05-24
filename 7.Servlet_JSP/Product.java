package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Product")
public class Product extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>입력하신 결과값입니다!!!</h1>");
		out.println("<p>상품명은 : " + request.getParameter("productName") + "</p>");
		out.println("<p>상품 가격은 : " + request.getParameter("price") + "</p>");
		out.println("<p>상품 설명은 : " + request.getParameter("content") + "</p>");
		out.println("</body></html>");
		
		
	}

}
