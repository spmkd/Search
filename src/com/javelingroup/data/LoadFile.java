package com.javelingroup.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadFile {
    
    List<Data> data = new ArrayList<Data>();
    
    File pathToFile = new File("C:\\Users\\stojanp\\Desktop\\listForWebApp.txt");
    
    public void ReadFile() {
        
        FileReader fileReader = null;
        
        try{
            fileReader = new FileReader(pathToFile);
        }catch(Exception e){};
        
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String line = null;
        
        try {
            while ((line = bufferedReader.readLine() ) != null) {
                data.add( new Data(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public List<Data> getData(){
        return data;
    }

}
