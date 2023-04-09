import java.util.*; 


public class Print
{
    
     
    Scanner in = new Scanner(System.in);
    
    public Print()
    {
      
    }
    
    //Q5 printing function for footer
    public void printFooter(double BcBill, double difference, double DiffAdj, double tenantBill)
    {
     String line = "-".repeat(88); 
     System.out.printf("%-88s \n", line);
     String space = " "; 
     //System.out.printf("%-31s %-12.2f %-13.2f %-10.2f %-9.2f \n", space, BcBill, "$" ,  difference, "$",DiffAdj, "$", tenantBill, "$");
     
     System.out.printf("%-31s $%-12.2f $%-13.2f $%-10.2f $%-9.2f \n", space, BcBill, difference,DiffAdj,tenantBill);
    

    }
    
    //Q5 print heading function
    public void printHeading()
    {
     String flat = "Flat";
     String address = "Address"; 
     String BcBill = "BC Bill";
     String difference = "Difference"; 
     String differenceAdjusted = "DiffAdj"; 
     String tenantBill = "Tenant Bill"; 
     String line = "-".repeat(88); 
     
     System.out.printf("%-5s %-27s %-12s %-13s %-10s %-9s  \n", flat, address, BcBill, difference, differenceAdjusted, tenantBill);
     System.out.printf("%-88s \n", line); 
     
    }
    
    //Q5 printing function for flat block values
    public void printAdjustedTotalsForAllFlats(Flat flatBlock,  double adjustedTotalTennantBills, 
    double differenceOfTotalsAdjusted, double differenceOfTotals)
    {
        System.out.printf("%-5d %-27s $%-12.2f $%-13.2f $%-10.2f $%-9.2f \n", flatBlock.getBuildingNumber(), 
        flatBlock.getStreet(), flatBlock.getBill(), differenceOfTotals, differenceOfTotalsAdjusted, adjustedTotalTennantBills); 
       
    }
    
    //Method for finding and returning a flat object 
    //note: probably should be in algorithms class and not this one
    public Flat searchFlat(ArrayList<Flat> flatObjects)
    {
        //flat object to be initialised and returned if the binary search finds the flat the user is looking for
        Flat foundFlat = new Flat(); 
        
        String searchAddress; 
        System.out.println("Enter the street name you're searching for: ");
        searchAddress = in.nextLine(); 
        
        int searchStreetNumber; 
        System.out.println("Enter the street number you're looking for: "); 
        searchStreetNumber = in.nextInt(); 
        
        //create an Algorithms object to access the findAddress() method. 
        Algorithms search = new Algorithms(); 
        
        int resultOfAddressSearch = search.findAddress(flatObjects, searchAddress, searchStreetNumber); 
        
        if (resultOfAddressSearch == -1)
        {
           System.out.println("Address not found"); 
           return null; 
        }
        else
        {
           //System.out.println("The address was found at index " + resultOfAddressSearch); 
           foundFlat = flatObjects.get(resultOfAddressSearch);
           return foundFlat; 
        }
    
    }
    
    //for Q4 in the case of a positive bill difference
    public void printBillPositiveDifference(Flat flatBlock, ArrayList<Meter> foundMeterObjects, double rates, double totalTennantbills,
    double differenceOfTotals, double adjustedTotalTennantBills, int lengthOfFoundMeters)
    {
        
        System.out.printf("Showing Bill for %d %s \n\n", flatBlock.getBuildingNumber(), flatBlock.getStreet()); 
        System.out.println("----------------------------------------------");
        System.out.printf("Current meter reading %d %s \n", flatBlock.getCurrentReading(), flatBlock.getCurrentReadingDate());
        System.out.printf("Previous meter reading %d %s \n", flatBlock.getPreviousReading(), flatBlock.getPreviousReadingDate());
        System.out.println("Usage: " + flatBlock.getUsage()); 
        System.out.println("Rate: " + rates + "/kwh");
        System.out.println("Bill Usage: " + "$" + flatBlock.getBill() + "\n\n"); 
        
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < lengthOfFoundMeters; i++)
        {
          Meter meter = foundMeterObjects.get(i);
          System.out.printf("%s %s %s %s %d %d %.2f %.2f %.2f %.2f %.2f \n", meter.getHonorificName(),meter.getFirstName(),meter.getLastName(),
          meter.getTenantMeterNumber(), meter.getCurrentReading(), meter.getPreviousReading(), meter.getUsage(), meter.getPercentage(),
          meter.getBill(), meter.getAdjustedBillAmount(), meter.getTotalBillAmount() );
          
          /*System.out.println(meter.getHonorificName()+ " " + meter.getFirstName() + " " + meter.getLastName() + " " + 
          meter.getTenantMeterNumber() + " "
          + meter.getCurrentReading() + " " + meter.getPreviousReading() + " " 
          + meter.getUsage() + " " + meter.getPercentage() + " " + meter.getBill() + " " + meter.getAdjustedBillAmount() + 
          " " +  meter.getTotalBillAmount()); */
        }
        
        System.out.println("\nTotal tennant bills (metered): " + totalTennantbills);
        System.out.println("Total tennant bills diff: " + differenceOfTotals);
        System.out.println("Total tennant bills adjusted: " + adjustedTotalTennantBills);
    
    }
    
    //Q4 for the case of a negetive differrence 
    public void printBillNegativeDifference(Flat flatBlock, ArrayList<Meter> foundMeterObjects, double rates, double totalTennantbills,
    double differenceOfTotals, double adjustedTotalTennantBills, int lengthOfFoundMeters)
    {
      
        System.out.println(); 
        System.out.println("Usage: " + flatBlock.getUsage()); 
        System.out.println("Rate: " + rates);
        System.out.println("Bill Usage: " + flatBlock.getBill() + "\n\n"); 
        
        System.out.println("Total tennant bills (metered): " + totalTennantbills);
        System.out.println("Total tennant bills diff: " + differenceOfTotals);
        System.out.println("Total tennant bills adjusted: " + adjustedTotalTennantBills);
        
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < lengthOfFoundMeters; i++)
        {
          Meter meter = foundMeterObjects.get(i);
          System.out.println(meter.getTenantMeterNumber() + " " + meter.getUsage() + " " + meter.getPercentage() + " " + meter.getBill() 
          + " " + meter.getAdjustedBillAmount() + " " + meter.getBill());
        }
    
    }
    
    //a method for testing the binary search function
    public void testingSearch(ArrayList<Flat> flatObjects)
    {
       
        String searchAddress; 
        System.out.println("Enter the street name you're searching for: ");
        searchAddress = in.nextLine(); 
        
        int searchStreetNumber; 
        System.out.println("Enter the street number you're looking for: "); 
        searchStreetNumber = in.nextInt(); 
        
        //create an Algorithms object to access the findAddress() method. 
        Algorithms search = new Algorithms(); 
        
        int resultOfAddressSearch = search.findAddress(flatObjects, searchAddress, searchStreetNumber); 
        
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
    public void testingSort(ArrayList<Meter> tenantMeterObjects)
    {
        System.out.println("Check [0] " + tenantMeterObjects.get(0).getFirstName() + " " + tenantMeterObjects.get(0).getLastName()); 
        System.out.println("Check [9] " + tenantMeterObjects.get(9).getFirstName() + " " + tenantMeterObjects.get(9).getLastName()); 
        System.out.println("Check last " + tenantMeterObjects.get(15).getFirstName() + " " + tenantMeterObjects.get(15).getLastName());
    }
    
    public void testingFlatFigures( Counter counter)
    {
      System.out.println("The Number of flats read in are: " + counter.getNumberOfFlats());
      System.out.println("The Number of meters read in are: " + counter.getNumberOfFlatMeters());
      System.out.println("The sum of all current flats readings is: " + counter.getCurrentReadingsSum());
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
}
