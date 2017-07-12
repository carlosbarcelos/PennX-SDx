package Examples;

public class LinkedList {

	class Node{
		int value;
		Node next = null;
		Node (int value) {
			this.value = value;
		}
	}

	protected Node head = null;
	protected Node tail = null;

	//add to the front of the linked list
	public void addToFront(int value){
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		//what if this is the only node in the linked list
		if(newNode.next == null){
			tail = newNode;
		}
	}

	//add to the end of the linked list
	public void addToBack(int value){
		Node newNode = new Node(value);
		tail.next = newNode;
		//what if this is the only node in the linked list
		if(tail == null){
			head = newNode;
		} else{
			tail.next = newNode;
		}
		tail = newNode;
	}

	//add to a certain index of the linked list
	public void addAtIndex(int index, int value){
		//what if index<0
		if(index < 0){
			throw new IndexOutOfBoundsException();
		} else if(index == 0){ //adding to head
			addToFront(value);
		} else{
			Node newNode = new Node(value);
			Node current = head;
			//walk along linked list to find index location
			for(int i=0; i<index-1; i++){
				if(current == null){
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			if(current.next == null){ //adding to tail
				tail = newNode;
			} else{
				newNode.next = current.next;
				current.next = newNode;
			}
		}
	}

	//return weather or not this linked list contains some value
	public boolean contains(int value){
		Node current = head;
		while(current != null){
			if(current.value == value){
				return true;
			}
			current = current.next;
		}
		return false;
	}

	//return a value based on the index in the linked list
	public int getByIndex(int index){
		if(index < 0){
			throw new IndexOutOfBoundsException();
		} else{
			Node current = head;
			for(int i = 0; i < index; i++){
				if(current == null || current.next ==null){
					throw new IndexOutOfBoundsException();
				}
			}
			return current.value;
		}
	}

	//remove the element at the front of the linked list
	public void removeFromFront(){
		if(head != null){
			head = head.next;
		}
		if(head == null){
			tail = null;
		}
	}
	
	//remove the element at the end of the linked list
	public void removeFromBack(){
		if(head == tail){ //empty list
			return;
		} else if(head.equals(tail)){ //single element list

		} else{
			Node current = head;
			while(current.next != tail){
				current = current.next;
			}
			tail = current;
			current.next = null;
		}
	}
	
	//remove the element at a certain index in the linked list
	public void removeAtIndex(int index){
		if(index < 0){
			throw new IndexOutOfBoundsException();
		} else if(index == 0){
			removeFromFront();
		} else{
			Node current = head;
			for(int i = 0; i < index-1; i++){
				if(current == null || current.next == null){
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			current.next = current.next.next;
			if(current.next == null){
				tail = current;
			}
		}
	}
}
