package com.MyMoviePlan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyMoviePlan.dto.MovieDTO;
import com.MyMoviePlan.entity.Movie;
import com.MyMoviePlan.service.MovieService;

@RestController
@RequestMapping("/movie")
@CrossOrigin("http://localhost:4200/")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	
	@PostMapping("/addMovie")
	public String addMovie(@RequestBody MovieDTO dto) {
		
		return movieService.addMovie(dto);		
	}
	
	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies(){
		
		return movieService.getAllMovies();		
	}
	
	@PutMapping("/updateMovie/{id}")
	public String updateEmployee(@PathVariable Long id, @RequestBody MovieDTO newMovie){
		System.out.println(newMovie);
		return movieService.updateMovie(id,newMovie);
	}

	
	@DeleteMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable long id) {
		return movieService.deleteMovie(id);
	}
	
	@GetMapping("/getmovie/{id}")
	public Movie getMovieById(@PathVariable long id) {
		return movieService.getMovieById(id);
	}
	
	@PutMapping("/updateSeats/{id}")
	public String updateSeats(@PathVariable long id, int seats){
		return movieService.updateSeatsById(id, seats);
	}
	
	@GetMapping("/getbylang/{lang}")
	public List<Movie> getMovieByLang(@PathVariable String lang) {
		return movieService.getMovieByLang(lang);
	}

}
