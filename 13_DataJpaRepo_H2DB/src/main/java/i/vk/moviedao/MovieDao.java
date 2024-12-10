package i.vk.moviedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import i.vk.entity.Movie;
import i.vk.repository.MovieRepo;

@Repository
public class MovieDao {
	@Autowired
	private MovieRepo repo;
	
	public void saveAll(List<Movie> movies) {
		repo.saveAll(movies);
	}
	public List<Movie> getAllRecs() {
		return repo.findAll();
	}
}
