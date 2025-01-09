package i.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entity.LoginSource;

public interface LoginSourceRepository extends JpaRepository<LoginSource, String> {

}
