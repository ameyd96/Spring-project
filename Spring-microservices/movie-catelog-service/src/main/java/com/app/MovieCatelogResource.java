package com.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.model.CatelogItem;
import com.app.model.Movie;
import com.app.model.Rating;
import com.app.model.UserRating;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	// get all rated movie id

	// for each movieId call movie info service and get details

	// put them all together
	@RequestMapping("/{userId}")
	public List<CatelogItem> getCatelog(@PathVariable("userId") String userId) {
		
		//RestTemplate restTemplate=new RestTemplate();
	//Movie movie= restTemplate.getForObject("http://localhost:8082/movies/foo", Movie.class);
		
		
		//WebClient is another way to call apis or communicate microservices like RestTemplate
		//WebClient.Builder builder =WebClient.builder();

		//List<Rating> ratings = Arrays.asList(new Rating("1", 4), new Rating("2", 3), new Rating("3", 6));
		 
		// for each movieId call movie info service and get details
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/user" + userId,UserRating.class);
		//below is returning movie name from movieInfo service and
		//rating is returning from rating service
		//api is called from rest template of rating service
		return ratings.getUserRating().stream().map(rating -> {
			
			//with RestTemplate (deprecated)
			
			Movie movie= restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			//with WebClient  (latest use)
			
			/*
			Movie movie=webClientBuilder.build()
			.get()
			.uri("http://localhost:8082/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono( Movie.class)
			.block();
			
			*/
			
			// put them all together
			return new CatelogItem(movie.getName(), "Description", rating.getRating());
		})
		.collect(Collectors.toList());

		//return Collections.singletonList(new CatelogItem("Harry Potter", "Test", 4));
	}

}
