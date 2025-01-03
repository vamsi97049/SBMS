package i.vk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
