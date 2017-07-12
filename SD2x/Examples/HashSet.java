package Examples;

import java.util.LinkedList;

public class HashSet {

	private LinkedList<String>[] buckets;
	private int currentSize = 0;
	private double loadFactor; //value above which the buckets will resize
	
	public HashSet(int size){
		buckets = new LinkedList[size];
		for(int i = 0; i < size; i++){
			buckets[i] = new LinkedList<String>();
		}
	}
	
	//a (overly) simple hashing algorithm
	private int hashCode(String value){
		return value.length();
	}
	
	public boolean add(String value){
		if(!contains(value)){
			int index = hashCode(value) % buckets.length;
			LinkedList<String> bucket = buckets[index];
			bucket.addFirst(value);
			currentSize++;
			
			double averageLoad = currentSize/(double)buckets.length;
			if(averageLoad > loadFactor){
				reinsertAll();
			}
			return true;
		}
		return false;
	}
	
	private void reinsertAll(){
		LinkedList<String> oldBuckets[] = buckets;
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new LinkedList<String>();
		}
		buckets = new LinkedList[buckets.length * 2];
		
		for(LinkedList<String> bucket : oldBuckets){
			for(String element : bucket){
				int index = hashCode(element) % buckets.length;
				LinkedList<String> newBucket = buckets[index];
				newBucket.addFirst(element);
			}
		}
	}
	
	public boolean contains(String value){
		int index = hashCode(value) % buckets.length;
		LinkedList<String> bucket = buckets[index];
		return bucket.contains(value);
	}
}
