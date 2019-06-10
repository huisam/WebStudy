package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Product")
public class Product extends HttpServlet {
	
	ArrayList<Node> lists = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 최근값 조회
		RequestDispatcher dispatcher = request.getRequestDispatcher("Recent.jsp");
		Cookie[] cookies = request.getCookies();
		ArrayList<Node> list = new ArrayList<>();
		String product = cookies[1].getValue();
		String price = cookies[2].getValue();
		String content = URLDecoder.decode(cookies[3].getValue(),"UTF-8");
		list.add(new Node(product, price, content) );
		request.setAttribute("recent", list);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 등록은 post
		RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		String product = request.getParameter("productName");
		String price = request.getParameter("price");
		String content = request.getParameter("content");
		Node param = new Node(product,price,content);
		Cookie[] last = new Cookie[3];
		last[0] = new Cookie("product", URLEncoder.encode(product, "UTF-8"));
		last[1] = new Cookie("price", URLEncoder.encode(price, "UTF-8"));
		last[2] = new Cookie("content", URLEncoder.encode(content, "UTF-8"));
		for (int i = 0; i < last.length; i++) {
			response.addCookie(last[i]);
		}
		lists.add(param);
		request.setAttribute("list", lists);
		
		dispatcher.forward(request, response);
		
	}

}
