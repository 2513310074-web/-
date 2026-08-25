package lab08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TraverseInorder {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Inorder = " + traversal(tree.getRoot()));
	}
	
	public static ArrayList<Integer> traversal(Node node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Node> stack = new ArrayDeque<Node>();
		Node current = node;

        while (current != null || !stack.isEmpty()) {

            // เดินไปทางซ้ายสุด
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // เอา Node ออกจาก Stack
            current = stack.pop();

            // เก็บค่าลงใน List
            list.add(current.data);

            // ไปทางขวา
            current = current.right;
        }

        return list;
    }

}