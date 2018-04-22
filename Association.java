/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Association {
    private String english;
    private String spanish;
    public Association(String ingles, String espanol){
        english = ingles;
        spanish = espanol;
    }
    
    public String getEnglish(){
        return english;
    }
    
    public String getSpanish(){
        return spanish;
    }
}
