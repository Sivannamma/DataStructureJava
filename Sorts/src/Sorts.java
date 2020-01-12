
public class Sorts {

	public static void bubbleSort(int[] arr) { // bubble sort
		int temp;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) { // selection sort
		for (int i = 0; i < arr.length; i++) {
			int index = minIndex(arr, i);
			swap(arr, i, index);
		}
	}

	public static int minIndex(int[] arr, int i) { // min index of selection sort
		int ans = i;
		for (int k = i + 1; k < arr.length; k++) {
			if (arr[ans] > arr[k])
				ans = k;
		}
		return ans;
	}

	public static void swap(int[] arr, int i, int index) { // swap function of selection sort
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	public static int[] merge(int[] arr1, int[] arr2) { // merge
		// merging between two sorted arrays

		int[] arrBoth = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length) { // until one is over
			if (arr1[i] <= arr2[j])
				arrBoth[k++] = arr1[i++];

			else
				arrBoth[k++] = arr2[j++];
		}
		// if one array is over, we need to fill up the rest of the
		// other array into the merge array

		while (i < arr1.length)
			arrBoth[k++] = arr1[i++];

		while (j < arr2.length)
			arrBoth[k++] = arr1[j++];

		return arrBoth;
	}

	public static void mergeSort(int arr[]) { // merge sort
		mergeSort(arr, 0, arr.length);
	}

	public static void mergeSort(int arr[], int low, int high) { // merge sort

		if (low < high - 1) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);// a[low, mid)
			mergeSort(arr, mid, high);// a[mid, high)
			int n = high - low;
			int[] temp = new int[n];
			int i = low, j = mid, k = 0;

			// merge two arrays: arr[low, mid), arr[mid, high)
			// the regular merge in forms of mergeSort

			while (i < mid && j < high) {
				if (arr[j] < arr[i])
					temp[k++] = arr[j++];
				else
					temp[k++] = arr[i++];
			}
			while (i < mid)
				temp[k++] = arr[i++];
			while (j < high)
				temp[k++] = arr[j++];

			// retrieve temp to source array
			for (int p = 0; p < n; p++)
				arr[low + p] = temp[p];
		}
	}

	public static void quickSort(int[] arr) { // quickSort
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int low, int high) { // quickSort
		if (low <= high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) { // quickSort- partition

		int pivot = low++;
		while (low <= high) {
			if (arr[low] <= arr[pivot])
				low++;
			else if (arr[high] >= arr[pivot])
				high--;
			else
				swap(arr, high, low);
		}
		swap(arr, high, pivot);
		return high;
	}

	public static void countingSort(int[] arr) { // counting sort
		int min = arr[0];
		int max = arr[0];

		// finding min and max number in the array
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
			if (arr[i] > max)
				max = arr[i];
		}
		int range = max - min + 1; // to know the length oh the helper array
		int[] freq = new int[range];

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] - min;
			freq[index]++;
		}

		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i] + freq[i - 1];
		}

		int i = 0;
		for (int index = 0; index < freq.length; index++) {
			while (i < freq[index])
				arr[i++] = index;
		}
	}

	public static void radixSort(int[] arr) { // radix sort
		int n = arr.length;
		int exp = 1;
		int base = 10;
		int max = arr[0];
		int[] temp = new int[n];

		for (int i = 1; i < n; i++) { // finding max number
			if (arr[i] > max)
				max = arr[i];
		}
		while (max / exp > 0) {
			int[] B = new int[base];

			for (int i = 0; i < n; i++) {
				int index = (arr[i] / exp) % base;
				B[index]++;
			}
			for (int i = 1; i < B.length; i++) {
				B[i] = B[i - 1] + B[i];
			}
			for (int i = n - 1; i > 0; i--) {
				int index = (arr[i] / exp) % base;
				temp[--B[index]] = arr[i];
			}
			for (int i = 0; i < n; i++) {
				arr[i] = temp[i];
			}
			exp = exp * base;
		}
	}

	public static void main(String[] args) {

	}

}
