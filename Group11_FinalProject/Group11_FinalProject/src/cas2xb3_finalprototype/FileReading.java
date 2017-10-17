package cas2xb3_finalprototype;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 * The purpose of this class is to be able to read from a text file that is directly
 * correlating with a dataset that was retrieved as an Excel file.
 * The claims file that is provided contains historical information on claim numbers
 * and lost luggage found at specific destinations.
 * 
 * This will organize all pieces of luggage into an abstract data type consisting 
 * of setters and getters. 
 * @author SE2XB3 Group 11
 *
 */
public class FileReading {
	
	public static ArrayList<LuggageT> totalLuggage;
	/**
	 * This returns all of the lost luggages inside of the claims text file  
	 * in the form of the LuggageT objects ArrayList. An ArrayList was chosen 
	 * in the event of more being updated to the dataset, and a resizing array was not used because it would
	 * sometimes be necessary to go through the elements in linear time (and going through null objects would
	 * waste time, as opposed to space).
	 * @return Returns the total luggage that was found in the TSA dataset. 
	 * @throws Exception This throws an exception depending on whether or not the 
	 * file can be found for the claims. 
	 */
	public static ArrayList<LuggageT> luggage() throws Exception {
		// TODO Auto-generated method stub
		
		
		totalLuggage = new ArrayList<LuggageT>();
		
		FileInputStream fstream = new FileInputStream("claims-2002-2006_0.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		//This ensures that the headers are not included inside of a LuggageT object.
		br.readLine();
		
		
		//This will read the dataset line by line until it reaches a line 
		//that is identified as null. 
		int count = 0;
		while ((strLine = br.readLine()) != null) {
			// This splits the line by the tab characters in order to properly
			// segment the contents of the Luggage.
			String[] splitting = strLine.split("\t", -1);
			int month = 0;
			
			
			if (splitting[1].equals("")){
				month = 0;
			}
			else{
				
				String splitReceivalData = splitting[1].split("-")[1];
	
				switch (splitReceivalData) {
					case "Jan":
						month = 1;
					case "01":
						month = 1;
						break;
					case "Feb":
						month = 2;
						break;
					case "02":
						month = 2;
						break;
					case "Mar":
						month = 3;
						break;
					case "03":
						month = 3;
						break;
					case "Apr":
						month = 4;
						break;
					case "04":
						month = 4;
						break;
					case "May":
						month = 5;
						break;
					case "05":
						month = 5;
						break;
					case "Jun":
						month = 6;
						break;
					case "06":
						month = 6;
						break;
					case "Jul":
						month = 7;
						break;
					case "07":
						month = 7;
						break;
					case "Aug":
						month = 8;
						break;
					case "08":
						month = 8;
						break;
					case "Sep":
						month = 9;
						break;
					case "09":
						month = 9;
						break;
					case "Oct":
						month = 10;
						break;
					case "10":
						month = 10;
						break;
					case "Nov":
						month = 11;
						break;
					case "11":
						month = 11;
						break;
					case "Dec":
						month = 12;
						break;
					case "12":
						month = 12;
						break;
	
				} 
			} 
			if (!splitting[0].equals("")){
				totalLuggage.add(new LuggageT(splitting[0], splitting[1], month, 
						splitting[2], splitting[3],
						splitting[4], splitting[5], splitting[6], splitting[7]));
			}
			count++;
		}
		
		
		//Close the input stream
		br.close();
		return totalLuggage;
	}
}