package cas2xb3_finalprototype;
import edu.princeton.cs.algs4.*;

/**
 * The purpose of this class is to create a luggage graph that connects airports with airlines in 
 * the form of a multidimensional array. This is to coordinate the positions of the 
 * airport and airlines by their own IDs. 
 * @author Group 11 - Software Engineering 2XB3. 
 *
 */
public class LuggageGraph {

	private final int airlineVertices; //Number of Vertices
	private final int airportVertices;
	private int E; //Number of Edges
	private Edge[][] airlineAdj;
	private Edge[][] airportAdj;
	
	/**
	 * Initializes empty edge-weighted graph for the luggage with V vertices and 0 edges
	 * 
	 * @param airlineVerticeNumber This is the number of airline vertices that are present in the graph.
	 * @param airportVerticeNumber This is the number of airport vertices that are present in the graph.
	 * @throws IllegalArgumentException if the number of vertices is negative.
	 */
	public LuggageGraph(int airlineVerticeNumber, int airportVerticeNumber) {
		if ((airlineVerticeNumber)< 0 || 
				airportVerticeNumber < 0) throw new IllegalArgumentException("Number of vertices cannot be negative");
		this.airlineVertices = airlineVerticeNumber;
		this.airportVertices = airportVerticeNumber;
		this.E = 0;
		airlineAdj = new Edge[airlineVerticeNumber][];
		for (int v = 0; v < airlineVerticeNumber; v++) {
			airlineAdj[v] = new Edge[airportVerticeNumber];
		}
		
		airportAdj = new Edge[airportVerticeNumber][];
		for (int v = 0; v < airportVerticeNumber; v++) {
			airportAdj[v] = new Edge[airlineVerticeNumber];
		}
	}
	/**
	 * Returns number of airport vertices
	 * @return number of airport vertices
	 */
	public int getAirportVerticeNumber() {
		return this.airportVertices;
	}
	
	
	/**
	 * Returns the number of airline vertices.
	 * @return This returns the number of total airlines. 
	 */
	public int getAirlineVerticeNumber(){
		return this.airlineVertices;
	}
	
	/**
	 * Returns number of Edges
	 * @return number of edges
	 */
	public int E() {
		return E;
	}
	
	/**
	 * This will add an edge between an airline and an airport, and will fill
	 * each of their respective adjacency list. 
	 * @param e This is the edge that is inputted, which contains airline and airport
	 * vertices with their own ID. That ID indicates the index it will be placed
	 * in the adjacency lists (in a multidimensional array format).
	 */
	public void addEdge(Edge e) {
		int v = e.airportVertex().uid;
		int w = e.airlineVertex().getID();
		
		if (airportAdj[v][w] == null){
			airportAdj[v][w] = e;
			airlineAdj[w][v] = e;
			E++;
		}
		else{
			airportAdj[v][w].increaseWeight();
			airlineAdj[w][v].increaseWeight();
		}
	}
	
	
	/**
	 * This returns the ratio of a particular airport vertex by determining the average
	 * luggage lost per airline at a specific airport. This takes into consideration
	 * the airlines that are associated with an airport only.
	 * @param i The airport vertex's index.
	 * @return The ratio of luggage lost/airline at an airport.
	 */
	public double ratio(int i){
		int totalWeight = 0;
		int totalAirlines = 0;
		
		for (int j = 0; j < airportAdj[i].length; j ++){
			if (airportAdj[i][j] != null){
				totalWeight += airportAdj[i][j].weight();
				totalAirlines++;
			}
		}
		
		double ratio = 0;
		if (totalAirlines == 0){
			return ratio;
		}
		else{
			ratio = totalWeight / totalAirlines * 1.0;
		}
		return ratio;
	}
	
	
}
