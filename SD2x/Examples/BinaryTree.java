package Examples;

public class BinaryTree {
	
	class Node{
		int value;
		Node leftChild = null;
		Node rightChild = null;
		Node(int value){
			this.value = value;
		}
	}

	protected Node root = null;
	
	//Return the nodes in the tree in order
	public void inorderTraversal(Node n){
		if(n == null) return;
		inorderTraversal(n.leftChild);
		visit(n);
		inorderTraversal(n.rightChild);
	}
	
	public void visit(Node n){
		System.out.println(n.value);
	}
	
	//Return whether the value exists in the tree starting at node n
	public boolean binaryTreeSearch(Node n, int val){
		if(n == null) return false;
		
		if(n.value == val){
			return true;
		} else if(n.value > val){
			return binaryTreeSearch(n.leftChild, val);
		} else{
			return binaryTreeSearch(n.leftChild, val);
		}
	}
	
	//Add a value to the tree starting at node n
	public boolean add(Node n, int val){
		if(n.value == val){
			return false;
		} else if(n.value > val){
			if(n.leftChild == null){
				n.leftChild = new Node(val);
				return true;
			} else{
				return add(n.leftChild, val);
			}
		} else{
			if(n.rightChild == null){
				n.rightChild = new Node(val);
				return true;
			} else{
				return add(n.rightChild, val);
			}
		}
	}
	
	//Remove a value from the tree starting at node n
	public boolean remove(Node n, Node parent, int val){
		if(n == null) return false;
		
		if(val < n.value){
			return remove(n.leftChild, n, val);
		} else if(val > n.value){
			return remove(n.rightChild, n, val);
		} else{
			if(n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if(parent.leftChild == n){
				parent.leftChild = n.leftChild ? n.leftChild : n.rightChild;
			} else{
				parent.rightChild = n.leftChild ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}
}