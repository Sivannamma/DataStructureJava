import java.util.Arrays;

public class MaxHeapMain {

	public static void main(String[] args) {
		int[] heap1 = { 1, 9, 3, 8, 6, 2, 7, 5, 31, 4, 11, 18, 16, 20 };
		System.out.println("before making it a max heap: " + Arrays.toString(heap1));

		MaxHeap s = new MaxHeap(heap1);
		System.out.println("making s to be maxHeap using heap1: " + s.toString());
		System.out.println("is it max heap? " + s.isMaxHeap(heap1)); // Suppose to return false, heap1 is yet to be heap
		System.out.println("is it max heap? " + s.isMaxHeap(s.heap)); // Suppose to return true, because we did build
																		// max heap

		s.heapSort(s.heap);
		System.out.println("using heap sort: " + s.toString());
	}

}
