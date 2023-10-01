package com.exampleAssignment2.WatchList.Services;

import com.exampleAssignment2.WatchList.Model.Director;
import com.exampleAssignment2.WatchList.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WatchListServices {


    List<Movie> movieList=new ArrayList<>();
    List<Director> directorList=new ArrayList<>();

    HashMap<Director,List<Movie>> map=new HashMap<>();

    public void addMovie(Movie movie){
        movieList.add(movie);
    }
    public void addDirector(Director director){
        directorList.add(director);
    }
    public void MovieDirectorPair(Director director,Movie movie){
        if(map.containsKey(director)){
            List<Movie> newList=map.get(director);
            newList.add(movie);
            map.put(director,newList);
        }else{
            List<Movie> list=new ArrayList<>();
            list.add(movie);
            map.put(director,list);
        }
    }

    public Movie getMovieByName(String movieName){
        for(Movie temp:movieList){
            if(temp.equals(movieName)){
                return temp;
            }
        }
        return null;
    }

    public Director getDirectorByName(String directorName){
        for(Director temp:directorList){
            if(temp.equals(directorName)){
                return temp;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByDirectorName(String directorName){
        for(Director temp:map.keySet()){
            if(temp.getName().equalsIgnoreCase(directorName)){
                return map.get(temp);
            }
        }
        return null;
    }

    public List<Movie> findAllMovies(){
        return movieList;
    }
    public void deleteDirectorByName(String directorName){
        Director dirObj=null;
        List<Movie> movieObj=null;
        for(Director temp:map.keySet()){
            if(temp.getName().equalsIgnoreCase(directorName)){
                directorList.remove(temp);
                movieObj=map.get(temp);
                map.remove(temp);
            }
        }
        for(Movie movie:movieObj){
            movieList.remove(movie);
        }
    }

    public void deleteAllDirectors(){
        map.clear();
        movieList.clear();
        directorList.clear();
    }

}
