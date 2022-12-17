package com.MyMoviePlan.serviceImplement;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


import com.MyMoviePlan.dto.MovieDTO;
import com.MyMoviePlan.entity.Movie;
import com.MyMoviePlan.service.MovieService;

import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
class MovieServiceTest {
		
	@Autowired
	private MovieService movieService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	@DirtiesContext
	public void addMovieTest() {

		MovieDTO movie = new MovieDTO(10l,"Titanic","Drama","English", "titanic.jpg","12:30PM", 100, 200);

		String add = movieService.addMovie(movie);
		assertNotNull(add);

	}

	@Test
	@DirtiesContext
	public void getAllMoviesTest() {
		List list = movieService.getAllMovies();
		assertThat(list).size().isGreaterThan(0);
	}

	public void updateMovieTest() {

		Movie movie = new Movie();
		
		movie.setId(10l);
		movie.setLanguage("English");
		movie.setName("Titanic");
		movie.setGenre("Drama");
		movie.setNoOfSeats(100);
		movie.setShowTime("12:30PM");
		movie.setTicketPrice(200);
		movie.setUrl("titanic.jpg");
		
		MovieDTO movie2 = new MovieDTO(10l,"Intersteller","si-fi","English", "Intersteller.jpg","12:30PM", 100, 200);
		
		String response = movieService.updateMovie(10l,movie2);
		assertTrue(response.isEmpty());
		assertEquals("User Updated Successfully",response);
	}


	@Test
	@DirtiesContext
	public void getMovieByLangTest() {
		
		MovieDTO movie = new MovieDTO(10l,"Titanic","Drama","English", "titanic.jpg","12:30PM", 100, 200);

		String mymovie = movieService.addMovie(movie);

		assertEquals("English", movie.getLanguage());

	}

}

