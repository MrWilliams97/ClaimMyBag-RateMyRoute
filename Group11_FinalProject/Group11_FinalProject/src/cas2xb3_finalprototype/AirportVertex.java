package cas2xb3_finalprototype;

/**
 * The purpose of this class is to create an airport vertex that
 * pertains to a name and unique ID that is given by RateMyRouteFinal.java,
 * as well as airport code to determine whether a weight exists for one inside
 * the connectingairpoort.txt file.
 * @author Group 11 - Software Engineering 2XB3
 *
 */
public class AirportVertex implements Comparable<AirportVertex> {

	public String name; 	// label for vertex
	public int uid; 		// unique identifier for vertex (index)
	public String airportCode;
	
	/**
	 * This is the constructor of the AirportVertex objects, which is 
	 * defined by the name of the airport, the airport code, as well
	 * as the ID.
	 * @param v This is the name of the airport.
	 * @param code This is the 3-digit airport code.
	 * @param i This is the ID that is set by RouteMyRouteFinal.java.
	 */
	public AirportVertex(String v, String code, int i) {
		name = v;
		uid = i;
		airportCode = code;
	}

	/**
	 * This returns the ID of the airport.
	 * @return The ID of the airport in integer format. 
	 */
	public int getID(){
		return this.uid;
	}
	
	/**
	 * This returns the airport code of the airport. 
	 * @return The 3-digit airport code defined by a String.
	 */
	public String getAirportCode(){
		return this.airportCode;
	}
	
	/**
	 * This returns the name of the airport
	 * @return The name of the airport. 
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * Determines whether the name of one airport is greater than in value 
	 * to another airport name.
	 * @return This is the integer that determines whether a name
	 * is greater than or equal to the other object's name as a parameter. 
	 */
	public int compareTo(AirportVertex other) {
		return this.name.compareTo(other.toString());
	}
}