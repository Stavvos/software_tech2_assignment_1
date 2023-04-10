import java.util.*; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


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
    
    //for Q4 in the case of a positive bill difference
    public void printBillPositiveDifference(Flat flatBlock, ArrayList<Meter> foundMeterObjects, double rates, double totalTennantbills,
    double differenceOfTotals, double adjustedTotalTennantBills, int lengthOfFoundMeters)
    {
        int usageInt = (int) flatBlock.getUsage(); 
        
        System.out.printf("\n\nShowing Bill for %d %s \n\n", flatBlock.getBuildingNumber(), flatBlock.getStreet()); 
        System.out.println("----------------------------------------------");
        System.out.printf("Current meter reading %d %s \n", flatBlock.getCurrentReading(), flatBlock.getCurrentReadingDate());
        System.out.printf("Previous meter reading %d %s \n", flatBlock.getPreviousReading(), flatBlock.getPreviousReadingDate());
        System.out.println("Usage: " + usageInt); 
        System.out.println("Rate: " + rates + "/kwh");
        System.out.printf("Bill Usage: $%.2f \n\n\n", flatBlock.getBill()); 
        
        String title1 = "Tenant";
        String title2 = "meter";
        String title3 = "curr";
        String title4 = "prev";
        String title5 = "usage";
        String title6 = "pcnt%";
        String title7 = "$base";
        String title8 = "$adj";
        String title9 = "$total";
        
        System.out.printf("%-30s %-8s %-7s %-9s %-9s %-9s %-11s %-10s %-6s \n", title1, title2, title3, title4, title5, 
        title6, title7, title8, title9);
        
        String line = "-".repeat(108); 
        System.out.println(line);
        String percentageSymbol = "%";
        String dollarSymbol = "$"; 
        
        for (int i = 0; i < lengthOfFoundMeters; i++)
        {
          Meter meter = foundMeterObjects.get(i);
          int usageMeterInt = (int) meter.getUsage(); 
          System.out.printf("%-4s %-12s %-12s %-8s %-7d %-9d %-9d %-5.2f%-4s %-6.2f%-5s %-4.2f%-6s %-6.2f$ \n", 
          meter.getHonorificName(),meter.getFirstName(),meter.getLastName(),
          meter.getTenantMeterNumber(), meter.getCurrentReading(), meter.getPreviousReading(), usageMeterInt, meter.getPercentage(),percentageSymbol,
          meter.getBill(), dollarSymbol, meter.getAdjustedBillAmount(), dollarSymbol, meter.getTotalBillAmount());
        }
        
        System.out.printf("\nTotal tennant bills (metered): %.2f \n" , totalTennantbills);
        System.out.printf("Total tennant bills diff: %.2f \n" , differenceOfTotals);
        System.out.printf("Total tennant bills adjusted: %.2f \n" , adjustedTotalTennantBills);
    }
    
    //Q4 for the case of a negetive differrence 
    public void printBillNegativeDifference(Flat flatBlock, ArrayList<Meter> foundMeterObjects, double rates, double totalTennantbills,
    double differenceOfTotals, double adjustedTotalTennantBills, int lengthOfFoundMeters)
    {
      
        /*System.out.println(); 
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
        } */
        
        int usageInt = (int) flatBlock.getUsage();
        
        System.out.printf("\n\nShowing Bill for %d %s \n\n", flatBlock.getBuildingNumber(), flatBlock.getStreet()); 
        System.out.println("----------------------------------------------");
        System.out.printf("Current meter reading %d %s \n", flatBlock.getCurrentReading(), flatBlock.getCurrentReadingDate());
        System.out.printf("Previous meter reading %d %s \n", flatBlock.getPreviousReading(), flatBlock.getPreviousReadingDate());
        System.out.println("Usage: " + usageInt); 
        System.out.println("Rate: " + rates + "/kwh");
        System.out.printf("Bill Usage: $%.2f \n\n\n", flatBlock.getBill()); 
        
        String title1 = "Tenant";
        String title2 = "meter";
        String title3 = "curr";
        String title4 = "prev";
        String title5 = "usage";
        String title6 = "pcnt%";
        String title7 = "$base";
        String title8 = "$adj";
        String title9 = "$total";
        
        System.out.printf("%-30s %-8s %-7s %-9s %-9s %-9s %-11s %-10s %-6s \n", title1, title2, title3, title4, title5, 
        title6, title7, title8, title9);
        
        String line = "-".repeat(108); 
        System.out.println(line);
        String percentageSymbol = "%";
        String dollarSymbol = "$"; 
        
        for (int i = 0; i < lengthOfFoundMeters; i++)
        {
          Meter meter = foundMeterObjects.get(i);
          int usageMeterInt = (int) meter.getUsage(); 
          System.out.printf("%-4s %-12s %-12s %-8s %-7d %-9d %-9d %-5.2f%-4s %-6.2f%-5s %-4.2f%-6s %-6.2f$ \n", 
          meter.getHonorificName(),meter.getFirstName(),meter.getLastName(),
          meter.getTenantMeterNumber(), meter.getCurrentReading(), meter.getPreviousReading(), usageMeterInt, meter.getPercentage(),percentageSymbol,
          meter.getBill(), dollarSymbol, meter.getAdjustedBillAmount(), dollarSymbol, meter.getBill());
        }
        
        System.out.printf("\nTotal tennant bills (metered): %.2f \n" , totalTennantbills);
        System.out.printf("Total tennant bills diff: %.2f \n" , differenceOfTotals);
        System.out.printf("Total tennant bills adjusted: %.2f \n" , adjustedTotalTennantBills);
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
           int lastIndex = tenantMeterObjects.size() - 1; 
            
            try {
              // Specify the input date format
              SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
              
              // Parse the input date
              Date inputDate1 = inputFormat.parse(tenantMeterObjects.get(0).getCurrentReadingDate());
              Date inputDate2 = inputFormat.parse(tenantMeterObjects.get(9).getCurrentReadingDate());
              Date inputDate3 = inputFormat.parse(tenantMeterObjects.get(lastIndex).getCurrentReadingDate());
              
              // Specify the output date format
              SimpleDateFormat outputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        
              // Set the timezone to AEST
              outputFormat.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        
              // Format the date to the output format
              String outputDate1 = outputFormat.format(inputDate1);
              String outputDate2 = outputFormat.format(inputDate2);
              String outputDate3 = outputFormat.format(inputDate3);
              
              System.out.println("Check [0] " + tenantMeterObjects.get(0).getFirstName() + " " + tenantMeterObjects.get(0).getLastName() 
              + " " + tenantMeterObjects.get(0).getTenantMeterNumber() + " " + tenantMeterObjects.get(0).getCurrentReading() + " "
              + outputDate1); 
            
              System.out.println("Check [9] " + tenantMeterObjects.get(9).getFirstName() + " " + tenantMeterObjects.get(9).getLastName() 
              + " " + tenantMeterObjects.get(9).getTenantMeterNumber() + " " + tenantMeterObjects.get(9).getCurrentReading() + " "
              + outputDate2);
            
              System.out.println("Check [ ] " + tenantMeterObjects.get(lastIndex).getFirstName() + " " + tenantMeterObjects.get(lastIndex).getLastName() 
              + " " + tenantMeterObjects.get(lastIndex).getTenantMeterNumber() + " " + tenantMeterObjects.get(lastIndex).getCurrentReading() 
              + " " + outputDate3);
              
            } catch (Exception e) {
              e.printStackTrace();
            }
    }
    
    public void printFlatFigures( Counter counter)
    {
      int num =  counter.getCurrentReadingsSum();
      double numDivided = num / 1e7;
      String scientificNotation = String.format("%.7fE7", numDivided); 
      
      
      
      System.out.println("Reading flat file Data/"); // need to insert the file that we're reading in
      System.out.println("Number of flats read in is: " + counter.getNumberOfFlats());
      System.out.println("Number of meters read in is: " + counter.getNumberOfFlatMeters());
      System.out.printf("Total sum (checksum) of all current flats readings is: %s \n", scientificNotation);
      System.out.println("Total sum (checksum) of all current flats readings is: " + counter.getCurrentReadingsSum());
    }
    
    public void printMeterFigures( Counter counter)
    {
      int num =  counter.getCurrentReadingsSum();
      double numDivided = num / 1e7;
      String scientificNotation = String.format("%.7fE7", numDivided); 
      
      
      
      System.out.println("Reading meter file Data/"); // need to insert the file that we're reading in
      System.out.println("Number of meters read in is: " + counter.getNumberOfFlats());
      System.out.printf("Total sum (checksum) of all current flats readings is: %s \n", scientificNotation);
      System.out.println("Total sum (checksum) of all current flats readings is: " + counter.getCurrentReadingsSum());
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
    
    //Q2
    public void singleFlatBill(Flat flat)
    {
        Double previousReading = new Double(flat.getPreviousReading());
        Double currentReading = new Double(flat.getCurrentReading()); 
        
        double rates = 0.205;   
        double difference = currentReading - previousReading; 
        double bill = (difference * rates); 
        
        int displayDifference = (int)difference; //convert the difference to an int for display 
        
        System.out.println("Showing bill for " + flat.getBuildingNumber() + " " + flat.getStreet());
        System.out.println("------------------------------");
        System.out.println("Current  meter reading: " + flat.getCurrentReading() + " " + flat.getCurrentReadingDate()); //want displayed as an int
        System.out.println("Previous meter reading: " + flat.getPreviousReading() + " " + flat.getPreviousReadingDate()); //want displayed as an int
        System.out.println("Usage:                    " + displayDifference); //display as int
        System.out.println("Rate:                               " + rates + "/kwh"); //display as double
        System.out.printf ("BillUsage:                   $    %.2f" , bill); //display as double
        
    }
}
