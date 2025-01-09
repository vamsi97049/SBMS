package i.vk.entiry;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
	@Id
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String country;
	
}
