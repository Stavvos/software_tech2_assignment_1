import java.util.ArrayList; 
import java.util.*; 

public class Algorithms
{
    public Algorithms()
    {
        
    }
    
    //Q5 method that calculates the Adjusted bill for all the flat blocks from the flat.txt file
    public void adjustedBillForAllFlatBlocks(ArrayList<Flat> flatObjects, ArrayList<Meter> meterObjects)
    {
        
        
        int numberOfFlats = flatObjects.size(); 
        double bcBillTotal = 0.0;
        double differenceTotal = 0.0; 
        double differencAdjustedTotal = 0.0; 
        double tenantBillTotal = 0.0; 
        Print print = new Print(); 
        //calculate each of the flat block's bill
        for (int flatBlockIndex = 0; flatBlockIndex < numberOfFlats; flatBlockIndex++)
        {
            double meterUsageSum = 0.0; 
            double rates = 0.205;
            double difference; 
            double currentReading;
            double previousReading;
            double bill; 
        
            Flat flatBlock = flatObjects.get(flatBlockIndex); // create a flat object and assign its value to the found flat object above
        
            singleFlatBillAssignValue(flatBlock); // calculate the flat object's bill and usage
          
            ArrayList<Meter> foundMeterObjects = new ArrayList<Meter>(); //create a new array list of type meter to store the meter objects
          
            ArrayList<String> tenantMetersList = flatBlock.getTenantMetersList(); //get meters array list from flat object
          
            int sizeOftenantsList = tenantMetersList.size(); //get the size of the meters array list 
              
            //use the street address and number to find the desired flat object from the flat file to then find the 
            //desired meterObjects from the meter file and store the meter objects into an arraylist
            for (int i = 0; i < sizeOftenantsList; i++ )
            {
                String searchTerm = tenantMetersList.get(i); 
            
                int index = findMeterNumberBinary(meterObjects,searchTerm); 
            
                Meter meter = meterObjects.get(index); 
            
                foundMeterObjects.add(meter); 
            }
            
             
        
            int lengthOfFoundMeters = foundMeterObjects.size(); 
        
                for (int meterIndex = 0; meterIndex < lengthOfFoundMeters; meterIndex++)
               {
                   currentReading = foundMeterObjects.get(meterIndex).getCurrentReading(); 
                   previousReading = foundMeterObjects.get(meterIndex).getPreviousReading(); 
                   
                   difference = currentReading - previousReading; 
                
                   bill = difference * rates; 
                   
                   foundMeterObjects.get(meterIndex).setUsage(difference); 
                   foundMeterObjects.get(meterIndex).setBill(bill);
                   
                   meterUsageSum += difference; //tally up all the meter's usage
                }
            
               double differenceOfTotalsAdjusted = flatBlock.getBill()  - (meterUsageSum * rates); //difference in dollar amount
               double differenceOfTotals = flatBlock.getBill()  - (meterUsageSum * rates); //difference adjusted in dollar amount
               double totalTennantbills = meterUsageSum * rates; //tenant bill
               double adjustedTotalTennantBills; 
               
            
                    //if we're currently on the first index of the main for loop / processing the first flat block print the report's
                    //title
                    if (flatBlockIndex < 1)
                    {
                      System.out.println("\n\nList Adjusted bill for all Blocks of flats \n");
                      print.printHeading(); 
                    }
               
        
                    //distribute the difference of totals amoungst the meters as per their percentage if the difference of totals is negative
                    if(differenceOfTotalsAdjusted > 0)
                    {
                      adjustedTotalTennantBills = totalTennantbills + differenceOfTotalsAdjusted;
                      
                      print.printAdjustedTotalsForAllFlats(flatBlock,adjustedTotalTennantBills, 
                      differenceOfTotalsAdjusted, differenceOfTotals);
                      
                      tenantBillTotal += adjustedTotalTennantBills; //tenant bill total for printing
                      
                      differencAdjustedTotal += differenceOfTotalsAdjusted; //diffAdj total for printing
                      
                      bcBillTotal += flatBlock.getBill(); //BC Bill for printing
                      
                      differenceTotal += differenceOfTotals; // difference total for printing
                    }
                    else
                    {
                      differenceOfTotals = 0; 
                      
                      adjustedTotalTennantBills = totalTennantbills;
                      
                      print.printAdjustedTotalsForAllFlats(flatBlock,adjustedTotalTennantBills, 
                      differenceOfTotalsAdjusted, differenceOfTotals);
                      
                      tenantBillTotal += adjustedTotalTennantBills; //tenant bill total for printing
                      
                      differencAdjustedTotal += differenceOfTotalsAdjusted; //diffAdj total for printing
                      
                      bcBillTotal += flatBlock.getBill(); //BC Bill for printing
                      
                      differenceTotal += differenceOfTotals; // difference total for printing
                    } 
                    
                    
                    
                     
                    
                    //when we're at the fial iteration of the for loop print the totals
                    if(flatBlockIndex == numberOfFlats - 1)
                    {
                    print.printFooter(bcBillTotal, differenceTotal, differencAdjustedTotal,  tenantBillTotal); 
                    }
        }   
    }
    
    //Q4 calculate bill for an entire flat block, calculate each tennant's bill, find sm of each tenant's bill, 
    //find difference of entire flat block bill and the sum, distirubute the difference to each tennant according to their
    //percentage of usage related to the flat block's usage
    public void adjustedBillForFlatBlock(ArrayList<Flat> flatObjects, ArrayList<Meter> meterObjects, String streetName, int streetNumber)
    {
        int objectIndex = findAddress(flatObjects, streetName, streetNumber); //find the flat object
        
        Flat flatBlock = flatObjects.get(objectIndex); // create a flat object and assign its value to the found flat object above
        
        singleFlatBillAssignValue(flatBlock); // calculate the flat object's bill and usage
        
        ArrayList<String> tenantMetersList = flatBlock.getTenantMetersList(); //get meters array list from flat object
        
        int length = tenantMetersList.size(); // get the length of the tenant meters array list
        
        ArrayList<Meter> foundMeterObjects = new ArrayList<Meter>(); //create a new array list of type meter to store our meter objects 
        
        //use the street address and number to find the desired flat object from the flat file to then find the 
        //desired meterObjects from the meter file and store the meter objects into an arraylist
        for (int i = 0; i < length; i++)
        {
            String searchTerm = tenantMetersList.get(i); 
            
            int index = findMeterNumberBinary(meterObjects,searchTerm); 
            
            Meter meter = meterObjects.get(index); 
            
            foundMeterObjects.add(meter); 
            
        }
        
        double meterUsageSum = 0.00; 
        double rates = 0.205;
        double difference; 
        double percentage;
        double currentReading;
        double previousReading;
        double bill; 
        
        int lengthOfFoundMeters = foundMeterObjects.size(); 
        
        for (int i = 0; i < lengthOfFoundMeters; i++)
        {
           currentReading = foundMeterObjects.get(i).getCurrentReading(); 
           previousReading = foundMeterObjects.get(i).getPreviousReading(); 
           
           difference = currentReading - previousReading;
           
           percentage = (difference/flatBlock.getUsage()) * 100; 
           
           bill = difference * rates; 
           
           foundMeterObjects.get(i).setPercentage(percentage);
           foundMeterObjects.get(i).setUsage(difference); 
           foundMeterObjects.get(i).setBill(bill);
           
           meterUsageSum += difference; //tally up all the meter's usage
        }
        
        double differenceOfTotals = flatBlock.getBill()  - (meterUsageSum * rates); 
        double totalTennantbills = meterUsageSum * rates; 
        double adjustedTotalTennantBills;  
        double adjustedBillAmount; 
        double totalBillAmount; 
        
        Print print = new Print(); 
        
        //distribute the difference of totals amoungst the meters as per their percentage if the difference of totals isnt negative
        if(differenceOfTotals > 0)
        {
          for(int i = 0; i < lengthOfFoundMeters; i++)
          {
              adjustedBillAmount = (foundMeterObjects.get(i).getPercentage() * differenceOfTotals) / 100; 
              foundMeterObjects.get(i).setAdjustedBillAmount(adjustedBillAmount); 
              
              totalBillAmount = foundMeterObjects.get(i).getBill() + adjustedBillAmount; 
              
              foundMeterObjects.get(i).setTotalBillAmount(totalBillAmount);    
          }
          adjustedTotalTennantBills = totalTennantbills + differenceOfTotals;
          
          print.printBillPositiveDifference(flatBlock, foundMeterObjects, rates, totalTennantbills, 
          differenceOfTotals, adjustedTotalTennantBills, lengthOfFoundMeters);
        }
        else
        {
         
          adjustedTotalTennantBills = totalTennantbills;
          
          print.printBillNegativeDifference(flatBlock,foundMeterObjects,rates,totalTennantbills,differenceOfTotals, 
          adjustedTotalTennantBills,lengthOfFoundMeters);
        }
                
    }
    
    //Q4 use this for calculating the flat's bill and meter usage
    //it sets the flat object's bill and usage values at the end of the function 
    public void singleFlatBillAssignValue(Flat flat)
    {
        Double previousReading = new Double(flat.getPreviousReading());
        Double currentReading = new Double(flat.getCurrentReading()); 
        
        double rates = 0.205;   
        double difference = currentReading - previousReading; 
        
        //System.out.println("difference = " + difference + " current reading = " + currentReading + " previous reading = " + previousReading); 
       
        double bill = (difference * rates); 
        
        flat.setBill(bill);
        flat.setUsage(difference);
        
    }
    
    //Q2b
    public void blockOfFlatsBill(ArrayList<Flat> flatObjects)
    {
        int length = flatObjects.size(); 
        Flat flat; 
        
        double rates = 0.205;   
        double difference; 
        double bill ;
        double billTotal = 0.0; 
        Double previousReading; 
        Double currentReading; 
        int flatsCounter = 0; 
        
        //work our way down the flatObjects ArrayList and calculate the total bill 
        for (int i = 0; i < length; i ++)
         {
          flat = flatObjects.get(i); //get flat object from array list
          previousReading = new Double(flat.getPreviousReading()); 
          currentReading = new Double(flat.getCurrentReading()); 
          difference = currentReading - previousReading; 
          bill = (difference * rates); 
          billTotal += bill;
         }
        String userInput;
        String colon = ":"; 
        String space = " "; 
        System.out.println("               Total for all flats                   ");
        System.out.println("__________________________________");
        System.out.printf("Total %12s %-12s %,.2f \n", colon, space, billTotal); //display as double rounded to 2 decimal places
        System.out.printf("Records processed: %19s %d \n" , space, length); //display the number of flats processed
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
    
    //use for Q3b testing
    public static int sequencialSearch(ArrayList<Meter> meterObjects, String searchTerm)
    {
      int length = meterObjects.size(); 
      
      for(int i = 0; i < length; i++)
      {
          if (searchTerm.compareTo(meterObjects.get(i).getTenantMeterNumber()) == 0) //do compareTo() because we're working with strings
          {
              return i; //this returns the index of the object if the search term is found
          }
      }
      return -1; // return -1 if the search term isn't found
    }
    
    //use for Q3b testing
     public static int findMeterNumberBinary(ArrayList<Meter> meterObjects, String searchTerm )
    {
        
            int left = 0, right = meterObjects.size() - 1; 
            
            while (left <= right)
            {
               int middle = left + (right - left) / 2;
               
               //use compareTo() for comparing string
               int result = searchTerm.compareTo(meterObjects.get(middle).getTenantMeterNumber()); 
               
               if (result == 0 )
               {
                  return middle;  
               }
               
               if (result > 0)
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
    
    
    //a function that finds the array list indext of an adress
    //it accepts the name of the street, along with the building number as search terms
    //the algorithm used is binary search which is O(log n) 
    public int findAddress(ArrayList<Flat> flatObjects, String searchTermStreet, int searchTermBuildingNumber )
    {
        
            int left = 0, right = flatObjects.size() - 1; 
            
            while (left <= right)
            {
               int middle = left + (right - left) / 2;
               
               //use compareToIgnoreCase() for comparing strings and handling lower or uppercase input
               int result = searchTermStreet.compareToIgnoreCase(flatObjects.get(middle).getStreet()); 
               
               
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
    
    //Q2
    //Method for finding and returning a flat object 
    public Flat searchFlat(ArrayList<Flat> flatObjects)
    {
        //flat object to be initialised and returned if the binary search finds the flat the user is looking for
        Flat foundFlat = new Flat(); 
        
        Scanner in = new Scanner(System.in);
        
        int searchStreetNumber; 
        System.out.printf("Enter the street number: "); 
        searchStreetNumber = in.nextInt();
        
        in.nextLine(); //have to put this here becaue nextInt() sucks. the in needs to be cleaned
        
        String searchAddress; 
        System.out.printf("Enter the street name: ");
        searchAddress = in.nextLine(); 
        
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
    
    public void proveSearch(ArrayList tenantMeterObjects)
    {
        long start;
         long end;
         long diff;
         
         Print display = new Print(); 
         
         sortMeterFile(tenantMeterObjects); //run sort in case it hasn't been run already
         
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
    }
}
