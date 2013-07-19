package com.javelingroup.navigate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javelingroup.data.LoadFile;
import com.javelingroup.navigate.dto.NavigateContext;
import com.javelingroup.navigate.dto.NavigateResult;
import com.javelingroup.navigate.service.NavigateService;

@WebServlet("/navigation")
public class Navigation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String breadCrumb = request.getParameter("breadCrumb");

        if (breadCrumb == null) {
            breadCrumb = "";
        }
        
        ServletContext sc = getServletContext();

        NavigateContext navigateContext = new NavigateContext(breadCrumb);
        NavigateService navigateService = new NavigateService();

        NavigateResult navigateResult = navigateService.createNavigation(navigateContext, sc);

        request.setAttribute("navigateResult", navigateResult);

        RequestDispatcher rd = request.getRequestDispatcher("/navigation.jsp");
        rd.forward(request, response);

    }

    public void init() throws ServletException {
        super.init();
        
        //load the media data information
        LoadFile lf = new LoadFile();
        lf.ReadFile();
        
        //put all media data information into global use
        ServletContext sc = getServletContext();
        sc.setAttribute("Data", lf.getData());
        
    }

}