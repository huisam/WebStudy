package mvc.dao;

import java.util.ArrayList;

import mvc.service.BookService;
import mvc.vo.Book;

public class BookDAO implements BookService {
	private ArrayList<Book> list;

	public BookDAO() {
		list = new ArrayList<>();
		list.add(new Book("222", "harrypotter", "소설", "외국", "2018-09-23", "문학수첩", "조앤롤링", 32000, "원", "해리의 마법학교가 시작된다!!"));
		list.add(new Book("333", "harrypotter2", "소설", "외국", "2018-10-02", "문학수첩", "조앤롤링", 30000, "원", "해리의 마법학교가 시작된다!!"));
		list.add(new Book("444", "harrypotter3", "소설", "외국", "2018-11-15", "문학수첩", "조앤롤링", 38000, "원", "해리의 마법학교가 시작된다!!"));
	}

	public ArrayList<Book> searchAll() {
		return list;
	}
	
	@Override
	public void add(Book b) {
		list.add(b);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for (Book book : list) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public void delete(String isbn) {
		Book search = searchByIsbn(isbn);
		list.remove(search);
	}

	@Override
	public Book searchByTitle(String title) {
		for (Book book : list) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book searchByPublisher(String publisher) {
		for (Book book : list) {
			if (book.getPublisher().equals(publisher)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book searchByPrice(int price) {
		for (Book book : list) {
			if (book.getPrice() == price) {
				return book;
			}
		}
		return null;
	}

	
}
