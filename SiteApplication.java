

//ARDA SEÇME 21201465

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class SiteApplication {

    public static void main(String[] args) throws FileNotFoundException {
        
        File newFile = new File("site_list.txt");  //create file object
        
        Scanner input = new Scanner(newFile);     //read file
                
        input.useDelimiter(";");
        //input.useLocale(Locale.US);
        
        Site siteList = new Site(input.next()); // create site object
        
        
        while(input.hasNext()){  //read till the end
        	
        	String name = input.next(); //read the owner name
        	String adress = input.next(); //read the address
        	int res = input.nextInt(); //read the resident number
        	double fee = input.nextInt(); //read the charge per month
        	
        	siteList.addHouse(name,adress,res,fee); //site object created house object itself as it is defined in Site class.
        
        }
        input.close(); 			//close the file
        
        siteList.viewHouses(); 	//print out the houses
        ArrayList<House> result = siteList.searchByFee(300,400); //look for houses in desired range
        
        System.out.println(result); // print out the desired houses, if there is toString method no need to say result.toString()
        
        
    }
    
    
    
//ARDA SEÇME 21201465
    
}
