package com.javelingroup.navigate.dto;

public class NavigateContext {
    private String location;

    public NavigateContext(String location){
        this.location = location;
    }
    
    public String getLocation(){
        return location;
    }
}
