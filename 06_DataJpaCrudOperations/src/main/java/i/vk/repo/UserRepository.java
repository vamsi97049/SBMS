package i.vk.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import i.vk.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByCountry(String country);
}
