package i.vk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import i.vk.entity.Movie;
import i.vk.service.MovieService;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping(value = "/movie-source/new-movie", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String> insertNewMovieRecord(@RequestBody Movie newMovie) {
        service.saveMovie(newMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movie Saved Successfully");
    }

    @PostMapping(value = "/movie-source/new-movies", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String> insertNewMovieRecords(@RequestBody List<Movie> newMovies) {
        service.saveAllMovies(newMovies);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movies Saved Successfully");
    }

    @GetMapping(value = "/movie-source/get-movie/{movieId}", produces = "application/json")
    public ResponseEntity<Movie> getMovieByMovieId(@PathVariable Integer movieId) {
        Movie movieByMovieId = service.getMovieByMovieId(movieId);
        return ResponseEntity.status(HttpStatus.OK).body(movieByMovieId);
    }


    @GetMapping(value = "/movie-source/getall-movies", produces = "application/json")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> allMovies = service.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(allMovies);
    }

    @GetMapping(value = "/movie-source/get-movies-by-id", produces = "application/json")
    public ResponseEntity<List<Movie>> getMoviesByMovieIds(@RequestParam List<Integer> movieIds) {
        List<Movie> moviesByMovieIds = service.getMoviesByMovieIds(movieIds);
        return ResponseEntity.status(HttpStatus.OK).body(moviesByMovieIds);
    }

    @PutMapping(value = "/movie-source/update-movie/{movieId}", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String> updateMovieByMovieId(@PathVariable Integer movieId, @RequestBody Movie movie) {
        service.updateMovieByMovieId(movieId, movie);
        return ResponseEntity.status(HttpStatus.OK).body("Movie Details are updated successfully");
    }

    @DeleteMapping(value = "/movie-source/delete-movie/{movieId}", produces = "text/plain")
    public ResponseEntity<String> deleteMovieByMovieId(@PathVariable Integer movieId) {
        service.deleteMovieByMovieId(movieId);
        return ResponseEntity.status(HttpStatus.OK).body("Movie Deleted successfully");
    }
}
