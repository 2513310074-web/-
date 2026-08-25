package lab08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TraversePreorder {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Preorder = " + traversal(tree.getRoot()));
	}

	public static ArrayList<Integer> traversal(Node node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> stack = new ArrayDeque<Node>();
		if (node == null) {
	        return list;
	    }

	    stack.push(node);

	    while (!stack.isEmpty()) {
	        Node current = stack.pop();

	        // เก็บค่าก่อน = Preorder
	        list.add(current.data);

	        // ใส่ขวาก่อน
	        if (current.right != null) {
	            stack.push(current.right);
	        }

	        // ใส่ซ้ายทีหลัง เพื่อให้ซ้ายถูก pop ก่อน
	        if (current.left != null) {
	            stack.push(current.left);
	        }
	    }

	    return list;
	}
}