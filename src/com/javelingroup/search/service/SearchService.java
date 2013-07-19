package com.javelingroup.search.service;

import java.util.ArrayList;
import java.util.List;

import com.javelingroup.search.dto.SearchContext;
import com.javelingroup.search.dto.SearchResult;
import com.javelingroup.search.model.Movie;
import com.javelingroup.search.model.Serial;

public class SearchService implements ISearch {

    private static String[] movieTitles = new String[] { "The Shawshank Redemption", "The Godfather", "12 Monkeys" };
    private static String[] serialTitles = new String[] { "Anger Managment", "It's always sunny in Philadelphia",
            "The Office" };

    public SearchResult search(SearchContext request) {

        List<Movie> result = new ArrayList<Movie>();
        List<Serial> result2 = new ArrayList<Serial>();

        String searchTerm = request.getTerm();

        // Load result with Movies
        if (!searchTerm.trim().equals("")) {
            for (String movieTitle : movieTitles) {
                if (movieTitle.contains(searchTerm)) {
                    result.add(new Movie(movieTitle));
                }
            }
        }

        // Load result with Serials
        if (!searchTerm.trim().equals("")) {
            for (String serialTitle : serialTitles) {
                if (serialTitle.contains(searchTerm)) {
                    result2.add(new Serial(serialTitle));
                }
            }
        }

        return new SearchResult(searchTerm, result, result2);
    }
}
