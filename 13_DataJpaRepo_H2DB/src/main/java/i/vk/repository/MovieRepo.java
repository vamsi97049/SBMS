package i.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer> {

}
