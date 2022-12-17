package com.MyMoviePlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyMoviePlan.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	public List<Movie> findMovieByLanguage(String lang);

}
