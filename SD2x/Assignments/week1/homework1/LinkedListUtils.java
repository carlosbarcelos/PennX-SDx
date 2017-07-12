package Assignments.week1.homework1;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	//insert a value into a sorted, non-descending linked list
	public static void insertSorted(LinkedList<Integer> list, int value) {
		if(list == null){
			return;
		}
		int length = list.size(); // length of the linked list
		if(length == 0){
			list.add(value);
			return;
		}
		int compareValue;
		for(int i = 0; i < length; i++){ //find the location to insert
			compareValue = list.get(i);
			if(compareValue > value){
				if(i == 0){ //add to front of list
					list.add(i, value);
					return;
				}
				list.add(i-1, value);
				return;
			}
		}
		//this value is the largest value to be added
		list.add(value);
		return;
	}


	public static void removeMaximumValues(LinkedList<String> list, int N) {
		if(list == null || N <= 0){
			return;
		}
		//find the maximum values
		String[] removeArray = new String[N];
		String temp;
		for(int i = 0; i < N; i++){
			removeArray[i] = "";
		}
		for(String s1 : list){
			if(isContained(removeArray, s1)){ //skip repeated strings
				continue;
			}
			if(s1.compareTo(removeArray[0]) > 0){
				removeArray[0] = s1;
				for(int i = 0; i < N-1; i++){
					if(removeArray[i].compareTo(removeArray[i+1]) > 0){
						temp = removeArray[i+1];
						removeArray[i+1] = removeArray[i];
						removeArray[i] = temp;
					}
				}
			}
		}
		//remove the maximum values
		for(String s : removeArray){
			list.removeIf(value -> value.equals(s));
		}
		return;
	}
	
	private static boolean isContained(String[] arr, String str){
		for(int i = 0; i < arr.length; i++){ //make sure the string is not already set to be removed
			if(arr[i].equals(str)){
				return true;
			}
		}
		return false;
	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		if(one == null || one.size() == 0 || two == null || two.size() == 0){
			return false;
		}
		if(one.size() < two.size()){ //not enough length to allow substring
			return false;
		}
		for(int i = 0; i < one.size(); i++){
			if((one.size() - i) < two.size()){ //not enough length to allow substring
				return false;
			}
			if(one.get(i) == two.getFirst()){
				for(int j = 0; j < two.size(); j++){
					if(one.get(i+j) == two.get(j) && j == two.size()-1){
						return true;
					}
				}
			}
		}
		return false;
	}
}
