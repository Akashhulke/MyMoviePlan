package com.MyMoviePlan.service;

import java.util.List;

import com.MyMoviePlan.dto.MovieDTO;
import com.MyMoviePlan.entity.Movie;

public interface MovieService {

	public String addMovie(MovieDTO movieDto);

	public List<Movie> getAllMovies();

	public String updateMovie(Long id,MovieDTO movieDto);

	public Movie getMovieById(long id);

	public String deleteMovie(long id);
	
	public String updateSeatsById(long id, int newSeats);
	
	public List<Movie> getMovieByLang(String lang);

}
