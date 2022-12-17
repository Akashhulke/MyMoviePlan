package com.MyMoviePlan.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
	
	private Long id;
	private String name;
	private String genre;
	private String language;
	private String url;
	private String showTime;
	private int ticketPrice;
	private int noOfSeats;


}
