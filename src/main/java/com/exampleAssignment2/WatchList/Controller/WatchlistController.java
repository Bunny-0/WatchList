package com.exampleAssignment2.WatchList.Controller;

import com.exampleAssignment2.WatchList.Model.Director;
import com.exampleAssignment2.WatchList.Model.Movie;
import com.exampleAssignment2.WatchList.Services.WatchListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class WatchlistController {

    @Autowired
    WatchListServices watchListServices;

    @PostMapping("add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        watchListServices.addMovie(movie);
        return new ResponseEntity("Added SuccessFully", HttpStatus.CREATED);

    }
    @PostMapping("add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        watchListServices.addDirector(director);
        return new ResponseEntity("Added SuccessFully",HttpStatus.CREATED);
    }

    @PutMapping("add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam(name="director") String director,@RequestParam(name="movie") String movie){
        watchListServices.MovieDirectorPair(director,movie);
        return new ResponseEntity("Paired SuccessFully",HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie=watchListServices.getMovieByName(name);
        return new ResponseEntity(movie,HttpStatus.OK);

    }
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director director=watchListServices.getDirectorByName(name);
        return new ResponseEntity(director,HttpStatus.OK);

    }
    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> getMovie=watchListServices.getMoviesByDirectorName(director);
        return new ResponseEntity(getMovie,HttpStatus.OK);

    }

    @GetMapping("get-all-movies")
    public ResponseEntity findAllMovies(){
        List<Movie> movieList=watchListServices.findAllMovies();
        return new ResponseEntity(movieList,HttpStatus.OK);
    }

    @DeleteMapping("delete-director-by-name/{name}")
    public  ResponseEntity deleteDirectorByName(@PathVariable String name){
        watchListServices.deleteDirectorByName(name);
       return new ResponseEntity("Deleted SuccessFully",HttpStatus.OK);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        watchListServices.deleteAllDirectors();
        return new ResponseEntity<>("Deleted SuccessFully",HttpStatus.OK);
    }


}
