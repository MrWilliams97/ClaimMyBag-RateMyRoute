package cas2xb3_finalprototype;

/**
 * The purpose of this module is to create LuggageT
 * objects that are defined by parameters that pertain to the claims data set 
 * provided by the U.S. open TSA data set. There are also setters and getters
 * to potentially change information if needed in future iterations of the 
 * project that could be possible. 
 * @author Group 11 - Software Engineering 2XB3. 
 *
 */
public class LuggageT {
	private String claimNumber;
	private String receivalDate;
	private int receivalMonth;
	private String incidentDate;
	private String airportCode;
	private String knownAirportName;
	private String airlineName;
	private String claimType;
	private String claimSite;
	
	public LuggageT(String claimNumber, String receivalDate, int receivalMonth,
			String incidentDate, String airportCode, String airportName, 
			String airlineName, String claimType, String claimSite){
		/*
		 * This sets all of the possible state variables to an empty String. 
		 */
		this.claimNumber = claimNumber;
		this.receivalDate = receivalDate;
		this.receivalMonth = receivalMonth;
		this.incidentDate = incidentDate;
		this.airportCode = airportCode;
		this.knownAirportName = airportName;
		this.airlineName = airlineName;
		this.claimType = claimType;
		this.claimSite = claimSite;

	}
	
	/**
	 * This sets the claim number to a new value.
	 * @param claimNumber The new claim number to define the LuggageT object. 
	 */
	public void setClaimNumber(String claimNumber){
		this.claimNumber = "";
		this.claimNumber += claimNumber;
	}
	
	/**
	 * This sets the receival date of the LuggageT object.
	 * @param receivalDate The new receival data to define the LuggageT object. 
	 */
	public void setReceivalDate(String receivalDate){
		this.receivalDate = "";
		this.receivalDate += receivalDate;
	}
	
	/**
	 * This sets the receival month of the LuggageT object. 
	 * @param receivalMonth The new receival month to define the LuggageT object.
	 */
	public void setReceivalMonth(int receivalMonth){
		this.receivalMonth = receivalMonth;
	}
	
	/**
	 * This sets the incident date of the LuggageT object. 
	 * @param incidentDate The new incident date to be set by the LuggageT object. 
	 */
	public void setIncidentDate(String incidentDate){
		this.incidentDate = "";
		this.incidentDate += incidentDate;
	}
	
	/**
	 * This sets the airport code for a LuggageT object.
	 * @param airportCode The new airport code that sets the LuggageT object.
	 */
	public void setAirportCode(String airportCode){
		this.airportCode = "";
		this.airportCode += airportCode;
	}
	
	/**
	 * This sets the airport name for a LuggageT object.
	 * @param airportName The new airport name that defines the LuggageT object. 
	 */
	public void setKnownAirportName(String airportName){
		this.knownAirportName = "";
		this.knownAirportName += knownAirportName;
	}
	
	/**
	 * This sets the airline name of a LuggageT object. 
	 * @param airlineName The new defined airline name that defines the LuggageT object. 
	 */
	public void setAirlineName(String airlineName){
		this.airlineName = "";
		this.airlineName += airlineName;
	}
	
	/**
	 * This sets the claim type for a LuggageT object. 
	 * @param claimType The new defined claim type that defines the LuggageT object. 
	 */
	public void setClaimType(String claimType){
		this.claimType = "";
		this.claimType += claimType;
	}
	
	/**
	 * This sets the claim site for a LuggageT object. 
	 * @param claimSite This is the new claim site that defines the LuggageT object. 
	 */
	public void setClaimSite(String claimSite){
		this.claimSite = "";
		this.claimSite = claimSite;
	}
	
	/**
	 * This is a getter for the claim number of the LuggageT object.
	 * @return Returns the claim number of the LuggageT object. 
	 */
	public String getClaimNumber(){
		return this.claimNumber;
	}
	
	/**
	 * This is a getter method for the receival date of the LuggageT object. 
	 * @return Returns the object's receival date defined by the TSA data set. 
	 */
	public String getReceivalDate(){
		return this.receivalDate;
	}
	
	/**
	 * This returns the receival month of the LuggageT object in the form of an integer.
	 * @return The month of receival for the LuggageT object. 
	 */
	public int getReceivalMonth(){
		return this.receivalMonth;
	}
	
	/**
	 * This returns the incident date of the customer going to the desk for the luggage object in question.
	 * @return The incident date is provided in String format. 
	 */
	public String getIncidentDate(){
		return this.incidentDate;
	}
	
	/**
	 * This returns the airport code of the LuggageT object that should be 3 digits.
	 * @return The airport code of the airport that contains the lost luggage. 
	 */
	public String getAirportCode(){
		return this.airportCode;
	}
	
	/**
	 * This returns the known airport name of the object in question.
	 * @return The airport name where the lost luggage was found. 
	 */
	public String getKnownAirportName(){
		return this.knownAirportName;
	}
	
	/**
	 * This returns the associated airline that pertains to the lost luggage that was found or not.
	 * @return This is the airline name found.
	 */
	public String getAirlineName(){
		return this.airlineName;
	}
	
	/**
	 * This returns the claim type that pertains to the lost luggage that was found.
	 * Can be used for future analytics if needed.
	 * @return This returns the claim type by String.
	 */
	public String getClaimType(){
		return this.claimType;
	}
	
	/**
	 * This returns the claim site of the lost luggage. 
	 * @return This returns the String value of the claim site for the lost luggage.
	 */
	public String getClaimSite(){
		return this.claimSite;
	}
	
	/**
	 * This returns an integer depending on the claim numbers that are provided. 
	 * This is used for the merge sort algorithm to find the location of lost luggage.
	 * @param claimNumberOne The first object's claim number
	 * @param claimNumberTwo The second objet's claim number. 
	 * @return Returns an integer depending on which one is greater. 
	 */
	public int compareTo(String claimNumberOne, String claimNumberTwo){
		return claimNumberOne.compareTo(claimNumberTwo);
	}
}
