import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
/**
 * The  class GeoSet is to make caculation using using arrays and location.
 *
 * @author (Souleymane Barry)
 * @version (Homework 5; 05/17/2022)
 */
public class GeoSet
{

    private int count;
    private Location[] location;

    /**
     * Constructor for objects of class GeoSet
     * @param fileName type string 
     * @return
     */
    public GeoSet(String fileName) throws FileNotFoundException{
        Scanner input=new Scanner(new File(fileName));
        count=input.nextInt();
        location = new Location[count];
        if (count<=1){
            throw new IllegalArgumentException("File must contain at least 2 locations");}
        for (int i=0; i<count;i++){
            String name=input.next();
            double latitude=input.nextDouble();
            double longitude=input.nextDouble();
            location[i]=new Location(name,latitude,longitude);
        }
    }

    
    /**
     * getCount an accessor to to get the location number
     *
     * @param 
     * @return    count
     */
    public int getCount()
    {

        return count;
    }

    /**
     * findMinDist() a method that calculate the minimum distance between the  locations
     *
     * @param  
     * @return   minDistance
     */
    public double findMinDistance()
    { double minDistance=location[0].distance(location[1]);
        for (int i=0;i<count-1;i++){
            if (location[i].distance(location[i+1])<minDistance){
                minDistance=location[i].distance(location[i+1]);}

        }
        return minDistance;
    }

    
    /**
     * find() find a location using the location name
     *
     * @param  name type string
     * @return    local the coordinates of the of the name
     */
    public Location find(String name)
    {
       Location local=null;
       for (int i=0;i<count;i++){
           if (location[i].getName().equals(name)){
               local=location[i];}
            }
               
        return local;
    }

    
    /**
     * farthest() to find the two farthest distance in the location list
     *
     * @param 
     * @return   the two farthest locations
     */
    public Location[] farthest()
    {
       Location[] farthestDist=new Location[2];
       double max=0, tempDist;
       for(int i=0;i<count-1;i++){
           for(int j=i+1;j<count;j++){
               tempDist=location[i].distance(location[j]);
               if (tempDist>max){
                   farthestDist[0]=location[i];
                   farthestDist[1]=location[j];
                   max=tempDist;
                }
            }
        } 
        return farthestDist;
                   
    }

    
    /**
     * toString method to read the info or result
     *
     * @param 
     * @return    its return a string to read the info
     */
    public String toString()
    {   String answer="";
        answer="There are " + getCount() + "locations in the file" + "\n";
        answer+="The minimum distance is " + findMinDistance() + "\n";
        answer+= Arrays.toString(farthest()) + " has the Farthest Distance.";
        return answer;
    }

}