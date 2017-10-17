package cas2xb3_finalprototype;

/**
 * The purpose of this class is to create an Edge between an airport and an airline,
 * which can be passed into the LuggageGraph to determine the ratios 
 * of lost luggage/associated airline at an airport. 
 * @author Group 11 - Software Engineering 2XB3 
 *
 */
public class Edge  {
	private final AirportVertex v;
	private final AirlineVertex w;
	private int weight;
	
	
	/**
	 * Initializes an edge between vertices v and w of the given weight.
	 * @param v one vertex
	 * @param w other vertex
	 * @param weight weight of the edge
	 * @throws IllegalArgumentException if either v or w are null
	 * @throws IllegalArgumentException if the weight is negative
	 */
	public Edge(AirportVertex v, AirlineVertex w, int weight) {
		if (v.equals(null)) throw new IllegalArgumentException("Vertex cannot be null");
		if (w.equals(null)) throw new IllegalArgumentException("Vertex cannot be null");
		if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	/**
	 * Returns weight of the edge
	 * @return weight of the edge
	 */
	public int weight() {
		return weight;
	}
	
	public void increaseWeight() {
		this.weight++;
	}
	
	/**
	 * Returns the first vertex the edge is connected to
	 * @return first vertex
	 */
	public AirportVertex airportVertex() {
		return v;
	}
	
	/**
	 * Returns other end of the edge
	 * @return other end of the edge
	 * @throws IllegalArgumentException if the vertex is not one of the endpoints of the edge
	 */
	public AirlineVertex airlineVertex() {
		return w;
	}
	
	/**
	 * Compares two edges by weight
	 * @param that the other edge
	 * @return a negative int, zero, or positive int depending on whether
	 * the weight is less than, equal to, or greater than the argument
	 * edge
	 */
	
	public int compareTo(Edge that) {
		return Integer.compare(this.weight, that.weight);
	}
	
	/**
	 * Returns a string representation of the edge
	 * @return a string representation of the edge.
	 */
	public String toString() {
		return String.format(v.name + " " + w.toString() + " " + "%d", weight);
	}
	

}

