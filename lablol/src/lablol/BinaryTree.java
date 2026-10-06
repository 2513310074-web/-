package lablol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

class Node {
	int	 data;
	Node left, right;
	
	public Node (int new_data) {
		data  = new_data;
		left  = null;
		right = null;
	}
}

public class BinaryTree {
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	public Node getRoot() {
		return root;
	}
	public void createTree() {
		root = new Node(47);
		
		root.left = new Node(82);
		root.left.left = new Node(9);
		root.left.right = new Node(63);
		root.left.left.left = new Node(54);
		root.left.left.right = new Node(3);
		
		root.right = new Node(15);
		root.right.left = new Node(71);
		root.right.right = new Node(28);
		root.right.left.right = new Node(88);
		root.right.right.left = new Node(5);
	}
	public void printTree(Node node, int depth) {
		if(node != null) {
			printTree(node.right, depth+1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth+1);
		}
	}
	
	public ArrayList<Integer> traversal() {
		//
      /*  Deque<Node> stack = new ArrayDeque<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Node current = root ; 
        
        while (current != null || !stack.isEmpty()){
        	while (current != null) {
        		stack.push(current);
        		current = current.left;
        	current = stack.pop();
        	
        	list.add(current.data);
        	current = current.right;
        	}
        	
        	Deque<Node> stack = new ArrayDeque<Node>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            
        */
		//preorder
		/*Deque<Node> stack = new ArrayDeque<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	Node current = stack.pop();
        	if (current.right != null)
        		stack.push(current.right);
        	if(current.left != null)
        		stack.push(current.left);
        }
		*/
		//postrder
		/*Deque<Node> stack = new ArrayDeque<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	Node current =stack.pop();
        	list.addFirst(current.data);
        	if (current.left != null)
        		stack.push(current.left);
        	if (current.right != null)
        		stack.push(current.right); 
	//
	
        
        }*/
        //level - order
		Queue<Node> queue = new ArrayDeque<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
        	int levelSize = queue.size();
        	for (int i=1; i <=levelSize; i++) {
        		Node current = queue.poll();
        		list.add(current.data);
        		
        		if(current.left != null)
        		  queue.add(current.left);
        		if(current.right!= null)
        			queue.add(current.right);
        		
        	}
        }
		
		
		return list;
	}
	
}



