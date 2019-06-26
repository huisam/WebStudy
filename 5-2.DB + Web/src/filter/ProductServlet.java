package filter;

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

import controller.ProductController;

@WebFilter("*.do")
public class ProductServlet implements Filter {

	private ProductController productController;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		
		String reqString = req.getServletPath();
		switch (reqString) {
		case "/ProductList.do":
			productController.showList(req,res);
			break;
		case "/ProductAddReady.do":
			productController.readyAddProduct(req, res);
			break;
		case "/ProductAdd.do":
			productController.addProduct(req, res);
			break;
		case "/ProductDetail.do":
			productController.searchProduct(req, res);
			break;
		case "/ProductDelete.do":
			productController.deleteProduct(req, res);
			break;
		case "/ProductModify.do":
			productController.modifyProduct(req, res);
			break;
		case "/ProductModifyReady.do":
			productController.modifyProductReady(req, res);
			break;
		case "/error.do":
			productController.error(req, res);
			break;
		default:
			break;
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		productController = new ProductController();
	}

}
