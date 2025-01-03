package i.vk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entity.LoginSource;

public interface LoginRepository extends JpaRepository<LoginSource, String> {

}
