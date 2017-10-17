package cas2xb3_finalprototype;

/**
 * The purpose of this class is to create edges between 
 * two different airports that are differentiated by ID. 
 * Those IDs determine the location of where the airport
 * is going and coming from.
 * @author Group 11 - Software Engineering 2XB3
 *
 */
public class AirportEdge {
	private final int v;
	private final int w;
	private final double frequencyRisk;
	
	/**
	 * This is the airport edge constructor that takes 
	 * a starting point, destination, as well as a frequency risk which
	 * sums the two locations' fraction of luggage lost/associated airline.
	 * @param v Where the route is starting from.
	 * @param w Where the route is ending.
	 * @param frequencyRisk The sum of the two ratios that is considered
	 * the weight of the edge. This cannot be changed, unlike the LuggageGraph.
	 */
	public AirportEdge(int v, int w, double frequencyRisk){
		this.v = v;
		this.w = w;
		this.frequencyRisk = frequencyRisk;
	}
	
	/**
	 * This returns the weight of the edge defined by the summed fractions at
	 * the two airport locations.
	 * @return The weight of the edge.
	 */
	public double frequencyRisk(){
		return frequencyRisk;
	}
	
	/**
	 * This is returns the starting location by the ID of the airport.
	 * @return The starting airport's ID.
	 */
	public int from(){
		return v;
	}
	
	/**
	 * This returns the ending location by the ID of the airport.
	 * @return The ending airport's ID.
	 */
	public int to(){
		return w;
	}
	
}