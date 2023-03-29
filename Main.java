/**
 * Write a description of class Main here.
 *
 * @author Liam Henry
 * @version 28/03/2023
 */
import java.io.*;
import java.util.*; 
import java.util.ArrayList; 
public class Main
{
    ArrayList<Meter> tenantMeterObjects = new ArrayList<Meter>();
    ArrayList<Flat> flatObjects = new ArrayList<Flat>();
    
    
    String fileName;
    
    Scanner inFile; 
    Scanner in = new Scanner(System.in);
    
    
    
    public Main()
    {
      System.out.println("\f"); 
      
      
      
        // for testing. Seems to be working 
       
        //readFromMeterFiles();
        
        //sortMeterFile(tenantMeterObjects);
        
        //testingSort();  
        
        
        
        
        //printingTestMeterObjects(tenantMeterObjects); 
        
        readFromFlatFiles(); 
        
        testingSearch(); //seems to be working
        
        //printingTestFlatObjects(flatObjects); 
        
        
       
    
    }
    
    //a method for testing the binary search function
    public void testingSearch()
    {
       
         String searchAddress; 
        System.out.println("Enter the street name you're searching for: ");
        searchAddress = in.nextLine(); 
        
        int searchStreetNumber; 
        System.out.println("Enter the street number you're looking for: "); 
        searchStreetNumber = in.nextInt(); 
        
        int resultOfAddressSearch = findAddress(flatObjects, searchAddress, searchStreetNumber); 
        
        if (resultOfAddressSearch == -1)
        {
           System.out.println("Address not found"); 
        }
        else
        {
           System.out.println("The address was found at index " + resultOfAddressSearch); 
        }
    
    }
    
    // a function for testing the selection sort method
    public void testingSort()
    {
        System.out.println("Check [0] " + tenantMeterObjects.get(0).getFirstName() + " " + tenantMeterObjects.get(0).getLastName()); 
        System.out.println("Check [9] " + tenantMeterObjects.get(9).getFirstName() + " " + tenantMeterObjects.get(9).getLastName()); 
        System.out.println("Check last " + tenantMeterObjects.get(15).getFirstName() + " " + tenantMeterObjects.get(15).getLastName());
    }
    
    //function for printing an arraylist of Meter objects
    public void printingTestMeterObjects(ArrayList<Meter> newMeterObjectList)
    {
        
        int lengthOfArray = newMeterObjectList.size();
        Meter printingObject = new Meter(); 
        
        
        for (int i = 0; i < lengthOfArray; i++)
        {
          printingObject = newMeterObjectList.get(i);
          
          System.out.println(printingObject.getHonorificName() + " " + printingObject.getFirstName() + " " +
          printingObject.getLastName() + " " + printingObject.getCorporationName() + " " + printingObject.getTenantMeterNumber() + " " +
          printingObject.getCurrentReading() + " " + printingObject.getCurrentReadingDate() + " " + 
          printingObject.getPreviousReading() + " " + printingObject.getPreviousReadingDate() + " ");
          System.out.println("");
          
        }
       
    }
    
    //function for printing an arraylist of Flat objects
    public void printingTestFlatObjects(ArrayList <Flat> newFlatObjectList)
    {
        //Flats file format: 
        //street, building number, building meter, current reading, current reading date,previous reading, previous reading date,
        //tenant meter1, tenant meter 2, tenant meter..repeat etc. 
         int lengthOfArray = newFlatObjectList.size();
         Flat newFlatObject = new Flat();
        
         for(int i = 0; i < lengthOfArray; i++)
        {
            newFlatObject = newFlatObjectList.get(i); 
            
            System.out.println("------testing Flat object getters and setters ------");
            System.out.println(newFlatObject.getStreet() + " " + newFlatObject.getBuildingNumber() + " " + newFlatObject.getBuildingMeter() 
            + " " + newFlatObject.getCurrentReading() + " " + newFlatObject.getCurrentReadingDate() + " " + 
            newFlatObject.getPreviousReading() + " " + newFlatObject.getPreviousReadingDate());
        
            for (int j = 0; j < newFlatObject.getTenantMetersList().size(); j++)
            {
                System.out.println(newFlatObject.getTenantMetersList().get(j));
            }
         
    
        }
         
         
         System.out.println(""); 
    
    }
    
    //function for reading the flat CSV files
    public void readFromFlatFiles()
    {
        
        //values for tokenized array
        String street;   
        String buildingMeter; 
        String currentReadingDate;  
        String previousReadingDate;
        ArrayList<String> flatsList = new ArrayList<String>(); 
    
        int buildingNumber;
        int currentReading; 
        int previousReading; 
        
        System.out.println("Enter the file name you'd like the program to read: "); 
        
        fileName = in.nextLine(); 
        
        try{
        
           inFile = new Scanner (new FileReader (fileName)); 
           
           while (inFile.hasNextLine())
           {
                //get the current line from the Dev_meterFile.txt
                String currentLine = inFile.nextLine();
              
                //create an array to help with tokenizing and use "," because we're working with a CSV file
                String tokenizedArray[] = currentLine.split(",");
              
                //get the size of the array for use in the for loop below
                int tokenizedArraySize = tokenizedArray.length;                 
                
                ArrayList<String> tenantMeters = new ArrayList<String>();
              
              //intialse these values using the tokenizedArray
              street = tokenizedArray[0]; 
              
              buildingNumber = Integer.parseInt(tokenizedArray[1]); 
              
              buildingMeter = tokenizedArray[2];
              
              currentReading = Integer.parseInt(tokenizedArray[3]); 
              
              currentReadingDate = tokenizedArray[4]; 
              
              previousReading = Integer.parseInt(tokenizedArray[5]);
              
              previousReadingDate = tokenizedArray[6];
              
               //add the tenant meters from the .txt file 
               //the amount of tenant meters for each flat differ but there's always one of every other value
               //so we start at the 8th value of the tokenizedArray and feed in our tenant meters until the tokenizedArray 
               //is at its end
                for (int i = 7; i < tokenizedArraySize; i++)
               {
                tenantMeters.add(tokenizedArray[i]);  
               }
              
               //create a meter object
               Flat flatObject = new Flat(); 
               
               //set the meter object's values using the variables from above
               flatObject.setStreet(street);
               flatObject.setBuildingNumber(buildingNumber);
               flatObject.setBuildingMeter(buildingMeter);
               flatObject.setCurrentReading(currentReading);
               flatObject.setCurrentReadingDate(currentReadingDate);
               flatObject.setPreviousReading(previousReading);
               flatObject.setPreviousReadingDate(previousReadingDate);
               flatObject.setTenantMetersList(tenantMeters);  
               
               //add the meter object to the arrayList
               flatObjects.add(flatObject); 
                
           }
        
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file you've entered couldn't be found"); 
        }
        //close the .txt file
        inFile.close(); 
    }
    
    
    //function for reading the CSV Meter files
    public void readFromMeterFiles()
    {
        
        //values for tokenized array
        String honorificName; 
        String firstName; 
        String lastName; 
        String corporationName; 
        String tenantMeterNumber; 
        String currentReadingDate; 
        String previousReadingDate; 
        
        int currentReading;
        int previousReading;
        
        
        System.out.println("Enter the file name you'd like the program to read: "); 
        
        fileName = in.nextLine(); 
        
        try{
        
           inFile = new Scanner (new FileReader (fileName)); 
           
           while (inFile.hasNextLine())
           {
              //get the current line from the Dev_meterFile.txt
              String currentLine = inFile.nextLine();
              
              //create an array to help with tokenizing and use "," because we're working with a CSV file
              String tokenizedArray[] = currentLine.split(",");
              
              //intialse these values using the tokenizedArray
              honorificName = tokenizedArray[0]; 
              
              firstName = tokenizedArray[1]; 
              
              lastName = tokenizedArray[2];
              
              corporationName = tokenizedArray[3]; 
              
              tenantMeterNumber = tokenizedArray[4]; 
              
              currentReading = Integer.parseInt(tokenizedArray[5]);
              
              currentReadingDate = tokenizedArray[6];
              
              previousReading = Integer.parseInt(tokenizedArray[7]);
              
              previousReadingDate = tokenizedArray[8];
              
               //create a meter object
               Meter meterObject = new Meter(); 
               
               //set the meter object's values using the variables from above
               meterObject.setHonorificName(honorificName);
               meterObject.setFirstName(firstName); 
               meterObject.setLastName(lastName);
               meterObject.setCorporationName(corporationName);
               meterObject.setTenantMeterNumber(tenantMeterNumber);
               meterObject.setCurrentReadingDate(currentReadingDate);
               meterObject.setPreviousReadingDate(previousReadingDate); 
               meterObject.setCurrentReading(currentReading);
               meterObject.setPreviousReading(previousReading); 
               
               //add the meter object to the arrayList
               tenantMeterObjects.add(meterObject); 
               
               
                 
           }
        
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file you've entered couldn't be found"); 
        }
        //close the .txt file
        inFile.close(); 
    }
    
    //selection sort which is O(n^2) 
    public void sortMeterFile(ArrayList<Meter> meterObjects)
    {
      int sizeOfArrayList = meterObjects.size(); 
      
      //nested for loops both of the same size is O(n^2)
      for (int step = 0; step < sizeOfArrayList - 1; step++)
      {
         int minimumIndex = step; 
         
         for (int i = step + 1; i < sizeOfArrayList; i++)
         {
            //get the minimum tenantMeter value of the array list for each loop
            if (meterObjects.get(i).getTenantMeterNumberInt() < meterObjects.get(minimumIndex).getTenantMeterNumberInt())
            {
              minimumIndex = i;
            }
         }
         
         //swap the Meter objects 
         Meter temp = meterObjects.get(step);
         meterObjects.set(step, meterObjects.get(minimumIndex)); //need to use set because we're working with array lists
         meterObjects.set(minimumIndex, temp); 
         
      }
    
    }
    
    //a function that finds the array list indext of an adress
    //it accepts the name of the street, along with the building number as search terms
    //the algorithm used is binary search which is O(log n) 
    public int findAddress(ArrayList<Flat> flatObjects, String searchTermStreet, int searchTermBuildingNumber )
    {
        
            int left = 0, right = flatObjects.size() - 1; 
            
            while (left <= right)
            {
               int middle = left + (right - left) / 2;
               
               int result = searchTermStreet.compareTo(flatObjects.get(middle).getStreet()); //use compareTo() for comparing string
               
               if (result == 0  && flatObjects.get(middle).getBuildingNumber() == searchTermBuildingNumber)
               {
                  return middle;  
               }
               
               if (result > 0 || (result == 0 && flatObjects.get(middle).getBuildingNumber() < searchTermBuildingNumber))
               {
                  left = middle + 1;  
               }
               
               else
               {
                  right = middle - 1;  
               }
            }
            return -1; //use this value if the searchTerm isn't found. 
    }
}
