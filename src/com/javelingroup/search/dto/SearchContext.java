package com.javelingroup.search.dto;

public class SearchContext {
    private String term;

    public SearchContext(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }
}
