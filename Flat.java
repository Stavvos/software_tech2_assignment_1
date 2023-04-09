import java.util.ArrayList; 
/**
 * Write a description of class Flat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flat
{
    public String street;   
    public String buildingMeter; 
    public String currentReadingDate;  
    public String previousReadingDate;
    public ArrayList<String> tenantMeters = new ArrayList<String>(); 
    
    public int buildingNumber;
    public int currentReading; 
    public int previousReading;
    
    public double usage;
    public double bill; 
    
    public Flat( )
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
      */
    
    }
    
    public void setBill(double newBill)
    {
     this.bill = newBill; 
    }
    
    public double getBill()
    {
      return bill; 
    }
    
    public void setUsage(double newUsage)
    {
     this.usage = newUsage; 
    }
    
    public double getUsage()
    {
      return usage; 
    }
    
    //getter and setter methods for this class Flat
    public ArrayList<String> getTenantMetersList() {
        return tenantMeters;
    }

    public void setTenantMetersList(ArrayList<String> newArrayList) {
        tenantMeters = newArrayList;
    }
    
    
    public int getPreviousReading()
    {
        return previousReading; 
    }
    
    public void setPreviousReading(int newPreviousReading)
    {
     this.previousReading = newPreviousReading; 
    }
    
    public int getCurrentReading()
    {
        return currentReading; 
    }
    
    public void setCurrentReading(int newCurrentReading)
    {
     this.currentReading = newCurrentReading; 
    }
    
    public int getBuildingNumber()
    {
        return buildingNumber;
    }
    
    public void setBuildingNumber(int newBuildingNumber)
    {
     this.buildingNumber = newBuildingNumber;  
    }
    
    public String getStreet()
    {
        return street; 
    }
    
    public void setStreet(String newStreet)
    {
        this.street = newStreet; 
    }
    
    public String getBuildingMeter()
    {
        return buildingMeter; 
    }
    
    public void setBuildingMeter(String newBuildingMeter)
    {
        this.buildingMeter = newBuildingMeter; 
    }
    
    public String getCurrentReadingDate()
    {
        return currentReadingDate; 
    }
    
    public void setCurrentReadingDate(String newCurrentReadingDate)
    {
        this.currentReadingDate = newCurrentReadingDate; 
    }
    
    public String getPreviousReadingDate()
    {
        return previousReadingDate; 
    }
    
    public void setPreviousReadingDate(String newPreviousReadingDate)
    {
        this.previousReadingDate = newPreviousReadingDate; 
    }
}
