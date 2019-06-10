import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginSuccess.jsp");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("ID");
		String pass = request.getParameter("pass");
		if(id.equals("gogo") && pass.equals("1111")) {
			request.setAttribute("ID", id);
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/Error.jsp");
			request.setAttribute("msg", "아이디 또는 패스워드가 다릅니다.");
			dispatcher2.forward(request, response);
		}
			
		
	}

}
