/**
 * Write a description of class Main here.
 *
 * @author Liam Henry
 * @version 28/03/2023
 */

import java.util.ArrayList; 
public class Main
{
    ArrayList<Meter> tenantMeterObjects = new ArrayList<Meter>();
    ArrayList<Flat> flatObjects = new ArrayList<Flat>();
    
    public Main()
    {
      System.out.println("\f"); 
       
        // declaring objects so that their methods cn be accessed
        ReadFile read = new ReadFile(); 
        
        Print display = new Print();
        
        Algorithms algo = new Algorithms(); 
        
        
        
        // ****for testing sort functionality, seems to be working **** 
       
        //read.readFromMeterFiles(tenantMeterObjects);
        
        //algo.sortMeterFile(tenantMeterObjects);
        
        //display.testingSort(tenantMeterObjects);  
        
        //display.printingTestMeterObjects(tenantMeterObjects); 
        
        
        //feed these objects into the read.readFromFlatFiles(flatObjects, flatCounter) and display.testingFlatFigures(flatCounter);
        //methods because it will be passed by reference and the variables that are modified will remain modified. 
        Counter flatCounter = new Counter(); 
        Counter meterCounter = new Counter(); 
        
        //**** for testing search functionality, seems to be working *****
        read.readFromFlatFiles(flatObjects, flatCounter); 
        
        display.testingFlatFigures(flatCounter); //seems to be working
        
        read.readFromMeterFiles(tenantMeterObjects, meterCounter); 
        
        display.testingFlatFigures(meterCounter); //seems to be working although the formatting is incorrect
        
       //display.testingSearch(flatObjects); //seems to be working
        
       //display.printingTestFlatObjects(flatObjects); 
        
        
       
    
    }
    
}
