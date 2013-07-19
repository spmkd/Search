package com.javelingroup.navigate.service;

import javax.servlet.ServletContext;

import com.javelingroup.navigate.dto.NavigateContext;
import com.javelingroup.navigate.dto.NavigateResult;

public interface ICreateNavigation {

    NavigateResult createNavigation(NavigateContext request,ServletContext servletContext);

}
