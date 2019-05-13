package com.movie.movieMIDb.controller;
import com.movie.movieMIDb.dto.MovieDTO;
import com.movie.movieMIDb.model.Movie;
import com.movie.movieMIDb.repository.MovieRepository;
import com.movie.movieMIDb.service.MovieService;
import com.movie.movieMIDb.utils.MovieFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieFactory movieFactory;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping()
    public ResponseEntity<?> getAllMovie(){
        List<Movie> movies = movieService.getAllMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = movieService.createMovie(movieDTO);
        movieFactory.getMovie().add(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable int id, @RequestBody Movie movie){
        for (int i = 0; i < movieFactory.getMovie().size(); i++){
            if(id == movieFactory.getMovie().get(i).getId()) {
                this.movieFactory.getMovie().set(i, movie);
                return new ResponseEntity<>(movie, HttpStatus.OK);
            }
        }
        return new ResponseEntity<> ("Movie-Id don't exist!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){

        for(Movie movie: movieFactory.getMovie()){
            if (movie.getId() == id){
                this.movieFactory.getMovie().remove(movie);
                return new ResponseEntity<>(movie, HttpStatus.OK);
            }
        }

        return new ResponseEntity<> ("Movie-Id don't exist!", HttpStatus.NOT_FOUND);
    }



}
