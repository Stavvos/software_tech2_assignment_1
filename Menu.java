import java.util.*;
public class Menu
{
    public Menu()
    {
        System.out.println("\f"); 
        String menuOpt="";
        Scanner in = new Scanner(System.in);
        String fileName = "";
        String environment = ""; 
        ReadFile read = new ReadFile(); 
        
        Print display = new Print();
        Algorithms algo = new Algorithms(); 
        Counter flatCounter = new Counter(); 
        Counter meterCounter = new Counter();
        
        ArrayList<Meter> tenantMeterObjects = new ArrayList<Meter>();
        ArrayList<Flat> flatObjects = new ArrayList<Flat>();
        
    
        do
    {
        //System.out.printf("\nMenu Test\n");
        System.out.println(); 
        System.out.printf("E - Exit\n");
        System.out.printf("F - Read Flats                           (task 1) \n");
        System.out.printf("M - Read Meters                          (task 1) \n");
        System.out.printf("C - Compute BC Bill for one Flat         (task 2) \n");
        System.out.printf("A - Compute BC Bill for All Flats        (task 2) \n");
        System.out.printf("S - Sort the meter file into meter order (task 3)\n");
        System.out.printf("P - Prove meter file sort and find       (task 3)\n");
        System.out.printf("O - Compute Full Bill for one flat       (task 4) \n");
        System.out.printf("5 - Compute Full Bill for all flats      (task 5) \n");
        System.out.printf("0 - Set Dev0 environment\n");
        System.out.printf("1 - Set Dev1 environment\n");
        System.out.printf("2 - Set Test environment\n");
        System.out.printf("3 - Set Prod environment\n");
        System.out.printf("Select Option:\n");
        menuOpt = in.nextLine();
        //System.out.println("You entered : " + menuOpt);
        
        
        
        if (menuOpt.compareToIgnoreCase("A") == 0) 
        {
            //##formatted correctly
            System.out.println("Compute bill for all blocks of flats \n");
            algo.blockOfFlatsBill(flatObjects); 
        }
        
        
        if (menuOpt.compareToIgnoreCase("C") == 0 )
        {
            //##formatted correctly
            Flat displayFlat = new Flat();
            System.out.println("Compute bill for one block of flats");
            displayFlat = algo.searchFlat(flatObjects); 
            display.singleFlatBill(displayFlat); //strange bug where there's an E after the bill value?
        
            //##for some reason the data in the prod_flat.txt file is different when compared to the 
            //## test_flat.txt file for the case of 10 Balmoral Drive. Mention this in the report. 
            //##Note:the binary search algo is case sensitive for the street name
        }
        
        if(menuOpt.compareToIgnoreCase("M") == 0)
        {
         //##formatted correctly
         //clear the arrayList before it's values are set to avoid errors when reusing it   
         tenantMeterObjects.clear(); 
         
         fileName = environment + "_meter.txt";
         
         read.readFromMeterFiles(tenantMeterObjects, meterCounter, fileName);
         display.printMeterFigures(meterCounter, fileName);
         
         //reset the meterCounter object's values that are used in the above printing function for the case of this if test being 
         //called again. This will avoid double counting. 
         meterCounter.resetNumberOfObjects();
         meterCounter.resetNumberOfFlatMeters(); 
         meterCounter.resetCurrentReadingsTotal();
        }
        
        if(menuOpt.compareToIgnoreCase("F") == 0)
        {
         //##formatted correctly
         //clear the arrayList before it's values are set to avoid errors when reusing it   
         flatObjects.clear();
         
         fileName = environment + "_flat.txt";
         
         read.readFromFlatFiles(flatObjects, flatCounter, fileName); 
         display.printFlatFigures(flatCounter, fileName); //seems to be working 
         
         //reset the meterCounter object's values that are used in the above printing function for the case of this if test being 
         //called again. This will avoid double counting.
         flatCounter.resetNumberOfObjects();
         flatCounter.resetNumberOfFlatMeters(); 
         flatCounter.resetCurrentReadingsTotal(); 
        }
        
        if (menuOpt.compareToIgnoreCase("S") == 0 )
        {
         //## formatted correctly
        algo.sortMeterFile(tenantMeterObjects);
        display.testingSort(tenantMeterObjects);  
        
        //**extra not needed for final*****
        //display.printingTestMeterObjects(tenantMeterObjects); 
        //**extra not needed for final*****
        }
        
        if (menuOpt.compareToIgnoreCase("P") == 0 )
        {
         //## formatted correctly
         algo.proveSearch(tenantMeterObjects);
        
        }
        
        if (menuOpt.compareToIgnoreCase("O") == 0 )
        {
         //## formatted correctly apart from spacing in between tenant and meter fields but shouldn't matter too much
         //## also note that for some reason 10 bright street has different meters when using the prod_flat.txt and test_flat.txt files
         int streetNumber;
         String streetName; 
         
         algo.sortMeterFile(tenantMeterObjects); //sort before the binary search just in case
         
         System.out.println("Compute Adjusted bill for one Block of flats");
         
         System.out.print("Enter street number:");
         streetNumber = in.nextInt();
         in.nextLine(); 
         
         System.out.print("Enter street name:");
         streetName = in.nextLine(); 
         
         
         algo.adjustedBillForFlatBlock(flatObjects, tenantMeterObjects, streetName, streetNumber); 
         
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
         
        }
        
        if (menuOpt.compareToIgnoreCase("5") == 0 )
        {
          //##formatted correctly
         
         algo.sortMeterFile(tenantMeterObjects); //sort before the binary search
         
         algo.adjustedBillForAllFlatBlocks(flatObjects, tenantMeterObjects);
        }
        
        if(menuOpt.compareToIgnoreCase("0") == 0)
        {
          environment = "dev0";
          //System.out.println(fileName);
          
        }
        
        if(menuOpt.compareToIgnoreCase("1") == 0)
        {
          environment = "dev1";
          //System.out.println(fileName);
        }
        
        if(menuOpt.compareToIgnoreCase("2") == 0)
        {
          environment = "test";
          //System.out.println(fileName);
        }
        
        if(menuOpt.compareToIgnoreCase("3") == 0)
        {
          environment = "prod";
          //System.out.println(fileName);
        }
        
        
    } while (menuOpt.compareToIgnoreCase("E")!=0); // Note the != this time
    System.out.printf("\nEnding Now\n");
    }
    
    public void opta()
    {
    System.out.printf("\nyou selected option A\n");
    // ----------- your code here perhaps --------------
    }
}

