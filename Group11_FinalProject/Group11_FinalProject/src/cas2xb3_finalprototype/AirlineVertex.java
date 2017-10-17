package cas2xb3_finalprototype;

/**
 * This is the airline vertex that defines specific airlines that
 * are associated with different airports regarding lost luggage cases
 * inside of the TSA dataset. 
 * @author Group 11 - Software Engineering 2XB3
 *
 */
public class AirlineVertex implements Comparable<AirlineVertex> {

	private String name; 	// label for vertex
	private int uid; 		// unique identifier for vertex (index)

	/**
	 * This is the constructor for the airline vertex for the name and unique ID.
	 * @param v This is the name of the airline that is being used.
	 * @param i This is the ID starting from 0 when being produced from the 
	 * RateMyRouteFinal.java file.
	 */
	public AirlineVertex(String v, int i) {
		name = v;
		uid = i;
	}

	/**
	 * This is the getter for the airline's ID.
	 * @return This returns the ID of the airline. 
	 */
	public int getID(){
		return this.uid;
	}
	
	/**
	 * This is the getter of the airline's name. It
	 * can be used for alphabetical arrangement.
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * This returns an integer based on a comparison of names.
	 * @return This returns an integer depending on whether or not the name 
	 * of one of the airlines is lexicographically lower than or higher 
	 * than the one passed into the parameter.
	 */
	public int compareTo(AirlineVertex other) {
		return this.name.compareTo(other.name);
	}
}
