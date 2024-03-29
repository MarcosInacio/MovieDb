package com.movie.movieMIDb.repository;

import com.movie.movieMIDb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findByTitle(String title);

}
