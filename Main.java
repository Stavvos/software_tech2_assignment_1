/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList; 
public class Main
{
    public Main()
    {
      /*
       • They are comma separated.
       • There may be leading or trailing blanks on any field that should be ignored;
       • Lines starting with / should be ignored, or if you want you can edit the file and delete them. 
       
        Flats file format: 
        street, building number, building meter, current reading, current reading date,previous reading, previous reading date,
        tenant meter1, tenant meter 2, tenant meter..repeat etc. 
        
        Sample data for flats:
        Adelaide Street,11,b239863,705007,07/04/2022,703649,11/01/2022,m163965,
        Alma Street,7,b239873,986460,06/04/2022,983395,09/01/2022,m163966,m163967,
        Alma Street,8,b239883,595049,06/04/2022,589650,09/01/2022,m163962,m163963,m163964,
       
        Meter file format: honorific name, first name, last name, corporation name (unused value for this assignment), 
        tenant meter number, current meter reading, current meter reading date, previous meter reading, previous meter reading date. 
       
        Sample data for meter file: 
        Mr,Lewis,Pressman,MT,m163962,223579,08/04/2022,221758,11/01/2022,
        Mrs,Diana,Purvis,MT,m163963,536530,08/04/2022,534696,11/01/2022,
        Mr,Harvey,Pearce,MT,m163964,157233,06/04/2022,155561,09/01/2022,
        Ms,Wendy,Yarwood,MT,m163965,289352,06/04/2022,287997,09/01/2022,
        Mr,James,Palmer,MT,m163966,319840,08/04/2022,318156,11/01/2022,
        Ms,Dorothy,McBride,MT,m163967,885781,06/04/2022,884413,11/01/2022,
      */ 
     
       System.out.println("\f"); 
     
       //a test for the flat class: 
       
       //create a flat object
       Flat flatObject = new Flat(); 
       
       //declare nand intialise testing values for the flatObject above
       String streetTest = "32 beaszli street forra";   
       String buildingMeterTest = "m12345432"; 
       String currentReadingDateTest = "22/03/2023";  
       String previousReadingDateTest = "20/03/2023";
       
       ArrayList<String> tenantMetersTest = new ArrayList<String>(); 
       tenantMetersTest.add("m123451");
       tenantMetersTest.add("m123453");
       tenantMetersTest.add("m123551");
       tenantMetersTest.add("m123555");
       tenantMetersTest.add("m003451");
       tenantMetersTest.add("m129451");
       tenantMetersTest.add("m777431");
       
       
       int buildingNumberTest = 2;
       int currentReadingTest = 5600; 
       int previousReadingTest= 4000;
       
       flatObject.setStreet(streetTest);
       flatObject.setBuildingMeter(buildingMeterTest);
       flatObject.setCurrentReadingDate(currentReadingDateTest);
       flatObject.setPreviousReadingDate(previousReadingDateTest);
       flatObject.setList(tenantMetersTest);
       flatObject.setBuildingNumber(buildingNumberTest); 
       flatObject.setCurrentReading(currentReadingTest);
       flatObject.setPreviousReading(previousReadingTest); 
       
       // print the flatObject for testing 
       printingTestFlatObject(flatObject);
       
        //declare a Meter object
        Meter testMeter = new Meter(); 
       
        //declare and initialise values for testing the Meter object
        String honorificName = "Mr"; 
        String firstName = "eoin"; 
        String lastName = "irishlad"; 
        String corporationName = "K-Mart"; 
        String tenantMeterNumber = "u2342345";
        String currentReadingDate = "23/3/2023"; 
        String previousReadingDate = "20/3/2023"; 
        
        int currentReading = 9000;
        int previousReading = 1000;
        
        testMeter.setHonorificName(honorificName);
        testMeter.setFirstName(firstName); 
        testMeter.setLastName(lastName);
        testMeter.setCorporationName(corporationName);
        testMeter.setTenantMeterNumber(tenantMeterNumber);
        testMeter.setCurrentReadingDate(currentReadingDate);
        testMeter.setPreviousReadingDate(previousReadingDate); 
        testMeter.setCurrentReading(currentReading);
        testMeter.setPreviousReading(previousReading); 
        
        printingTestMeterObject(testMeter);
    
    }
    
    public void printingTestMeterObject(Meter newMeterObject)
    {
       System.out.println("------testing Meter object getters and setters ------");
       System.out.println(newMeterObject.getHonorificName() + " " + newMeterObject.getFirstName() + " " +
       newMeterObject.getLastName() + " " + newMeterObject.getCorporationName() + " " + newMeterObject.getTenantMeterNumber() + " " +
       newMeterObject.getCurrentReadingDate() + " " + newMeterObject.getPreviousReadingDate() + " " +
       newMeterObject.getCurrentReading() + " " + newMeterObject.getPreviousReading());
       System.out.println(""); 
       
    }
    
    public void printingTestFlatObject(Flat newFlatObject)
    {
        //Flats file format: 
        //street, building number, building meter, current reading, current reading date,previous reading, previous reading date,
        //tenant meter1, tenant meter 2, tenant meter..repeat etc. 
        System.out.println("------testing Flat object getters and setters ------");
        System.out.println(newFlatObject.getStreet() + " " + newFlatObject.getBuildingNumber() + " " + newFlatObject.getBuildingMeter() 
        + " " + newFlatObject.getCurrentReading() + " " + newFlatObject.getCurrentReadingDate() + " " + 
        newFlatObject.getPreviousReading() + " " + newFlatObject.getPreviousReadingDate());
        
        for (int i = 0; i < newFlatObject.getList().size(); i++)
        {
            System.out.println(newFlatObject.getList().get(i));
        }
        
        System.out.println(""); 
    }
}
