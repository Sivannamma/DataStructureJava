
public class Ex1 {

	public static void insertionSort(double[] arr) {
		for (int i = 1; i < arr.length; i++) {
			double key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
				arr[j + 1] = key;
			}
		}
	}

	public static void improvedInsertionSort(double[] arr) {
		for (int i = 1; i < arr.length; i++) {
			// Save the new value before shifting
			double newVal = arr[i];
			// Find where to insert the new value
			int insIndex = insertionIndex(arr, 0, i - 1, newVal);
			shiftRight(arr, insIndex, i);
			arr[insIndex] = newVal;
		}
	}

	public static void shiftRight(double[] arr, int p, int q) {
		for (int i = q; i > p; i--)
			arr[i] = arr[i - 1];
	}
	// int insIndex = insertionIndex(arr, 0, i-1, newVal);

	public static int insertionIndex(double[] arr, int p, int q, double key) {

		if (key > arr[q])
			return q + 1;

		if (key < arr[0])
			return 0;

		int mid = (p + q) / 2;
		for (int i = 0; i < q + 1; i++) {
			mid = (p + q) / 2;
			if (p == q)
				return p;
			else if (key == arr[mid])
				return mid;
			else if (key < arr[mid]) {
				q = mid;
				mid = q;
			} else if (key > arr[mid]) {
				p = mid + 1;
				mid = p;
			}
		}
		return mid;
	}

	public static void main(String[] args) {
		double[] arr = { 1, 2, 6, 8, 5 };
		improvedInsertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");

		}

	}

}
