
public class BinarySearch {
	public static int binarySearch(int[] arr, int val) { // Binary Search

		if (val < arr[0] || val > arr[arr.length - 1])
			return -1;
		int low = 0;
		int high = arr.length - 1;
		int mid = (low + high) / 2;

		for (int i = 0; i < arr.length; i++) {
			if (val == arr[mid])
				return mid;
			else if (val < arr[mid])
				high = mid - 1;
			else if (val > arr[mid])
				low = mid + 1;
			mid = (low + high) / 2;
		}
		return -1;
	}

	public static int binarySearchBetween(int[] arr, int val) { // Binary Search Between
		if (val < arr[0] || val > arr[arr.length - 1])
			return -1;

		int low = 0;
		int high = arr.length - 1;
		int mid = (low + high) / 2;

		for (int i = 0; i < arr.length; i++) {
			mid = (low + high) / 2;
			if (low == high)
				return low;
			else if (val == arr[mid])
				return mid;
			else if (val < arr[mid])
				high = mid;
			else if (val > arr[mid])
				low = mid + 1;
		}

		return mid;
	}
	public static void main(String[] args) {

	}

}
