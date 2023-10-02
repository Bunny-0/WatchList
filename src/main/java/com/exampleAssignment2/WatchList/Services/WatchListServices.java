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

    HashMap<String,List<String>> map=new HashMap<>();

    public void addMovie(Movie movie){
        movieList.add(movie);
    }
    public void addDirector(Director director){
        directorList.add(director);
    }
    public void MovieDirectorPair(String director,String movie){
        if(map.containsKey(director)){
            List<String> newList=map.get(director);
            newList.add(movie);
            map.put(director,newList);
        }else{
            List<String> list=new ArrayList<>();
            list.add(movie);
            map.put(director,list);
        }
    }

    public Movie getMovieByName(String movieName){
        for(Movie temp:movieList){
            if(temp.getName().equalsIgnoreCase(movieName)){
                return temp;
            }
        }
        return null;
    }

    public Director getDirectorByName(String directorName){
        for(Director temp:directorList){
            if(temp.getName().equalsIgnoreCase(directorName)){
                return temp;
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String directorName){
        for(String temp:map.keySet()){
            if(temp.equalsIgnoreCase(directorName)){
                return map.get(temp);
            }
        }
        return null;
    }

    public List<Movie> findAllMovies(){
        return movieList;
    }
    public void deleteDirectorByName(String directorName){
        List<String> movieObj=null;
        for(String temp:map.keySet()){
            if(temp.equalsIgnoreCase(directorName)){
                movieObj=map.get(temp);
                System.out.println("in line 72 "+movieObj);
                map.remove(temp);
            }
        }
        for(String movie:movieObj){
            for(Movie movie1 : movieList){
                if(movie1.getName().equalsIgnoreCase(movie)){
                    movieList.remove(movie1);
                }
            }
        }
        for(Director dir :directorList){
            if(dir.getName().equalsIgnoreCase(directorName)){
                directorList.remove(dir);
            }
        }
    }

    public void deleteAllDirectors(){
        map.clear();
        movieList.clear();
        directorList.clear();
    }

}
