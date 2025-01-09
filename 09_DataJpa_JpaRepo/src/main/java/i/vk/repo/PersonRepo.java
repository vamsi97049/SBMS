package i.vk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entiry.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
