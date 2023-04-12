public class Counter
{
    //this class' purpose is so that it can be passed in by reference into the readFromFlatFiles(flatObjects, counter) and 
    //the  readFromMeterFiles(flatObjects, counter) methods from the ReadFile class.
    //doing it this will allow the manipulation of the below variables to be permenant and reuseable 
    private int numberOfObjects; 
    private int numberOfFlatMeters; 
    private int currentReadingsTotal;
    
    public Counter()
    {
       numberOfObjects = 0; 
       numberOfFlatMeters = 0; 
       currentReadingsTotal = 0; 
    }
    
    public void resetNumberOfObjects()
    {
     numberOfObjects = 0; 
    }
    
    public void resetNumberOfFlatMeters()
    {
     numberOfFlatMeters = 0; 
    }
    
    public void resetCurrentReadingsTotal( )
    {
       currentReadingsTotal = 0; 
    }
    
    
     public void incrementNumberOfObjects()
    {
       numberOfObjects++; 
    }
    
    public void incrementNumberOfFlatMeters()
    {
    
     numberOfFlatMeters++; 
    }
    
    public void currentReadingsTotal( int currentReading)
    {
       currentReadingsTotal += currentReading; 
    }
    
      public int getNumberOfFlats()
    {
      return numberOfObjects; 
    }
    
    public int getNumberOfFlatMeters()
    {
      return numberOfFlatMeters; 
    }
    
    public int getCurrentReadingsSum()
    {
      return currentReadingsTotal; 
    }   
}
