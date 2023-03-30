import java.util.ArrayList; 

public class Algorithms
{
    public Algorithms()
    {
        
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
    
    //a function that finds the array list indext of an adress
    //it accepts the name of the street, along with the building number as search terms
    //the algorithm used is binary search which is O(log n) 
    public int findAddress(ArrayList<Flat> flatObjects, String searchTermStreet, int searchTermBuildingNumber )
    {
        
            int left = 0, right = flatObjects.size() - 1; 
            
            while (left <= right)
            {
               int middle = left + (right - left) / 2;
               
               int result = searchTermStreet.compareTo(flatObjects.get(middle).getStreet()); //use compareTo() for comparing string
               
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
}
