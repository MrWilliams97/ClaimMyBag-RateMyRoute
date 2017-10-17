package cas2xb3_finalprototype;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * This sorts all of the luggages by claim numbers through ArrayLists.
 * It is defined by an object because it can be repeatedly used once sorted
 * and provides a separation in case if the old ArrayList of unsorted objects is
 * needed. 
 * @author Group 11 - Software Engineering 2XB3
 *
 */
public class Merge {
 
    private ArrayList<LuggageT> strList;
 
    /**
     * This is the constructor for the Merge object.
     * @param input The ArrayList to be sorted.
     */
    public Merge(ArrayList<LuggageT> input) {
        strList = input;
    }
     
    /**
     * This determines when the object's ArrayList needs to be sorted. 
     */
    public void sort() {
        strList = mergeSort(strList);
    }
 
    /**
     * This is the merge sort implementation regarding ArrayLists.
     * @param whole This is the whole LuggageT array list from
     * the TSA data set.
     * @return Returns the sorted array list.
     */
    public ArrayList<LuggageT> mergeSort(ArrayList<LuggageT> whole) {
        ArrayList<LuggageT> left = new ArrayList<LuggageT>();
        ArrayList<LuggageT> right = new ArrayList<LuggageT>();
        int center;
 
        if (whole.size() == 1) {    
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(whole.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                    right.add(whole.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }
 
    /**
     * This merges two sub array lists into one.
     * @param left A left subarray
     * @param right A right subarray.
     * @param whole The whole dataset. 
     */
    private void merge(ArrayList<LuggageT> left, ArrayList<LuggageT> right, ArrayList<LuggageT> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).getClaimNumber().compareTo(right.get(rightIndex).getClaimNumber())) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<LuggageT> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
 
    /**
     * This shows all of the contents of the Merge object's array list. 
     */
    public void show() {
        System.out.println("Sorted:");
        for (int i=0; i< strList.size();i++) {
            System.out.println(strList.get(i));
        }
    }
 
   
}