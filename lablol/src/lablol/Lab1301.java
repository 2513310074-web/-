package lablol;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lab1301 {

	public static void main(String[] args) {

		int[] nums = getData();
		/*
		 * System.out.print("\nResult of Bubble    Sort : ");
		 * Arrays.stream(bubbleSort(nums)).forEach(item -> System.out.print(item +
		 * " "));
		 * 
		 * System.out.print("\nResult of Selection Sort : ");
		 * Arrays.stream(selectionSort(nums)).forEach(item -> System.out.print(item +
		 * " "));
		 * 
		 * System.out.print("\nResult of Insertion Sort : ");
		 * Arrays.stream(insertionSort(nums)).forEach(item -> System.out.print(item +
		 * " "));
		 */
		System.out.print("\nResult of Quick     Sort : ");
		Arrays.stream(quickSort(nums)).forEach(item -> System.out.print(item + " "));
	}

	private static int[] getData() {
		BinaryTree tree = new BinaryTree();
		tree.createTree();
		tree.printTree(tree.getRoot(), 0);
		System.out.println("\nTraversal order: " + tree.traversal());

		int[] nums = new int[tree.traversal().size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = tree.traversal().get(i);
		}

		return nums;
	}

	/*
	 * public static int[] bubbleSort(int[] nums) { // write your code below
	 * 
	 * 
	 * return null; }
	 * 
	 * //public static int[] selectionSort(int[] nums) { // write your code below
	 * 
	 * 
	 * return null; }
	 * 
	 * public static int[] insertionSort(int[] nums) { // write your code below
	 * 
	 * 
	 * return null; }
	 */
/*	public static int[] quickSort(int[] nums) {
		// write your code below
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(nums.length - 1);
		stack.push(0);
		// stack ->[0,9]( top-> bottom)
		while (!stack.isEmpty()) {
			int low = stack.pop();// 0
			int high = stack.pop();// 1
			if (high - low < 1)
				continue;

			int j = partition(nums, low, high); // 0
			stack.push(high); // 1
			stack.push(j + 1); // 1
			stack.push(j); // 0
			stack.push(low); // 0
			// stack ->[1,1,2,3,4,5,6,9](top-> bottom)

		}

		return nums;
	}

	public static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (nums[i] < pivot) {
				i++;
			}
			while (nums[j] > pivot) {
				j--;
			}
			if (i >= j)
				break;
			int temp = nums[i]; // nums[i]-> nums.get(i)
			nums[i] = nums[j]; // nums.set(index , new_data;
			nums[j] = temp;
			i++;
			j--;
		}
		return j;
	}
}*/
	
	public static int[] quickSort(int[] nums) {
		// write your code below
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		stack.push(nums.length-1);
		stack.push(0);
		//stack -> [0,9] (top->bottom)
		
		while (!stack.isEmpty()) {
			int low = stack.pop();
			int high = stack.pop();
			
			if (high - low < 1) {
				continue;
			}
			
			int j = partition(nums, low, high);
			
			stack.push(high);
			stack.push(j+1);
			stack.push(j);
			stack.push(low);
		}
		
		return nums;
	}
	
	public static int partition (int[] nums, int low, int high) {
		int pivot = low;
		int i = low;
		int j = high;
		
		while (true) {
			while (nums[i] < nums[pivot]) {
				i++;
			}
			while (nums[j] > nums[pivot]) {
				j--;
			}
			if (i >= j)
				break;
			int temp = nums[i];  // nums[i] -> nums.get(i)
			nums[i] = nums[j];   // nums.set(index, new_data);
			nums[j] = temp;
			i++;
			j--;
		}
 
		return j;
	}
}