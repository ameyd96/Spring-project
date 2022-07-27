package com.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Rating;
import com.app.model.UserRating;


@RequestMapping("/ratingsdata")
@RestController
public class RatingDataResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRatinfInfo(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,4);
	}
	
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRatinfInfo(@PathVariable("userId") String userId) {

		List<Rating> ratings = Arrays.asList(new Rating("1", 4), new Rating("2", 3), new Rating("3", 6));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
