
import java.util.LinkedList;

public class Ex2 {
	public static int printWords(String A[][]) {
		String word = "";
		int sumW = 0; // sums up the words i found in the matrix
		LinkedList<String> s1 = new LinkedList<String>(); // linked list to save up the words i found

		int[][] neighbors = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // matrix that helps to go over the neighbors
																			// to every char

		boolean[][] help = new boolean[A.length][A[0].length]; // boolean arrays that shows me if i step in a path
																// before
		for (int row = 0; row < A.length; row++) {
			for (int column = 0; column < A[0].length; column++) {
				sumW = printWords(A, help, row, column, word, s1, sumW, neighbors);
			}
		}
//		System.out.println(count);
		return sumW;
	}

	private static int printWords(String[][] A, boolean[][] help, int row, int column, String str,
			LinkedList<String> s1, int sumW, int[][] neighbors) {
		if (row < A.length && row >= 0 && column < A.length && column >= 0 && help[row][column] == false) {
			if (isWord(str)) {
				if (!s1.contains(str)) {
					s1.add(str);
					System.out.println(str);
					sumW++;
				}
			}

			for (int index = 0; index < neighbors.length; index++) {
				int x = row + neighbors[index][0];
				int y = column + neighbors[index][1];
				help[row][column] = true;
				printWords(A, help, x, y, str + A[row][column], s1, sumW, neighbors);
				help[row][column] = false;
			}
		}
		return s1.size();
	}

	static boolean isWord(String s) {
		return (s.equals("BFJIOPLKGHDC") | s.equals("BFJIOPLKGHD") | s.equals("BFJIEFG") | s.equals("AEFB")
				| s.equals("DC") | s.equals("MI"));
	}

//	private static boolean isWord(String s) {
//		return (s.equals("CAT") | s.equals("CATS") | s.equals("TRAM") | s.equals("TRAMS") | s.equals("TAME")
//				| s.equals("CAR") | s.equals("CARS") | s.equals("RAT") | s.equals("RATS") | s.equals("RAMP")
//				| s.equals("ART") | s.equals("CART") | s.equals("STAMP") | s.equals("TAKEN") | s.equals("MEN")
//				| s.equals("MAKE") | s.equals("TAKE") | s.equals("ATE") | s.equals("SELL") | s.equals("STEEL")
//				| s.equals("RAKE"));
//	}

	public static double middle(LinkedListSingle list) {
		NodeL start = list.head;

		for (NodeL jump = list.head; jump != null && jump.next != null; jump = jump.next.next) {
			NodeL jumpHelp = jump.next;

			if (jumpHelp == null)
				return start.next.data;

			if (jumpHelp.next == null)
				return start.data;

			start = start.next;
		}
		return start.data;
	}

	public static int sqrt3(int n) {

		long high = n;
		long low = 0;
		long mid = (low + high) / 2;
		boolean binaryNext = true;

		while (binaryNext) {
			if (low + 1 == high) {

				if (low * low * low < n & high * high * high < n) // if both are lower than n, return high because its
																	// the closes
					return (int) high;

				if (low * low * low < n & high * high * high > n) // if low^3 <n and high passes it, return low
					return (int) low;
				// the other case does not matter because no way high^3 will be lower than low^3
				// so
				// we cover that case
			}
			mid = (low + high) / 2; // like binary search, minimize the the length of search
			if (mid * mid * mid == n)
				return (int) mid;
			if (mid * mid * mid > n)
				high = mid;
			else if (mid * mid * mid < n)
				low = mid;
		}
		return (int) mid;
	}

	public static void main(String[] args) {

		// question 2:
		smartStack s1 = new smartStack();
		s1.push(1);
		s1.push(5);
		s1.push(8);
		s1.push(5);
		s1.push(6);
		s1.push(8);
		s1.push(7);
		s1.push(2);

		System.out.println(s1.size);
		System.out.println(s1);
		System.out.println(s1);

		// question 3:
		int n = 100000;
		System.out.println(sqrt3(n));

		// question 4:
		LinkedListSingle l1 = new LinkedListSingle();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.add(7);

		System.out.println(middle(l1));

		// question 1:
//		String[][] A = { { "C", "A", "R", "T" }, { "E", "T", "A", "K" }, { "E", "S", "M", "E" },
//				{ "L", "L", "P", "N" } };

		String[][] A = { { "A", "B", "C", "D" }, { "E", "F", "G", "H" }, { "I", "J", "K", "L" },
				{ "M", "I", "O", "P" } };

		System.out.println(printWords(A));

	}

}
