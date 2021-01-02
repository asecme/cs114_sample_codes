


//ARDA SEÇME 21201465

import java.util.ArrayList;

public class Site {
	
	//Data Members

	private ArrayList<House> houseList;
	private String siteName;
	private int residents;

	
	
	//Contructor
    public Site(String nameOfSite) {
    
    	siteName  = nameOfSite;
		houseList = new ArrayList<House>();
    	residents = 0;	

    
    }
    
    public void addHouse(String name, String location, int res, double charge ){
    	
    	House house = new House(name,location,res,charge); // house object that is read from file
    		
    	houseList.add(house); //adds house objects
    	updateTotalResidents(); // update resident number
    	
    }
    
    public void updateTotalResidents(){ 
    	
    	int temp = 0;
    	
    	for(int i = 0 ; i < houseList.size() ; i++){
    		
	    	temp += houseList.get(i).getResNo(); // adds each residents 
    	
    	}
    	
    	residents = temp; // at the end equate temp to resident number
    	
    	
    }
    
    public void viewHouses(){ //print out the houses 
    	
    	
    	System.out.println("List of Houses in " + siteName);  //print out the site name that is read from file
    	System.out.println("---------------------------------------");
    	
    	for ( int i = 0 ; i < houseList.size() ; i++){
    		
    		System.out.println(houseList.get(i).toString());  //print out the house objects
   		
    	}
    	System.out.println("---------------------------------------");
    	System.out.println("Total Residents on the site: " + residents);  //print out the total resident number
		System.out.println("---------------------------------------");

    	
    }
   	public ArrayList<House> searchByFee(int min, int max){
   		
   		ArrayList<House> store = new ArrayList<House>();
   		
   		for ( int i = 0 ; i < houseList.size() ; i++){
   			
   			if (houseList.get(i).calculateTotalServiceFee() <= max && houseList.get(i).calculateTotalServiceFee() >= min){ //look for the range
   				
   				store.add(houseList.get(i)); //if satisfies the condition add to new array list
			   	
   				
   			}
   			
   			
   		}
   		
   		return store; //return new array list
   	}
    	
    
    
    
    
    
    
    
}