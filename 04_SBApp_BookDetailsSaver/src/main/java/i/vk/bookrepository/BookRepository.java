package i.vk.bookrepository;

import org.springframework.data.repository.CrudRepository;

import i.vk.dto.BookDTO;

public interface BookRepository extends CrudRepository<BookDTO, Integer> {

}
