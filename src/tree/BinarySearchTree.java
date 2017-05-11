package tree;

public class BinarySearchTree {
	Node node;
	
	BinarySearchTree(){
		node=null;
	}
	
	void insertTree(int value){
		node = insertBinarySearchTree(node, value);
	}
	
	Node insertBinarySearchTree(Node node,int value){
		if(node==null){
			node = new Node(value);
		}
		if(node.value>value){
			node.left = insertBinarySearchTree(node.left,value);
		}
		if(node.value<value){
			node.right = insertBinarySearchTree(node.right,value);
		}
		return node;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		binarySearchTree.insertTree(3);
		binarySearchTree.insertTree(2);
		binarySearchTree.insertTree(1);
		binarySearchTree.insertTree(4);
		binarySearchTree.insertTree(5);
		

	}

}

class Node{
	int value;
	Node left;
	Node right;
	Node(int value){
		this.value = value;
		left=right=null;
	}
	
}


class DLL{
	int key;
	DLL left;
	DLL right;
	DLL(int val){
		this.key=val;
		left=right=null;
	}
	
}