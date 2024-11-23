package i.vk.dto;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookDTO {
	@Id
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double price;
	
}
