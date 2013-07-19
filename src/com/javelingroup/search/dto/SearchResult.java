package com.javelingroup.search.dto;

import java.util.List;

import com.javelingroup.search.model.Movie;
import com.javelingroup.search.model.Serial;

public class SearchResult {

    private String term;
    private List<Movie> movies;
    private List<Serial> serials;

    public SearchResult(String term, List<Movie> movies, List<Serial> serials) {
        this.term = term;
        this.movies = movies;
        this.serials = serials;
    }

    public String getTerm() {
        return term;
    }

    public List<Movie> getMovies() {
        return movies;
    }
    
    public List<Serial> getSerials(){
        return serials;
    }
}
