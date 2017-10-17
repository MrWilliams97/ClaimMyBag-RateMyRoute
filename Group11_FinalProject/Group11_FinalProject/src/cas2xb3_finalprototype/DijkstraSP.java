package cas2xb3_finalprototype;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * This is the Dijkstra's algorithm that determines the shortest path from one
 * location to another depending on a source vertex and an airport graph that
 * is provided.
 * @author Group 11 - Software Engineering 2XB3. 
 *
 */
public class DijkstraSP {
	private AirportEdge[] edgeTo;
	private double[] averageRiskLevel;
	private IndexMinPQ<Double> pq;
	
	/**
	 * This is the constructor for the Dijkstra's algorithm object that
	 * takes an airport graph and a source vertex for the determination of
	 * risk level through the relax method being continuously called.
	 * @param G This is the airport graph that is provided.
	 * @param s This is the soruce vertex that is identified by ID of the AirportVertex objects.
	 */
	public DijkstraSP(AirportGraph G, int s){
		edgeTo = new AirportEdge[G.V()];
		averageRiskLevel = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for (int v = 0; v < G.V(); v++){
			averageRiskLevel[v] = Double.POSITIVE_INFINITY;
		}
		averageRiskLevel[s] = 0.0;
		
		pq.insert(s,  0.0);
		while(!pq.isEmpty())
			relax(G, pq.delMin());
	}
	
	
	/**
	 * This is the relax method continuously called to either fill up the priority queue or 
	 * remove items from the priority queue to update averageRiskLevels to various
	 * airport locations in the connectig airports file. 
	 * @param G This is the airport graph that is provided.
	 * @param v This is the vertex in question where all adjacent edges are observed. 
	 */
	private void relax(AirportGraph G, int v){
		for (AirportEdge e : G.adj(v)){
			int w = e.to();
			if (averageRiskLevel[w] > averageRiskLevel[v] + e.frequencyRisk()){
				averageRiskLevel[w] = averageRiskLevel[v] + e.frequencyRisk();
				edgeTo[w] = e;
				if (pq.contains(w)) pq.changeKey(w, averageRiskLevel[w]);
				else pq.insert(w, averageRiskLevel[w]);
			}
		}
	}
	
	/**
	 * This determines the overall risk level to a given location from the source vertex already predefined.
	 * @param v The vertex ID that is passed in.
	 * @return Returns the double regarding the average risk level to the passed in vertex ID. 
	 */
	public double riskLevelTo(int v){
		return averageRiskLevel[v];
	}
	
	/**
	 * Returns a boolean to determine whether or not there is a path to a 
	 * parameter ID's airport from the source airport defined by ID.
	 * @param v This is the vertex that is checked for a path to.
	 * @return Returns true or false depending on whether a path is found or not from the source.
	 */
	public boolean hasPathTo(int v){
		return averageRiskLevel[v] < Double.POSITIVE_INFINITY;
	}
	
	/**
	 * This returns an iterable object of airport edges to determine all subpaths to a given location.
	 * @param v This is the airport ID to find all paths that it takes to make it to this airport.
	 * @return Returns all airport edges to the given airport (which is defined by an ID).
	 */
	public Iterable<AirportEdge> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<AirportEdge> path = new Stack<AirportEdge>();
		for (AirportEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}
}
