package com.MyMoviePlan.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyMoviePlan.dto.MovieDTO;
import com.MyMoviePlan.entity.Movie;
import com.MyMoviePlan.repository.MovieRepository;
import com.MyMoviePlan.service.MovieService;



@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public String addMovie(MovieDTO movieDto) {

		Movie movie = new Movie();

		movie.setName(movieDto.getName());
		movie.setGenre(movieDto.getGenre());
		movie.setLanguage(movieDto.getLanguage());
		movie.setUrl(movieDto.getUrl());
		movie.setUrl(movieDto.getUrl());
		movieRepository.save(movie);
		return "New Movie Added Successfully";
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public String updateMovie(Long id,MovieDTO movieDto) {
		
		Movie movie = movieRepository.findById(id).get();
		
		movie.setName(movieDto.getName());
		movie.setGenre(movieDto.getGenre());
		movie.setLanguage(movieDto.getLanguage());
		movie.setUrl(movieDto.getUrl());
		movie.setUrl(movieDto.getUrl());
		movieRepository.save(movie);		
		return "Updated Successfully";
	}

	@Override
	public Movie getMovieById(long id) {
		
		return movieRepository.findById(id).get();
	}

	@Override
	public String deleteMovie(long id) {
		movieRepository.deleteById(id);
		return "Movie deleted";
	}
	
	@Override
	public String updateSeatsById(long id, int newSeats) {
		
		Movie movie = movieRepository.findById(id).get();
		movie.setNoOfSeats(newSeats);	
		movieRepository.save(movie);
		return "Seats updated";
	}
	
	@Override
	public List<Movie> getMovieByLang(String lang){
		
		return movieRepository.findMovieByLanguage(lang);
		
	}
}
