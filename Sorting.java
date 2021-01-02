
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Lab08B_Secme {



    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<String> userName = new ArrayList<String>() ; //arrays to keep user names
        	
        ArrayList<String> plateNo = new ArrayList<String>() ;	//array to keep user plate numbers
        	
        readFile(plateNo,userName,"plates.txt");  //call method to read file
        
        bubbleSort(userName,plateNo);  //call method to sort the file
		printArrays(userName,plateNo); //call method to print out the sorted file
        
        
       
        
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "Enter a name to search");
        String searchName = input.next();        		  //take user input
        int value = binarySearch(userName,searchName);   //position of searched element
        
        System.out.println();
        
        if(value != -1){    //if search user exists 
        
        System.out.println("Name: " + userName.get(value) );  //print out the name of the user 
        System.out.println("ID Number " + plateNo.get(value));  //print out the plate number of the user
        }
        else 
        	System.out.println("User not Found");  //if it is not listed then give warning
    }
    
    
    public static void readFile (ArrayList<String> plateNo , ArrayList<String> userName , String fileName )throws FileNotFoundException{
    	
    	File newFile = new File(fileName);  // file object created 
    	
    	Scanner input = new Scanner(newFile); // scanner object
    	
    	while(input.hasNext()){  //while file has next element we will read the file
    		
    		plateNo.add(input.next());  //store each element to array
    		
    		userName.add(input.next());  // store each plate number into array
    	}
    	input.close();//file closed
    	System.out.println("Lists are populated and " + userName.size() + " user are inserted");
    	System.out.println("--------------------------------------");
    }
    
    public static void bubbleSort(ArrayList<String> userName , ArrayList<String> plateNo){
    	
    	
    	boolean isSorted = false;   //to control whether list is sorted or not
    	int count = 0;				//to count how many times operation is conducted
    	
    	
    	System.out.println("Sorting...");
    	System.out.println("Input size was: "+userName.size());
    	
    	for ( int i = 0; i<userName.size()-1 && isSorted == false ; i++){   
    		
    		isSorted = true; //when the list is sorted it wont enter to te following if loop
    	
    			for ( int j = 0 ; j< userName.size()-i-1 ; j++ ){  //after it puts larger element to the end there remains (size-i) element
    				
    				count++;  //counts number of the operation
    			
    			
    				if (userName.get(j).compareTo(userName.get(j+1))>0){  //puts larger element to the end of the list
    					
    					isSorted = false;  //not sorted still
    					
    					String tempuser = userName.get(j);   //temporarily stores the value 
    					String tempplate = plateNo.get(j);	//temporarily stores the value
    					
    					userName.set(j,userName.get(j+1));	//changes the prev. username with the next one
    					plateNo.set(j,plateNo.get(j+1));	//changes the prev.	user plate number with the next one
    					
    					
    					userName.set(j+1,tempuser);			//changes next user name with the prev. one
    					plateNo.set(j+1,tempplate);			//changes next user plate number with the prev. one
    					
    				
    				}
    				
    			}
    		
    		
    	}
    	System.out.println("Operation ends after " + count + " iteration \n");
    	System.out.println("--------------------------------------");
    	
    	
    }
    
    public static void printArrays(ArrayList<String> userName , ArrayList<String> plateNo){
    	
    	
    	
    	for (int i = 0 ; i<userName.size() ; i++ ){
    		
    		System.out.print(userName.get(i)+ "\t\t");  //prints out each user name
    		System.out.print(plateNo.get(i)+"\n");		// prints out each user plate number
    		
    	}
    	
    	
    	
    }
    
    public static int binarySearch (ArrayList<String> userName , String searchName){
    	
    	int init = 0;  
    	
    	int end = userName.size()-1;	
		
		int middle = 0;
		
		while (init <= end){   // while we keep track of the number
			
			
			middle = (init + end )/2;	//we found the middle index 

			if (searchName.compareToIgnoreCase(userName.get(middle))<0){  // compare two value 
				
				end = middle - 1 ; // if desired value is smaller take end cursor to the mid position
		
			}
			
			else if (searchName.compareToIgnoreCase(userName.get(middle))>0){
				
				init = middle + 1 ; // if desired value is largr then take initial cursor to the mid point
				
			}
			else 
				return middle ; // when end and initial positions match then we found what we are looking for
				
		}
    		return -1; // if not found return -1 
    		
    }
    
    
    
}
