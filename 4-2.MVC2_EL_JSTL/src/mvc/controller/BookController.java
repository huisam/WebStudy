package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.BookDAO;
import mvc.service.BookService;
import mvc.vo.Book;

public class BookController {
	private BookService dao;

	public BookController() {
		dao = new BookDAO();
	}

	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Book> list = dao.searchAll();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/BookList.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		Book b = dao.searchByIsbn(isbn);
		req.setAttribute("book", b);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/BookView.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public void remove(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		dao.delete(isbn);
		try {
			res.sendRedirect("list.bookmvc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void search(HttpServletRequest req, HttpServletResponse res) {
		String search = req.getParameter("search");
		Book b = new Book();
		switch (search) {
		case "Title":
			b = dao.searchByTitle(req.getParameter("data"));
			break;
		case "Publisher":
			b = dao.searchByPublisher(req.getParameter("data"));
			break;
		case "Isbn":
			b = dao.searchByIsbn(req.getParameter("data"));
			break;
		case "Price":
			int price = Integer.parseInt(req.getParameter("data"));
			b = dao.searchByPrice(price);
			break;
		default:
			break;
		}
		req.setAttribute("book", b);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/BookView.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public void goBookAddPage(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect("view/Book.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void add(HttpServletRequest req, HttpServletResponse res) {
		String[] book = req.getParameterValues("book");
		String title = req.getParameter("bookName");
		String catalogue = req.getParameter("booktype");
		String author = req.getParameter("writer");
		String prices = req.getParameter("price");
		if (book == null || title.equals("") || catalogue.equals("") || author.equals("")
				|| prices.equals("")) {
			try {
				res.sendRedirect("view/Book.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String isbn = book[0] + "-" + book[1] + "-" + book[2];
		String nation = req.getParameter("nation");
		String publishDate = req.getParameter("date");
		String publisher = req.getParameter("publisher");
		int price = Integer.parseInt(prices);
		String currency = req.getParameter("money");
		String description = req.getParameter("content");
		Book newBook = new Book(isbn, title, catalogue, nation, publishDate, publisher, author, price, currency,
				description);
		dao.add(newBook);
		// 최근 책은 session에 저장
		try {
			res.sendRedirect("list.bookmvc");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
