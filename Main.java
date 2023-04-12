/**
 * Write a description of class Main here.
 *
 * @author Liam Henry
 * @version 28/03/2023
 */

import java.util.ArrayList;
import java.util.*; 
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
        
        //***********Q1 testing*****************************
        //***feed these objects into the read.readFromFlatFiles(flatObjects, flatCounter) and display.testingFlatFigures(flatCounter);
        //***methods because it will be passed by reference and the variables that are modified will remain modified. 
        Counter flatCounter = new Counter(); 
        Counter meterCounter = new Counter(); 
        
        //Q1a**************************
        //#######note that these printing functions should be able to dispay which file has been read in
        //## other thn that working well
        //read.readFromFlatFiles(flatObjects, flatCounter); 
        
        //display.printFlatFigures(flatCounter); //seems to be working
        
        //read.readFromMeterFiles(tenantMeterObjects, meterCounter); 
        //Q1a**************************
        
        //Q1b***********************************************
        //read.readFromMeterFiles(tenantMeterObjects, meterCounter);
        //display.printMeterFigures(meterCounter);
        //Q1b***********************************************
        
       //display.printingTestFlatObjects(flatObjects);
       //***********Q1 testing**************************
        
         //****task 2a calculate bill for one flat*****
       //##working well
       //read.readFromFlatFiles(flatObjects, flatCounter);
       //Flat displayFlat = new Flat(); 
       //displayFlat = algo.searchFlat(flatObjects); 
       //display.singleFlatBill(displayFlat); 
       //##for some reason the data in the prod_flat.txt file is different when compared to the 
       //## test_flat.txt file for the case of 10 Balmoral Drive. Mention this in the report. 
       //##Note:the binary search algo is case sensitive for the street name
       //********************************************
       
       //****task 2b calculate bill for all the flats****
        //read.readFromFlatFiles(flatObjects, flatCounter);
        //algo.blockOfFlatsBill(flatObjects); 
        //##working well
       //********************************************
        
        // ****Q3a********************************** 
        
        //##works well
        //read.readFromMeterFiles(tenantMeterObjects, meterCounter);
        
        //algo.sortMeterFile(tenantMeterObjects);
        
        //display.testingSort(tenantMeterObjects);  
        
        //**extra not needed for final*****
        //display.printingTestMeterObjects(tenantMeterObjects); 
        //**extra not needed for final*****
        // ****Q3a********************************** 
        
        //## Q3 seems to be working but sometimes the binary search is slower
        /* 
        //*******Q3b prove how fast the sort and search is for 10000 records ************************ 
        
         long start;
         long end;
         long diff;
         
         read.readFromMeterFiles(tenantMeterObjects, meterCounter); //run read if it hasn't been already
         
         algo.sortMeterFile(tenantMeterObjects); //run sort if it hasn't been already
         
         System.out.println("\n\n");
         
         display.testingSort(tenantMeterObjects);
         
         System.out.println("\n\n\n\n\n\n\n\n"); 
         
         //test how long it will tae the sequencialSerch() method from the algorithms class
         start = System.currentTimeMillis();
         for (int i = 0; i <30000; i++)
         {
           int test1 = Algorithms.sequencialSearch(tenantMeterObjects ,"m163987");
           int test2 = Algorithms.sequencialSearch(tenantMeterObjects ,"m163966");
           int test3 = Algorithms.sequencialSearch(tenantMeterObjects ,"m163973");
         }
         end = System.currentTimeMillis(); 
         diff = end - start; 
         System.out.println("Find sequential: " + diff + " milliseconds");
         
         //test how long it will tae the findMeterNumberBinary() method from the algorithms class
         start = System.currentTimeMillis();
         for (int i = 0; i < 30000; i++)
         {
           int test1 = Algorithms.findMeterNumberBinary(tenantMeterObjects ,"m163987");
           int test2 = Algorithms.findMeterNumberBinary(tenantMeterObjects ,"m163966");
           int test3 = Algorithms.findMeterNumberBinary(tenantMeterObjects ,"m163973");  
         }
         end = System.currentTimeMillis(); 
         diff = end - start; 
         System.out.println("Find Binary: " + diff + " milliseconds"); 
        //Q3b******************************************************
        */
        
       
       //*************Q4compute the bill for one requested flat, showing all tenants in the flat and their adjusted bills this
       //*************is based on both files the Flat file and the meter file
        
         //read.readFromFlatFiles(flatObjects, flatCounter); 
       
         //read.readFromMeterFiles(tenantMeterObjects, meterCounter);
         
         //algo.sortMeterFile(tenantMeterObjects); //sort before the binary search
         
         //int found = algo.findAddress(flatObjects, "The Causeway", 12);
         
         //System.out.println(found); 
         
       
         //algo.adjustedBillForFlatBlock(flatObjects, tenantMeterObjects, "Beaconsfield Road", 9); 
         
         //algo.adjustedBillForFlatBlock(flatObjects, tenantMeterObjects, "Bright Street", 10);
         
         //************************************************************************
         //#note: this test was tricky because there was an error within the prod_flat.txt file
         //#the street name and building numbers both need to be in order, however the building numbers were not in order for this case
         //#of "The Causeway" 
         //#solution: decided to just reconfigure the prod_flat.txt file rather than change the binarySearch algo to save time. 
         //#could've used sequential search to avoid this error as well. 
         //#definitely metion this in the report.
         //************************************************************************
         //algo.adjustedBillForFlatBlock(flatObjects, tenantMeterObjects, "The Causeway", 12); 
        //*************Q4 seems to be working well and looks like the pictures 
        //# but need to make the perentages equal to rob's example if possible
        
          
         //***************Q5 compute bills for all of the flats total and all the adjusted tenant's total
        
         //read.readFromFlatFiles(flatObjects, flatCounter); 
       
         //read.readFromMeterFiles(tenantMeterObjects, meterCounter);
         
         //algo.sortMeterFile(tenantMeterObjects); //sort before the binary search
         
         //algo.adjustedBillForAllFlatBlocks(flatObjects, tenantMeterObjects);
         
         //********************************* working well just need to place the $ symbol behind the dollar amounts not infront
         
        
         Menu menu = new Menu();
         
         //menu.Menu(); 
    
    }
    
 }
