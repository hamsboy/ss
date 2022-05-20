
/**
 * You have been hired by a company to write a program that will read in a set of locations from a text file and display certain information about the data set.

 *
 * @author (Souleymane Barry)
 * @version (Homework 5 ; 05/17/2022)
 * 
 * EXTRA CREDIT: Helper method should be private because it make it easier for the supplier to make changes to the program
 * specially when the program becomes more complex. It's also allow the encapsulation of the program from to avoid the
 * alteration from the client.
 * 
 */
public class Location
{
    private String name;
    private double latitude;
    private double longitude; 
    public static final double RADIUS = 3963.1676;  // Earth radius in miles
    
    
    /**
     * Full constructor for the location class
     *
     * @param name type string;
     * @param latitude type double;
     * @param longitude type double;
     * 
     */
    

    public Location(String theName,double theLatitude, double theLongitude) {
       setName(theName);
       setLatitude(theLatitude);
       setLongitude(theLongitude);
    }
 
    /**
     * Empty constructor for the class location
     */
    public Location()
    {
        this("",0.0,0.0);
    }
    
    /**
     *  getName method to access name of the location
     *
     * @param  
     * @return    name
     */
    public String getName()
    {
        
        return name;
    }

    /**
     * getLatitude method
     *
     * @param  
     * @return    latitude
   */

    public double getLatitude() {
        return latitude;
    }

   /**
     * getLongitude method
     *
     * @param  
     * @return    longitude
   */
    public double getLongitude() {
        return longitude;
    }
    
    
    /**
     * Setname() method to modify the name
     *
     * @param the name type string
     * @return   
     */
    public void setName(String theName)
    {
         if (theName.equals("")){
            throw new IllegalArgumentException("Name Cannot be Empty");}
            name=theName;
        
    }
    
    
    /**
     * setLatitude() to modify the latitude
     *
     * @param  theLatitude type double
     * @return    
     */
    public void setLatitude(double theLatitude)
    {if ((theLatitude<-90.0||theLatitude>90.0)){
            throw new IllegalArgumentException("The latitude must be between -90 and 90");}
            latitude=theLatitude;
    }


    /**
     * setLongitude() to modify the longitude
     *
     * @param longitude tyoe double
     * @return    
     */
    public void setLongitude(double theLongitude)
    { if (theLongitude<-180.0||theLongitude>180.0){
            throw new IllegalArgumentException("The latitude must be between -180 and 180");}
            longitude=theLongitude;
        
    }

/**
     * toString() method to read the result or info
     *
     * @param  
     * @return    result
   */
    public String toString() {
        String result="";
        result+="Name : " + getName() + "\n";
        result+="Latitude: " + getLatitude() + "\n";
        result+="Longitude: " + getLongitude() + "\n";
        return result;
}

    /**
     * distance method to calculate the distance between to location
     *
     * @param  other type Location
     * @return  arcLength * RADIUS; 
     */
    public double distance(Location other){
    
        double lat1 = Math.toRadians(latitude);
        double long1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(other.latitude);
        double long2 = Math.toRadians(other.longitude);
        // apply the spherical law of cosines with a triangle composed of the
        // two locations and the north pole
        double theCos = Math.sin(lat1) * Math.sin(lat2) +
            Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
        double arcLength = Math.acos(theCos);
        return arcLength * RADIUS;
    }
        
    }


