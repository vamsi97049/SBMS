package i.vk.service;

import org.springframework.stereotype.Service;

import i.vk.dao.BookDAO;
import i.vk.dto.BookDTO;

@Service
public class BookService {
	private BookDAO dao;
	public BookService(BookDAO dao) {
		this.dao=dao;
	}
	public String saveBookService(BookDTO book) {
		return dao.saveBook(book);
	}
}
