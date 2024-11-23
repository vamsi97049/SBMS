package i.vk.dao;

import org.springframework.stereotype.Repository;

import i.vk.bookrepository.BookRepository;
import i.vk.dto.BookDTO;

@Repository
public class BookDAO {
	private BookRepository bookRepo;
	
	public BookDAO(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public String saveBook(BookDTO book) {
		if(!bookRepo.existsById(book.getBookId())) {
			bookRepo.save(book);
			return "Book Saved in DB";
		}
		return "Existing book";
	}
}
