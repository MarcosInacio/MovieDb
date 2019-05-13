package com.movie.movieMIDb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.movieMIDb.dto.CreditsDTO;
import com.movie.movieMIDb.dto.MovieDTO;
import com.movie.movieMIDb.dto.PersonDTO;
import com.movie.movieMIDb.model.Person;
import com.movie.movieMIDb.service.MovieService;
import com.movie.movieMIDb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAutoConfiguration
public class MovieMiDbApplication {

    @Autowired
    MovieService movieService;

    @Autowired
    PersonService personService;

	public static void main(String[] args) {
        SpringApplication.run(MovieMiDbApplication.class, args);

    }

    @Bean
    public void run(){

		int movieId[] = {299534,299537,456740,299536,537915,495925,438650,543103,287947,450465,
                         24428,445629,99861,284054,457799,487297,283995,535167,166428,447404,
                         284053,500852,920,468224,263115};

		int serieId[] = {1399,63926,60735,1412,63174,1416,46261,63210,73223,62688,12609,456,1434,
                         1622,46952,85844,48866,69050,88052,85937,1403,62643,4614,17610,30984};

		int personId[] = {287,3223,1223786,976,17286};

		String urlId = "https://api.themoviedb.org/3/discover/tv?api_key=e65b58a2a9c410c4751737654342294d&language=en-US&page=2";
        String url = "https://api.themoviedb.org/3/movie/{movieId}?api_key=e65b58a2a9c410c4751737654342294d&language=en-US";
        String url2 = "https://api.themoviedb.org/3/movie/{movieId}/credits?api_key=e65b58a2a9c410c4751737654342294d&language=en-US";
        String url3 = "https://api.themoviedb.org/3/person/{personId}?api_key=e65b58a2a9c410c4751737654342294d&language=en-US";
        String url4 = "https://api.themoviedb.org/3/tv/{serieId}?api_key=583aea9c82cd59697a0aa7b1dc106a21&language=en-US";

        RestTemplate rtMovieDetails = new RestTemplate();
        ObjectMapper mapperMovieDetails = new ObjectMapper();
        List<MovieDTO> movieDTOS = new ArrayList<>();

        RestTemplate rtMovieCredits = new RestTemplate();
        ObjectMapper mapperMovieCredits = new ObjectMapper();
        List<CreditsDTO> creditsDTOS = new ArrayList<>();

        RestTemplate rtPerson = new RestTemplate();
        ObjectMapper mapperPerson = new ObjectMapper();
        List<PersonDTO> personDTOS = new ArrayList<>();

        for (int i = 0; i < 25; i++){
            String resultMovieDetails = rtMovieDetails.getForObject(url, String.class, movieId[i]);
            String resultMovieCredits = rtMovieCredits.getForObject(url2, String.class, movieId[i]);

            try {
                TimeUnit.SECONDS.sleep(5);
                MovieDTO mappingMovie = mapperMovieDetails.readValue(resultMovieDetails, MovieDTO.class);
                movieDTOS.add(mappingMovie);

                CreditsDTO mappingCredits = mapperMovieCredits.readValue(resultMovieCredits, CreditsDTO.class);
                creditsDTOS.add(mappingCredits);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++){
            String resultPerson = rtPerson.getForObject(url3, String.class, personId[i]);

            try {
                TimeUnit.SECONDS.sleep(5);
                PersonDTO mappingPerson = mapperPerson.readValue(resultPerson, PersonDTO.class);
                personDTOS.add(mappingPerson);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        this.movieService.saveMovie(movieDTOS, creditsDTOS);
        this.personService.savePerson(personDTOS);

	}

}
