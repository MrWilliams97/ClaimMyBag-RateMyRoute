package cas2xb3_finalprototype;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/**
 * This class is used to create a series of graphs in order to find a lowest risk path from one location to 
 * another that is provided by the user in terms of two airport codes and a month.
 * A first graph is created by LuggageGraph to find the statistics in terms of lost luggage/associated airline
 * at a given airport, then that data is passed into a second graph as weights for airport edges between
 * two different airports. Dijkstra's algorithm is then used to determine the lowest risk path
 * by our metric. 
 * @author Group 11 - Software Engineering 2XB3
 *
 */
public class RateMyRouteFinal {
	
	/**
	 * This creates the Dijkstra's algorithm path that is used
	 * to determine the lowest risk path. Parameters provided by the user through the GUI
	 * is passed into here.
	 * @param startingLocation This is the starting location of the route by airport code.
	 * @param endingLocation This is the ending location of the route by airport code.
	 * @param givenMonth This is the given month to travel in for the user, depending on
	 * when they choose to make the travel or not.
	 * @return This returns the output in Array List, where each index represents a line to 
	 * be printed out to the GUI for the user's use.
	 * @throws Exception This is thrown if the file in question cannot be found. 
	 */
	public static ArrayList<String> totalOutput(String startingLocation, String endingLocation, Integer givenMonth) throws Exception{
		//This linked hash map contains the key,value pairing of Airport Code, Location (City, State)
				LinkedHashMap <String, String> codeToAirport = new LinkedHashMap<String, String> ();
				
				int chosenMonth = givenMonth;
				//Firstly, this reads through the file of all connecting airport routes
				//in the larger dataset.
				FileInputStream fr = new FileInputStream("ConnectingAirports.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fr));
				
				br.readLine();
				
				String lineString;
				
				//Reads through the connecting airports set. 
				while((lineString = br.readLine()) != null){
					/**System.out.println(lineString.split("\t", -1)[4].trim() + "   " +
				lineString.split("\t", -1)[5].replaceAll("^\"|\"$", "").trim() + "     " + lineString.split("\t", -1)[9].trim() + "    " +
				lineString.split("\t", -1)[10].replaceAll("^\"|\"$", "").trim());
					List<Object> keys = new ArrayList<Object>(codeToAirport.keySet());
					System.out.println(keys.size());**/
					//Puts all of the possible airports and locations by (City, US State) 
					//into a linked hash map to keep proper ordering for the upcoming Graph.
					//It also prevents duplicates by replacing the "Value" (location) each 
					//time an already found airport is uncovered.
					codeToAirport.put(lineString.split("\t", -1)[4].trim(),
							lineString.split("\t", -1)[5].replaceAll("^\"|\"$", "").trim());
					codeToAirport.put(lineString.split("\t", -1)[9].trim(), 
							lineString.split("\t", -1)[10].replaceAll("^\"|\"$", "").trim());
				}
				
				//This gets all of the possible keys (airport codes)
				//and prints them out. There are over a thousand unique airport codes uncovered.
				ArrayList<Object> keys = new ArrayList<Object>(codeToAirport.keySet());
				ArrayList<Object> locations = new ArrayList<Object>(codeToAirport.values());
				
				if (!keys.contains(startingLocation) || !keys.contains(endingLocation)){
					return null;
				}
				
				
				
				
				
				//This will read through the claims file in order to get all possible instances
				//of lost luggage relating to airport and airline. You have to go through it once first
				//in order to initialize the number of airports and airlines for the first graph.
				fr = new FileInputStream("claims-2002-2006_0.txt");
				br = new BufferedReader(new InputStreamReader(fr));
				
				br.readLine();
				
				ArrayList<LuggageT> monthLuggage = new ArrayList<LuggageT>();
				LinkedHashMap<String, AirportVertex> airportsLostLuggage = new LinkedHashMap<String, AirportVertex>();
				LinkedHashMap<String, AirlineVertex> airlinesLostLuggage = new LinkedHashMap<String, AirlineVertex>();
				while((lineString = br.readLine()) != null){
					String[] splitting = lineString.split("\t", -1);
					
					//If the month information is empty, then forget about it and move to the next line.
					if (splitting[1].equals("")){
						continue;
					}
					else{
							//Gets the month of the luggage item inside the claims text file.
							String month = splitting[1].split("-")[1];
							int luggageMonth = 0;
							switch (month) {
							case "Jan":
								luggageMonth = 1;
							case "01":
								luggageMonth = 1;
								break;
							case "Feb":
								luggageMonth = 2;
								break;
							case "02":
								luggageMonth = 2;
								break;
							case "Mar":
								luggageMonth = 3;
								break;
							case "03":
								luggageMonth = 3;
								break;
							case "Apr":
								luggageMonth = 4;
								break;
							case "04":
								luggageMonth = 4;
								break;
							case "May":
								luggageMonth = 5;
								break;
							case "05":
								luggageMonth = 5;
								break;
							case "Jun":
								luggageMonth = 6;
								break;
							case "06":
								luggageMonth = 6;
								break;
							case "Jul":
								luggageMonth = 7;
								break;
							case "07":
								luggageMonth = 7;
								break;
							case "Aug":
								luggageMonth = 8;
								break;
							case "08":
								luggageMonth = 8;
								break;
							case "Sep":
								luggageMonth = 9;
								break;
							case "09":
								luggageMonth = 9;
								break;
							case "Oct":
								luggageMonth = 10;
								break;
							case "10":
								luggageMonth = 10;
								break;
							case "Nov":
								luggageMonth = 11;
								break;
							case "11":
								luggageMonth = 11;
								break;
							case "Dec":
								luggageMonth = 12;
								break;
							case "12":
								luggageMonth = 12;
								break;
							}
							
							
							if (luggageMonth == chosenMonth){
								monthLuggage.add(new LuggageT(splitting[0], splitting[1], luggageMonth, 
										splitting[2], splitting[3],
										splitting[4], splitting[5], splitting[6], splitting[7]));
								
								ArrayList<String> airportCodes = new ArrayList<String>(airportsLostLuggage.keySet());
								ArrayList<AirportVertex> airportVertexes = new ArrayList<AirportVertex>(airportsLostLuggage.values());
								ArrayList<String> airlineNames = new ArrayList<String>(airlinesLostLuggage.keySet());
								ArrayList<AirlineVertex> airlineVertexes = new ArrayList<AirlineVertex>(airlinesLostLuggage.values());
								
								if(!airportCodes.contains(splitting[3]) && !splitting[3].equals("")){
									airportsLostLuggage.put(splitting[3], new AirportVertex(splitting[4], splitting[3], airportCodes.size()));
								}
								
								if(!airlineNames.contains(splitting[5]) && !splitting[5].equals("")){
									airlinesLostLuggage.put(splitting[5], new AirlineVertex(splitting[5], airlineNames.size()));
								}
							}
					}
				}
					
				ArrayList<Object> airportCodes = new ArrayList<Object>(airportsLostLuggage.keySet());
				ArrayList<Object> airportObjects = new ArrayList<Object>(airportsLostLuggage.values());
				ArrayList<Object> airlineNames = new ArrayList<Object>(airlinesLostLuggage.keySet());
				ArrayList<Object> airlineVertices = new ArrayList<Object>(airlinesLostLuggage.values());
				LuggageGraph G = new LuggageGraph(airlineNames.size(), airportCodes.size());
				
				for (int i = 0; i < monthLuggage.size(); i++){
					if (!monthLuggage.get(i).getAirportCode().equals("") && !monthLuggage.get(i).getAirlineName().equals("")){
						int airportNumber = airportCodes.indexOf(monthLuggage.get(i).getAirportCode());
						int airlineNumber = airlineNames.indexOf(monthLuggage.get(i).getAirlineName());
						AirlineVertex firstPart = (AirlineVertex) airlineVertices.get(airlineNumber);
						AirportVertex secondPart = (AirportVertex) airportObjects.get(airportNumber);
						Edge airlineAirportConnection = new Edge(secondPart, firstPart, 0);
						
						G.addEdge(airlineAirportConnection);
					}
				}
				
				Double[] correspondingWeights = new Double[airportCodes.size()];
				
				for (int i = 0; i < airportCodes.size(); i++){
					correspondingWeights[i] = G.ratio(i);
				}
				

				fr = new FileInputStream("ConnectingAirports.txt");
				br = new BufferedReader(new InputStreamReader(fr));
				
				br.readLine();
				AirportGraph finalGraph = new AirportGraph(keys.size());
				
				while((lineString = br.readLine()) != null){
					double startingWeight = 0;
					double endingWeight = 0;
					String startingAirportCode = lineString.split("\t", -1)[4];
					String endingAirportCode = lineString.split("\t", -1)[9];
					if(airportCodes.contains(startingAirportCode)){
						startingWeight = correspondingWeights[airportCodes.indexOf(startingAirportCode)];
					}
					
					if(airportCodes.contains(endingAirportCode)){
						endingWeight = correspondingWeights[airportCodes.indexOf(endingAirportCode)];
					}
					AirportEdge airportLink = new AirportEdge(keys.indexOf(startingAirportCode), keys.indexOf(endingAirportCode), 
							startingWeight + endingWeight);
					
					finalGraph.addEdge(airportLink);
				}
				
				DijkstraSP shortestPaths = new DijkstraSP(finalGraph, keys.indexOf(startingLocation));
				
				ArrayList<String> totalOutput = new ArrayList<String>();
				if (!shortestPaths.hasPathTo(keys.indexOf(endingLocation))){
					System.out.println("Sorry! No path exists to here!");
				}
				else{
					for (AirportEdge e : shortestPaths.pathTo(keys.indexOf(endingLocation))){
						totalOutput.add(keys.get(e.from()) + " - > " + keys.get(e.to()));
						totalOutput.add(locations.get(e.from()) + " - > " + locations.get(e.to()));
					}
				}
				
				
				br.close();
				return totalOutput;
	}
}
