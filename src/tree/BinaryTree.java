package tree;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.logging.Level;

public class BinaryTree {
	
	Node node;
	int count=0;
	int hight=0;
	int maxWidth=0;
	
	int  levelOrderTraversal(int k){
		if(node==null){
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		//count=1;
		System.out.println(node.value);
		while(!queue.isEmpty()){
			
			Node tempNode = queue.poll();
			/*if(count==k && tempNode!=null)
				System.out.println(tempNode.value);*/
			if(tempNode!=null){
				if(tempNode.left!=null){
					queue.add(tempNode.left);
				}
				if(tempNode.right!=null){
					queue.add(tempNode.right);
				}
			}else if(tempNode==null && !queue.isEmpty()){
				/*if(queue.size()>maxWidth)
				maxWidth = queue.size();*/
				System.out.println(queue.peek().value);
				queue.add(null);
				count++;
			}
		}
		
		return count;
	}
	
	void verticalSumInorder(){
		if(node==null){
			return ;
		}
		Map<Integer, Integer> verticalsum = new TreeMap<>();
		Map<Integer, ArrayList<Integer>> bottomView = new TreeMap<>();
		verticalSum(verticalsum,0,node);
		printVerticalSum(verticalsum);
		System.out.println(" ");
		bottomView(bottomView, 0, node);
		printBottomView(bottomView);
	}
	
	void printVerticalSum(Map<Integer, Integer> verticalsum){
		for(Map.Entry<Integer, Integer> mapValue:verticalsum.entrySet()){
			System.out.println(mapValue.getValue()+" "+mapValue.getKey());
		}
		
	}
	
	void printBottomView(Map<Integer, ArrayList<Integer>> verticalsum){
		for(Map.Entry<Integer, ArrayList<Integer>> mapValue:verticalsum.entrySet()){
			System.out.print(mapValue.getKey() +" "+mapValue.getValue().get(mapValue.getValue().size()-1));
			
		}
		
	}
	
	void  verticalSum(Map<Integer,Integer> verticalsum,int hd,Node node){
		if(node==null){
			return;
		}
		verticalSum(verticalsum,hd-1,node.left);
		int prevSum = (verticalsum.get(hd)==null)?0:verticalsum.get(hd);
		verticalsum.put(hd, node.value+prevSum);
		verticalSum(verticalsum, hd+1, node.right);
	}
	
	
	void bottomView(Map<Integer,ArrayList<Integer>> verticalsum,int hd,Node node){
		if(node==null){
			return;
		}
		bottomView(verticalsum, hd-1, node.left);
		ArrayList<Integer> list =  (verticalsum.get(hd)==null)?new ArrayList<Integer>():verticalsum.get(hd);
		list.add(node.value);
		verticalsum.put(hd, list);
		bottomView(verticalsum, hd+1, node.right);
	}
	
	
	int heightBinaryTree(Node node){
		if(node==null){
			return 0;
		}
		return Math.max(heightBinaryTree(node.left), heightBinaryTree(node.right))+1;
		
		
	}
	
	boolean  Ancesstor(Node node){
		if(node==null){
			return false; 
		}
		
		if(Ancesstor(node.left)||Ancesstor(node.right)){
			System.out.println(node.value);
		}
		
		return true;
	}
	
	public static void main(String[] args){
		BinaryTree tempTree = new BinaryTree();
		tempTree.node = new Node(1);
		tempTree.node.left = new Node(2);
		tempTree.node.left.right = new Node(3);
		tempTree.node.left.left = new Node(4);
		tempTree.node.left.left.right = new Node(5);
		//System.out.println(tempTree.levelOrderTraversal(3));
		//System.out.println(tempTree.heightBinaryTree(tempTree.node));
		//tempTree.Ancesstor(tempTree.node.left.left);
		//tempTree.levelOrderTraversal(1);
		tempTree.verticalSumInorder();
		
	}
	
	
	
	
	
}






