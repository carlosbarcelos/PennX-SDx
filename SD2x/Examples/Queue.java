package Examples;

import java.util.LinkedList;

public class Queue {

	protected LinkedList list = new LinkedList();
	
	public void add(Object value){
		list.add(value); // adds to the end
	}
	
	public Object remove(){
		if(list.isEmpty()){
			return null;
		}
		return list.removeFirst(); // removes from the front
	}
	
	public Object peek(){
		return list.getFirst();
	}
}
