package i.vk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import i.vk.entity.Movie;
import i.vk.repo.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repo;
	
	// Save 
	public boolean saveMovie(Movie movie) {
		boolean isPresent = repo.existsById(movie.getMovieId());
		if(!isPresent) {
			repo.save(movie);
			return true;
		}
		return false;
	}
	// SaveAll
	public List<Movie> saveAllMovies(List<Movie> movies) {
		List<Movie> savedMovies = repo.saveAll(movies);
		if(savedMovies!=null) {
			return savedMovies;
		}
		return null;
	}
	// Fetch one by Id
	public Movie getMovieByMovieId(Integer movieId) {
		Optional<Movie> byId = repo.findById(movieId);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}
	// Fetch multiple by Id
	public List<Movie> getMoviesByMovieIds(List<Integer> movieids){
		List<Movie> allById = repo.findAllById(movieids);
		if(allById!=null) {
			return allById;
		}
		return null;
	}
	
	public List<Movie> getAllMovies(){
		List<Movie> all = repo.findAll();
		if(all!=null) {
			return all;
		}
		return null;
	}
	
	public boolean updateMovieByMovieId(Integer movieId,Movie movie) {
		boolean existsById = repo.existsById(movieId);
		if(existsById) {
			movie.setMovieId(movieId);
			repo.save(movie);
			return true;
		}
		return false;
	}
	
	public boolean deleteMovieByMovieId(Integer movieId) {
		boolean existsById = repo.existsById(movieId);
		if(existsById){
			repo.deleteById(movieId);
			return true;
		}
		return false;
	}
	
}











