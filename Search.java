
import java.util.*;

public class Lab06B_Q3_Secme {
        


    public static void main(String[] args) {
        
         String[] line = {"Love is never wrong.", "Speak low, if you speak love.", "All you need is love"," We love the things for what they are."};
         String search = "love"; //search word 
         
         String[] result = findStrings(line,search);  //call for method 
         	
         for (int i = 0 ; i<result.length;i++){ 
         	
         	if (result[i]!= null){  //not to print out null in the storing array 
         	
         		System.out.println("the line contaning search words is: " + result[i]);  //print out the results
         	}
         	
         }
																		

        
        
    }
    
    
    public static String[] findStrings(String[] array , String search){
    	
    	int pos;
    	
    	
    	String[] store = new String[array.length];
    	
    	for (int i = 0 ; i<array.length ; i++){
    		
			String sentence = array[i].toLowerCase();  //ignores upper-lower case sensitivity
				  		
    		pos = sentence.indexOf(search.toLowerCase());    //finds the position of search word
    		
    		
    		if (pos != 0 && pos != (array[i].length()-search.length())){    //if pos is not beginning and the end then store it
    			
    			store[i] = array[i];   //store of desired sentences
    			
    		}
    		
    		
    	}
    	
    	return store;  //take stored lines to main 
    	
    	
    	
    	
    }
}
