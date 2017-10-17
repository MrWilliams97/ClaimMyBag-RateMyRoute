package cas2xb3_finalprototype;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class JUnitTesting {

	/**
	 * This checks for duplicates inside of the linked hash map between different airport codes and
	 * airports. 
	 * @throws Exception This is thrown if the text file cannot be found within the project. 
	 */
	@Test
	public void noDuplicateCodesTest() throws Exception {
		
		LinkedHashMap <String, String> codeToAirport = new LinkedHashMap<String, String> ();
		
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
		List<String> keys = new ArrayList<String>(codeToAirport.keySet());
		Collections.sort(keys);
		
		boolean duplicatedAssertion = true;
		for (int i = 1; i < keys.size(); i ++){
			if (keys.get(i).equals(keys.get(i - 1))){
				duplicatedAssertion = false;
			}
		}
		assertTrue(duplicatedAssertion == true);
		
		br.close();
	}

	/**
	 * This is used to determine whether or not there are no blank airport names filled out 
	 * inside of the linked hash map produced inside RateMyRouteFinal.java. 
	 * This cuts down time for the future as less objects will need to be iterated through.
	 * @throws Exception This is thrown if the file is not found for claims. 
	 */
	@Test
	public void noBlankAirportNamesTest() throws Exception{
		//This will read through the claims file in order to get all possible instances
		//of lost luggage relating to airport and airline. You have to go through it once first
		//in order to initialize the number of airports and airlines for the first graph.
		FileInputStream fr = new FileInputStream("claims-2002-2006_0.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fr));
		String lineString;
		br.readLine();
		int chosenMonth = 2;
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
		
		
		boolean noEmptyCode = true;
		for (int i = 0; i < airportObjects.size(); i ++){
			AirportVertex testAirport = (AirportVertex) airportObjects.get(i);
			if(testAirport.getAirportCode().equals("")){
				noEmptyCode = false;
			}
		}
		
		assertTrue(noEmptyCode);
	}
	
	
	/**
	 * This ensures that there is no luggage found with a missing claim number. 
	 * @throws Exception This is thrown if the file cannot be found for file reading which
	 * gets all of the various claim numbers inside of the TSA data set.
	 */
	@Test
	public void blankClaimNumberTest() throws Exception{
		LuggageT resultingLuggage = Search.getLuggage(FileReading.luggage(), "");
		assertTrue(resultingLuggage == null);
	}
	
	/**
	 * This checks for a successful search of the very first claim number found in the dataset. 
	 * The airport is checked for an appropriate match of luggage object found.
	 * @throws Exception This is thrown if the file for file reading cannot be found.
	 */
	@Test
	public void trueSearchTest() throws Exception{
		LuggageT resultingLuggage = Search.getLuggage(FileReading.luggage(), "0909802M");
		assertTrue(resultingLuggage.getKnownAirportName().equals("Newark International Airport"));
	}
	
	/**
	 * This checks if the appropriate output for the GUI is made where the known airport name
	 * being empty results in a new output.
	 * @throws Exception This is thrown if the claims file cannot be found inside FileReading.java.
	 */
	@Test
	public void testNoAirportInfo() throws Exception{
		LuggageT resultingLuggage = Search.getLuggage(FileReading.luggage(), "0616636L");
		if(resultingLuggage.getKnownAirportName().equals("")){
			assertTrue(true);
		}
		else{
			assertTrue(false);
		}
	}
	
	

}
