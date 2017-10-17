package cas2xb3_finalprototype;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is used to create a Search object that can be performed binary search on 
 * when it is sorted using the Merge class. 
 * @author Group 11 - Software Engineering 2XB3. 
 *
 */
public class Search {
	

	/**
	 * Returns the index of the specified key in the specified array.
	 * @param a This is the ArrayList of 
	 * @param key This is the claim number that is to be searched for inside of the LuggageT 
	 * ArrayList.
	 * @return This is the index of the matching luggage. If it does not match, -1 will 
	 * be returned and accounted for inside of the program.
	 */
	public static int indexOf(ArrayList<LuggageT> a, String key) {
		int lo = 0;
		int hi = a.size() - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if      (key.compareTo(a.get(mid).getClaimNumber()) < 0) hi = mid - 1;
			else if (key.compareTo(a.get(mid).getClaimNumber()) > 0) lo = mid + 1;
			else return mid;
		}
		return -1;
	}

	

		/**
		 * This is used to perform binary search and use merge in order to pass into the searching algorithm.
		 * @param list This is the list of all lost luggages inside of the TSA data set. 
		 * @param claim This is the claim number to be searched for within the TSA data set. 
		 * @return This is the luggageT that is found for the perfect match to the claim number.
		 * @throws Exception This throws an exception if the object cannot be found. 
		 */
		public static LuggageT getLuggage(ArrayList<LuggageT> list, String claim) throws Exception{
			LuggageT luggage = null;
			Merge test = new Merge(list);
			test.sort();
			String claimNumber = claim;
			if(Search.indexOf(list, claim) == -1){
				luggage = null;
			}else{
			luggage = list.get(Search.indexOf(list, claim));
			}
			return luggage;

		}

	}



