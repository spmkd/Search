package com.javelingroup.search.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javelingroup.search.dto.SearchContext;
import com.javelingroup.search.dto.SearchResult;
import com.javelingroup.search.service.SearchService;

@WebServlet(urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchTerm = request.getParameter("term");

        if (searchTerm == null) {
            searchTerm = ""; // use an empty string to prevent a
                             // NullPointerException
        }

        SearchContext searchContext = new SearchContext(searchTerm);

        SearchService service = new SearchService();
        SearchResult searchResult = service.search(searchContext);

        request.setAttribute("searchResult", searchResult);

        // dispatching to the jsp page to display the results
        RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
        rd.forward(request, response);
    }
}