package i.vk.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import i.vk.entity.Movie;
import i.vk.moviedao.MovieDao;

@Service
public class MovieService {
	@Autowired
	private MovieDao dao;
	
	public void saveAll() {
		Movie m1 = new Movie(111,"Kantara","Rishb Setty","IND");
		Movie m2 = new Movie(112,"Spiderman Never go home","Jackob josh","USA");
		Movie m3 = new Movie(113,"The Night Kings 360","Premolio","AFR");
		Movie m4 = new Movie(114,"Monkey King","Mohith Sharma","IND");
		List<Movie> movies = Arrays.asList(m1,m2,m3,m4);
		dao.saveAll(movies);
	}
	public void getAllRecs() {
		 List<Movie> allRecs = dao.getAllRecs();
		 allRecs.forEach(System.out::println);
	}
}
