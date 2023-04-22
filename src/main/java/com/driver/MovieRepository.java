package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> MovieDirectorPairDb = new HashMap<>();

    public void addMovie(Movie movie) {
        if(!movieDb.containsKey(movie.getName()))
        {
            movieDb.put(movie.getName(),movie);
        }
    }

    public void addDirector(Director director) {
        if(!directorDb.containsKey(director.getName()))
        {
            directorDb.put(director.getName(),director);
        }
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(!MovieDirectorPairDb.containsKey(directorName))
        {
            List<String> l = new ArrayList<>();
            MovieDirectorPairDb.put(directorName,l);
        }
        List<String> l= MovieDirectorPairDb.get(directorName);
        l.add(movieName);
        MovieDirectorPairDb.put(directorName,l);
    }

    public Movie getMovieByName(String movieName) {
        Movie movie = movieDb.get(movieName);
        return movie;
    }

    public Director getDirectorByName(String directorName) {
        Director director = directorDb.get(directorName);
        return director;
    }

    public List<String> getMovieByDirectorName(String directorName) {
        List<String> ans = MovieDirectorPairDb.get(directorName);
        return ans;
    }

    public List<String> getAllMovies() {
        List<String> ans = new ArrayList<>();
        for(String movieName:movieDb.keySet())
        {
            ans.add(movieName);
        }
        return ans;
    }

    public void deleteDirectorByName(String directorName) {
        directorDb.remove(directorName);
        MovieDirectorPairDb.remove(directorName);
    }

    public void deleteAllDirectors() {
        for(String name:directorDb.keySet())
        {
            directorDb.remove(name);
        }

        for(String name:MovieDirectorPairDb.keySet())
        {
            MovieDirectorPairDb.remove(name);
        }
    }
}
