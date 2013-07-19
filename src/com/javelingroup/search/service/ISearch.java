package com.javelingroup.search.service;

import com.javelingroup.search.dto.SearchContext;
import com.javelingroup.search.dto.SearchResult;

public interface ISearch {
    SearchResult search(SearchContext request);
}
