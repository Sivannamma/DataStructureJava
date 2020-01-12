import java.util.HashMap;
import java.util.LinkedList;

class BTNode {
	int data;
	BTNode left;
	BTNode right;

	public BTNode(int data) {
		this.data = data;
		left = right = null;
	}

	public String toString() {
		return "" + data;
	}
}

public class Ex3 {

	public static void isHeap(int[] arr) {
		if (isMinHeap(arr))
			System.out.println("Min heap");
		else if (isMaxHeap(arr))
			System.out.println("Max heap");
		else
			System.out.println("Is not a heap");
	}

	public static boolean isMinHeap(int[] arr) {
		for (int parent = 0; parent < (arr.length - 1) / 2; parent++) {
			int leftChild = parent * 2 + 1;
			int rightChild = parent * 2 + 1;
			if (leftChild < arr.length && arr[parent] > arr[leftChild]) // checking left child
				return false;
			if (rightChild < arr.length && arr[parent] > arr[rightChild]) // checking right child
				return false;
		}
		return true; // means all our checks was good, and it is a min heap
	}

	public static boolean isMaxHeap(int[] arr) {
		for (int parent = 0; parent < (arr.length - 1) / 2; parent++) {
			int leftChild = parent * 2 + 1;
			int rightChild = parent * 2 + 1;
			if (leftChild < arr.length && arr[parent] < arr[leftChild]) // checking left child
				return false;
			if (rightChild < arr.length && arr[parent] < arr[rightChild]) // checking right child
				return false;
		}

		return true; // means all our checks was good, and it is a max heap
	}

	public static void report(String[] sArr) {

		// variable to save the longest word
		String maxLengthWord = sArr[0];
		int maxLength = sArr[0].length();

		// variables to save the most appeared word
		String mostRepeated = sArr[0];
		int maxRepeated = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < sArr.length; i++) {

			if (sArr[i].length() > maxLength) { // checking the longest word
				maxLength = sArr[i].length();
				maxLengthWord = sArr[i];
			}

			if (map.containsKey(sArr[i]))
				map.put(sArr[i], map.get(sArr[i]) + 1);
			else
				map.put(sArr[i], 1);
		}

		for (String i : map.keySet()) { // checking for the most appeared word
			if (maxRepeated < map.get(i)) {
				maxRepeated = map.get(i);
				mostRepeated = i;
			}
		}

		System.out.println("The amount of total words is: " + sArr.length);
		System.out.println("The amount of diffrent words is: " + map.size());
		System.out.println("The most repeated word is: " + mostRepeated + " and it appeared " + maxRepeated + " times");
		System.out.println("The word that is the longest is: " + maxLengthWord);

	}

	public static boolean isBST(BTNode tree) {
		LinkedList<Integer> link = new LinkedList<Integer>();
		inOrder(tree, link); // placing the values in inOrder style, if not sorted- false;

		for (int i = 1; i < link.size(); i++) { // checking if the array is sorted
			if (link.get(i - 1) > link.get(i))
				return false;
		}

		return true;
	}

	private static void inOrder(BTNode current, LinkedList<Integer> link) {
		if (current != null) {
			inOrder(current.left, link);
			link.add(current.data); // linking all the values to a linked list
			inOrder(current.right, link);
		}
	}

	public static int island(int[][] arr) {
		boolean[][] steps = new boolean[arr.length][arr[0].length];
		// defining the neighbors to go over the matrix
		int[][] neighbors = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) { // loop to go all over the matrix
			for (int j = 0; j < arr[0].length; j++) {
				// if the current step isn't 1, means we ardent starting an island, no reason to
				// go in
				// if the spot is true, means we visited there and already counted it
				if (arr[i][j] == 1 && steps[i][j] == false)
					sum += findIsland(arr, steps, neighbors, i, j);
			}
		}
		return sum;
	}

	public static int findIsland(int[][] arr, boolean[][] steps, int[][] neighbors, int row, int column) {
		if (row < 0 || row >= arr.length || column < 0 || column >= arr[0].length) // not to get index out of boundries
			return 1;
		if (arr[row][column] == 0 || steps[row][column] == true) // if we reached a place we cant continue
			return 1;

		for (int index = 0; index < neighbors.length; index++) { // loop to go all over the neighbors
			int x = row + neighbors[index][0];
			int y = column + neighbors[index][1];
			steps[row][column] = true;
			findIsland(arr, steps, neighbors, x, y);
		}
		return 1;
	}

	public static void main(String[] args) {

		// third question :
		int[] heapMin = { 2, 4, 3, 6, 12, 8, 5, 7, 10, 13 };
		int[] notHeap = { 8, 4, 2, 6, 12, 3, 5, 7, 10, 13 };
		int[] heapMax = { 20, 19, 18, 15, 14, 8, 6, 9, 4, 3 };
		isHeap(heapMin); // suppose to print Min heap
		isHeap(notHeap); // suppose to print is not a heap
		isHeap(heapMax); // suppose to print Max heap

		// fifth question
		String[] words = { "Sivan", "Shai", "Hen", "Ben", "Mom", "Milkey", "Mom", "Mom" };
		report(words);

		// second question part 2
		BTNode tree = new BTNode(80);
		tree.left = new BTNode(70);
		tree.right = new BTNode(100);

		System.out.println(isBST(tree));

		// forth question
		int[][] island = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0 },
				{ 1, 1, 1, 1, 0 } };
		System.out.println(island(island));

	}

}
