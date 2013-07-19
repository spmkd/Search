package com.javelingroup.navigate.dto;

public class NavigateParametars {

    private String[] paramteras;
    private int count;

    public NavigateParametars(String parametars) {
        this.paramteras = parametars.split(",");
        this.count = this.paramteras.length;
    }

    public boolean contains(String[] paramterasToCheck) {

        int found=0;
        
        for (int i = 0; i < paramterasToCheck.length; i++) {

            for (int n = 0; n < paramteras.length; n++) {

                if (paramterasToCheck[i].toLowerCase().contains(paramteras[n].toLowerCase())){
                    found++;
                    break;
                }
                
            }

        }
        
        //if we find all parametars that we are searching for in the line from the data file, we can add this to the media file
        if (found==paramteras.length){
            return true;
        }else{
            return false;
        }

    }
    
    public int getCount(){
        return count;
    }

}
