
/**
 * Write a description of class Meter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Meter
{ 
    public String honorificName; 
    public String firstName; 
    public String lastName; 
    public String corporationName; 
    public String tenantMeterNumber;
    public String currentReadingDate; 
    public String previousReadingDate; 
    
    public int currentReading;
    public int previousReading; 
    
   
     public Meter()
     {
         /*
       • They are comma separated.
       • There may be leading or trailing blanks on any field that should be ignored;
       • Lines starting with / should be ignored, or if you want you can edit the file and delete them. 
       
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
    }
    
    
    //getter and setter methods for this class Meter
     public String getHonorificName()
    {
        return honorificName; 
    }
    
    public void setHonorificName(String newHonorificName)
    {
      this.honorificName = newHonorificName; 
    }
    
     public String getFirstName()
    {
        return firstName; 
    }
    
    public void setFirstName(String newFirstName)
    {
      this.firstName = newFirstName; 
    }
    
     public String getLastName()
    {
        return lastName; 
    }
    
    public void setLastName(String newLastName)
    {
      this.lastName = newLastName; 
    }
    
     public String getCorporationName()
    {
        return corporationName; 
    }
    
    public void setCorporationName(String newCorporationName)
    {
      this.corporationName = newCorporationName; 
    }
    
     public String getTenantMeterNumber()
    {
        return tenantMeterNumber; 
    }
    
     public int getTenantMeterNumberInt()
    {
        //clean the string of the "m" at the front, and convert it to an integer for the sorting routine
        int tenantMeterNumberInt = Integer.parseInt(tenantMeterNumber.substring(1));
        return tenantMeterNumberInt; 
    }
    
    public void setTenantMeterNumber(String newTenantMeterNumber)
    {
      this.tenantMeterNumber = newTenantMeterNumber; 
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
    
      public int getCurrentReading()
    {
        return currentReading; 
    }
    
    public void setCurrentReading(int newCurrentReading)
    {
      this.currentReading = newCurrentReading; 
    }
    
       public int getPreviousReading()
    {
        return previousReading; 
    }
    
    public void setPreviousReading(int newPreviousReading)
    {
      this.previousReading = newPreviousReading; 
    }    
}
