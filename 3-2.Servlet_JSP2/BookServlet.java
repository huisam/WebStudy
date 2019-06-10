import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String[] book = request.getParameterValues("book");
		String bookName = request.getParameter("bookName");
		String booktype = request.getParameter("booktype");
		String writer = request.getParameter("writer");
		if(book == null || bookName.equals("") || booktype.equals("") || writer.equals(""))
			response.sendRedirect("/WSjava_Servlet/Book.html");
		String nation = request.getParameter("nation");
		String date = request.getParameter("date");
		String publisher = request.getParameter("publisher");
		String price = request.getParameter("price");
		String money = request.getParameter("money");
		String content = request.getParameter("content");
		
//		String country = "";
//		if(nation1.equals("on"))
//			country = "국내도서";
//		if(nation2.equals("on"))
//			country = "외국도서";
		
		out.println("<html><style type='text/css'>");
		out.println("table{ width: 14%; border:1px solid #444444;} th{background-color:gray; border:1px solid #444444;} td{border:1px solid #444444;}</style>");
		out.println("<body>");
		out.println("<h1>입력된 도서 정보</h1>");
		out.println("<table><thead><tr><th colspan=2>도서정보</th></tr></thead>");
		out.println("<tbody><tr><th>도서명</th><td>" + bookName + "</td></tr>");
		out.println("<tr><th>도서번호</th><td>" + book[0] + "-" + book[1] + "-" + book[2] + "</td></tr>");
		out.println("<tr><th>도서분류</th><td>" + booktype + "</td></tr>");
		out.println("<tr><th>도서국가</th><td>" + nation + "</td></tr>");
		out.println("<tr><th>출판일</th><td>" + date + "</td></tr>");
		out.println("<tr><th>출판사</th><td>" + publisher + "</td></tr>");
		out.println("<tr><th>저자</th><td>" + writer + "</td></tr>");
		out.println("<tr><th>도서가격</th><td>" + price + money + "</td></tr>");
		out.println("<tr><th>도서설명</th><td>" + content + "</td></tr>");
		out.println("</table><a href='/WSjava_Servlet/Book.html'>도서 등록</a>");
		out.println("</body></html>");
		
	
	}

}
