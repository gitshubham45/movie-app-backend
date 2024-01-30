package com.api.movies.movieHandler;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/{imdbId}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable String imdbId){
        Optional<Movie> movies = movieService.findMovieByImdbId(imdbId);
        Movie movie = movies.orElse(null);
        List<ObjectId> reviewsIds = movie.getReviewIds();

        return new ResponseEntity<List<Review>>( reviewService.findReviewsByReviewIds(reviewsIds), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }
}
