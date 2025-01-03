package i.vk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
