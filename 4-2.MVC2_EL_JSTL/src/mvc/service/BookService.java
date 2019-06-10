package mvc.service;

import java.util.ArrayList;

import mvc.vo.Book;

public interface BookService {
	public ArrayList<Book> searchAll();
	public void add(Book b);
	public void delete(String isbn);
	public Book searchByIsbn(String isbn);
	public Book searchByTitle(String title);
	public Book searchByPublisher(String publisher);
	public Book searchByPrice(int price);
	
}
