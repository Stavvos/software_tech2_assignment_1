import java.util.*; 

public class Print
{
    
     
    Scanner in = new Scanner(System.in);
    
    public Print()
    {
      
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
