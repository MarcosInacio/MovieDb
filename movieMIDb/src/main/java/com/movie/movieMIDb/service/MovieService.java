package com.movie.movieMIDb.service;

import com.movie.movieMIDb.dto.CreditsDTO;
import com.movie.movieMIDb.dto.MovieDTO;
import com.movie.movieMIDb.model.Cast;
import com.movie.movieMIDb.model.Country;
import com.movie.movieMIDb.model.Genre;
import com.movie.movieMIDb.model.Movie;
import com.movie.movieMIDb.utils.MovieFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService{

    @Autowired
    private MovieFactory movieFactory;

    public List<Movie> getAllMovie(){

        return movieFactory.getMovie();
    }

    public void saveMovie(List<MovieDTO> movieDTOS, List<CreditsDTO> creditsDTOS) {

        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < movieDTOS.size(); i++) {

            Set<Country> countries = new HashSet<>();
            for (int j = 0; j < movieDTOS.get(i).getProduction_countries().size(); j++) {
                Country country = new Country();
                country.setIso_3166_1(movieDTOS.get(i).getProduction_countries().get(j).getIso_3166_1());
                country.setName(movieDTOS.get(i).getProduction_countries().get(j).getName());
                countries.add(country);
            }

            Set<Genre> genresSet = new HashSet<>();
            for (int j = 0; j < movieDTOS.get(i).getGenres().size(); j++) {
                Genre genre = new Genre();
                genre.setId(movieDTOS.get(i).getGenres().get(j).getId());
                genre.setName(movieDTOS.get(i).getGenres().get(j).getName());
                genresSet.add(genre);
            }

            Set<Cast> casts = new HashSet<>();
            int j = 0;
            while (j < creditsDTOS.get(i).getCast().size() && j < 10) {
                Cast cast = new Cast();
                cast.setCast_id(creditsDTOS.get(i).getCast().get(j).getCast_id());
                cast.setCharacter(creditsDTOS.get(i).getCast().get(j).getCharacter());
                cast.setCreditId(creditsDTOS.get(i).getCast().get(j).getCredit_id());
                cast.setGender(creditsDTOS.get(i).getCast().get(j).getGender());
                cast.setId(creditsDTOS.get(i).getCast().get(j).getId());
                cast.setName(creditsDTOS.get(i).getCast().get(j).getName());
                cast.setOrder(creditsDTOS.get(i).getCast().get(j).getOrder());
                cast.setProfilePath(creditsDTOS.get(i).getCast().get(j).getProfile_path());
                casts.add(cast);
                j++;
            }

            Movie movie = new Movie();
            movie.setId(movieDTOS.get(i).getId());
            movie.setTitle(movieDTOS.get(i).getTitle());
            movie.setOverview(movieDTOS.get(i).getOverview());
            movie.setCasts(casts);
            movie.setProductionCountries(countries);
            movie.setOriginalLanguage(movieDTOS.get(i).getOriginal_language());
            movie.setReleaseDate(movieDTOS.get(i).getRelease_date());
            movie.setRuntime(movieDTOS.get(i).getRuntime());
            movie.setGenreSet(genresSet);
            movies.add(movie);
        }
        movieFactory.setMovie(movies);
    }

    public Movie createMovie(MovieDTO movieDTO){

        Set<Country> countries = new HashSet<>();
        for (int j = 0; j < movieDTO.getProduction_countries().size(); j++) {
            Country country = new Country();
            country.setIso_3166_1(movieDTO.getProduction_countries().get(j).getIso_3166_1());
            country.setName(movieDTO.getProduction_countries().get(j).getName());
            countries.add(country);
        }

        Set<Genre> genresSet = new HashSet<>();
        for (int j = 0; j < movieDTO.getGenres().size(); j++) {
            Genre genre = new Genre();
            genre.setId(movieDTO.getGenres().get(j).getId());
            genre.setName(movieDTO.getGenres().get(j).getName());
            genresSet.add(genre);
        }

        Set<Cast> casts = new HashSet<>();
        int j = 0;
        while (j < movieDTO.getCastDTO().size()) {
            Cast cast = new Cast();
            cast.setCast_id(movieDTO.getCastDTO().get(j).getCast_id());
            cast.setCharacter(movieDTO.getCastDTO().get(j).getCharacter());
            cast.setCreditId(movieDTO.getCastDTO().get(j).getCredit_id());
            cast.setGender(movieDTO.getCastDTO().get(j).getGender());
            cast.setId(movieDTO.getCastDTO().get(j).getId());
            cast.setName(movieDTO.getCastDTO().get(j).getName());
            cast.setOrder(movieDTO.getCastDTO().get(j).getOrder());
            cast.setProfilePath(movieDTO.getCastDTO().get(j).getProfile_path());
            casts.add(cast);
            j++;
        }

        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        movie.setOverview(movieDTO.getOverview());
        movie.setCasts(casts);
        movie.setProductionCountries(countries);
        movie.setOriginalLanguage(movieDTO.getOriginal_language());
        movie.setReleaseDate(movieDTO.getRelease_date());
        movie.setRuntime(movieDTO.getRuntime());
        movie.setGenreSet(genresSet);

        return movie;
    }

}
