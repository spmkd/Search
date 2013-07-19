package com.javelingroup.navigate.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.javelingroup.data.Data;
import com.javelingroup.navigate.dto.NavigateContext;
import com.javelingroup.navigate.dto.NavigateParametars;
import com.javelingroup.navigate.dto.NavigateResult;
import com.javelingroup.navigate.model.Media;

public class NavigateService implements ICreateNavigation {

    public NavigateResult createNavigation(NavigateContext request, ServletContext servletContext) {

        List<Media> result = new ArrayList<Media>();
        
        List<Data> data = new ArrayList<Data>();

        // initial request for navigation
        if (request.getLocation() == "") {
            
            request = new NavigateContext("Media");
            
            result.add(new Media("Movies"));
            result.add(new Media("Serials"));

            return new NavigateResult(request.getLocation(), result);
        }
        
        data = (List<Data>) servletContext.getAttribute("Data");
        
        // all subsequent requests
        NavigateParametars navigateParametars = new NavigateParametars(request.getLocation());
        
        //check the whole data for the navigated parametars
        for(int i=0 ; i < data.size(); i++){
            
            Data toTest = data.get(i);
            
            String[] taken = toTest.getData();
            int numOfParts = taken.length;
            
            int testingPart = navigateParametars.getCount();
            
            if (numOfParts<=testingPart){
                continue;
            }
            
            String toBeAdded = toTest.getData()[navigateParametars.getCount()];
            
            if(navigateParametars.contains(toTest.getData())){
                
                boolean entryExists = false;
                //check for duplicates
                for (int n=0; n<result.size(); n++){
                    
                    Media test = result.get(n);
                    
                    if (test.getTitle().toLowerCase().equals(toBeAdded.toLowerCase())){
                        entryExists = true;
                    }
                    
                }
                
                if(!entryExists){
                    result.add(new Media(toBeAdded));
                }
                
            }
            
        }

        return new NavigateResult(request.getLocation(), result);
    }

}
