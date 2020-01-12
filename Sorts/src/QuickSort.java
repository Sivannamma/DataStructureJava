import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);

		}
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = low++;
		while (low <= high) {
			if (arr[low] <= arr[pivot])
				low++;
			else if (arr[high] >= arr[pivot])
				high--;
			else
				swap(arr, low, high);
		}
		swap(arr, pivot, high);
		return high;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 2, 8, 3, 7, 4, 31, 6, 10, 28, 49 };
		System.out.println("before sorting the array: " + Arrays.toString(arr));
		quickSort(arr);
		System.out.println("after sorting the array: " + Arrays.toString(arr));

	}

}
