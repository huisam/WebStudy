package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.Product;

public class ProductController {
	private final ProductDAO productDAO = ProductDAO.getInstance();

	public void addProduct(HttpServletRequest req, HttpServletResponse res) {
		String title = req.getParameter("title");
		String kind = req.getParameter("kind");
		String maker = req.getParameter("maker");
		int price = 0;
		try {
			price = Integer.parseInt(req.getParameter("price"));
		} catch (NumberFormatException e) {
			req.setAttribute("error", "가격은 반드시 숫자로 입력해주세요");
			error(req, res);
			return;
		}
		productDAO.insertProduct(new Product(title, kind, maker, price));
		try {
			res.sendRedirect("ProductList.do");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readyAddProduct(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("html/ProductInput.html").forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void showList(HttpServletRequest req, HttpServletResponse res) {
		List<Product> list = productDAO.selectAll();
		req.setAttribute("productList", list);
		try {
			req.getRequestDispatcher("jsp/ProductList.jsp").forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public void searchProduct(HttpServletRequest req, HttpServletResponse res) {
		int isbn = 0;
		try {
			isbn = Integer.parseInt(req.getParameter("isbn"));
		} catch (NumberFormatException e) {
			req.setAttribute("error", "가격은 반드시 숫자로 입력해주세요");
			error(req,res);
			return;
		}
		Product product = productDAO.selectOne(isbn);
		req.setAttribute("product", product);
		try {
			req.getRequestDispatcher("jsp/ProductView.jsp").forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(HttpServletRequest req, HttpServletResponse res) {
		int isbn = 0;
		try {
			isbn = Integer.parseInt(req.getParameter("isbn"));
		} catch (NumberFormatException e) {
			req.setAttribute("error", "가격은 반드시 숫자로 입력해주세요");
			error(req,res);
			return;
		}
		productDAO.deleteProduct(productDAO.selectOne(isbn));
		req.setAttribute("complete", "정상적으로 삭제되었습니다!");
		try {
			req.getRequestDispatcher("jsp/complete.jsp").forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public void modifyProduct(HttpServletRequest req, HttpServletResponse res) {
		int isbn = Integer.valueOf(req.getParameter("isbn"));
		Product product = productDAO.selectOne(isbn);
		product.setKind(req.getParameter("kind"));
		product.setMaker(req.getParameter("maker"));
		product.setTitle(req.getParameter("title"));
		int price = 0;
		try {
			price = Integer.parseInt(req.getParameter("price"));
		} catch (NumberFormatException e) {
			req.setAttribute("error", "가격은 반드시 숫자로 입력해주세요");
			error(req,res);
			return;
		}
		product.setPrice(price);
		productDAO.updateProduct(product);
		req.removeAttribute("product");
		req.setAttribute("complete", "정상적으로 수정되었습니다!");
		try {
			req.getRequestDispatcher("jsp/complete.jsp").forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void modifyProductReady(HttpServletRequest req, HttpServletResponse res) {
		int isbn = 0;
		try {
			isbn = Integer.parseInt(req.getParameter("isbn"));
		} catch (NumberFormatException e) {
			req.setAttribute("error", "가격은 반드시 숫자로 입력해주세요");
			error(req,res);
			return;
		}
		Product product = productDAO.selectOne(isbn);
		req.setAttribute("product", product);
		try {
			req.getRequestDispatcher("jsp/ProductModify.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void error(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getRequestDispatcher("jsp/error.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	
	}

}
