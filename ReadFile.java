import java.io.*;
import java.util.*; 
import java.util.ArrayList; 

public class ReadFile
{
    
    String fileName;
    
    Scanner inFile; 
    Scanner in = new Scanner(System.in);
    
     
    
    public ReadFile()
    {
    //used to calculate te number of flats, meters, and the sum of all current readings. 
    
    }
     
    //function for reading the flat CSV files
    public void readFromFlatFiles(ArrayList<Flat> flatObjects, Counter flatCounter, String fileName)
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
        
        //System.out.println("Enter the file name you'd like the program to read: "); 
        
        //fileName = in.nextLine(); 
        
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
              
              flatCounter.currentReadingsTotal(currentReading); //calculate the sum of all the current readings 
            
               
               
              
               //add the tenant meters from the .txt file 
               //the amount of tenant meters for each flat differ but there's always one of every other value
               //so we start at the 8th value of the tokenizedArray and feed in our tenant meters until the tokenizedArray 
               //is at its end
                for (int i = 7; i < tokenizedArraySize; i++)
               {
                tenantMeters.add(tokenizedArray[i]);  
                flatCounter.incrementNumberOfFlatMeters();//increment each time after a flat's meter is added to the tenantMeters Array list
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
               
               flatCounter.incrementNumberOfObjects(); //increment after each time a flatObject has been added to the array list
                
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
    public void readFromMeterFiles(ArrayList<Meter> tenantMeterObjects, Counter meterCounter, String fileName)
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
        
        
        //System.out.println("Enter the file name you'd like the program to read: "); 
        
        //fileName = in.nextLine(); 
        
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
              
              meterCounter.currentReadingsTotal(currentReading); //calculate the sum of all the current readings 
              
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
               
               
               meterCounter.incrementNumberOfObjects(); //increment after each time a flatObject has been added to the array list
           }
        
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file you've entered couldn't be found"); 
        }
        //close the .txt file
        inFile.close(); 
    }
}
