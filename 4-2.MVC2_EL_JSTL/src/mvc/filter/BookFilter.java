package mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.BookController;

@WebFilter("*.bookmvc")
public class BookFilter implements Filter {

	private BookController controller;
	
    public BookFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		
		String reqString = req.getServletPath();
		System.out.println(reqString);
		switch (reqString) {
		case "/list.bookmvc":
			controller.list(req, res);
			break;
		case "/read.bookmvc":
			controller.read(req, res);
			break;
		case "/remove.bookmvc":
			controller.remove(req, res);
			break;
		case "/search.bookmvc":
			controller.search(req, res);
			break;
		case "/insertForm.bookmvc":
			controller.goBookAddPage(req, res);
			break;
		case "/insert.bookmvc":
			controller.add(req, res);
			break;
		default:
			break;
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		controller = new BookController();
	}

}
