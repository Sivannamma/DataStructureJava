
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class practice {

	public static int complement(int n) {
		return complement(n, 0, 0);
	}

	public static int complement(int n, int sum, int i) {
		if (n == 0)
			return sum;
		sum += (9 - n % 10) * Math.pow(10, i);
		i++;
		n = n / 10;
		return complement(n, sum, i);
	}

	public static void deleteDuplicates(LinkedList<Character> list) {
		HashSet<Character> s = new HashSet<Character>();

		for (int i = 0; i < list.size(); i++) {
			if (!s.contains(list.get(i)))
				s.add(list.get(i));
			else {
				list.remove(i);
				i--;
			}

		}
	}

	public static int findUniMax(int[] arr, int low, int high) {
		if (low == high)
			return low;
		int mid = (low + high) / 2;
		if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid])
			return arr[mid];
		else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])
			return findUniMax(arr, mid, high);
		else // (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1])
			return findUniMax(arr, low, mid);

	}

	public static void sort(Queue<Integer> q) {
		Stack<Integer> temp = new Stack<Integer>();
		temp.add(q.poll());
		while (!q.isEmpty()) {
			int save = q.poll();

			while (!temp.isEmpty() && save > temp.peek())
				q.add(temp.pop());

			temp.add(save);
		}

		while (!temp.isEmpty()) {
			q.add(temp.pop());
		}

	}

	public static void reverse(Stack<Integer> t) {
		Queue<Integer> q = new LinkedList<Integer>();
		while (!t.isEmpty()) {
			q.add(t.pop());
		}
		while (!q.isEmpty()) {
			t.push(q.poll());
		}

	}

	public static int equalTails(LinkedList<Integer> a, LinkedList<Integer> b) {
		int count = 0;
		int times = a.size() - b.size();
		int aIndex = a.size() - 1;
		int bIndex = b.size() - 1;
		while (aIndex >= times && bIndex >= 0 && a.get(aIndex) == b.get(bIndex)) {
			count++;
			aIndex--;
			bIndex--;
		}
		return count;

	}

	public static void sortArrayByTwoStacks(int[] arr) {
		Stack<Integer> complete = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		complete.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < complete.peek())
				complete.push(arr[i]);
			else {
				while (!complete.isEmpty() && arr[i] > complete.peek()) { // inserting to the temp stack
					temp.push(complete.pop());
				}
				complete.push(arr[i]);
				while (!temp.isEmpty()) { // inserting back to complete
					complete.push(temp.pop());
				}
			}
		}
		for (int s : complete) {
			System.out.println(s);
		}
	}

	public static boolean isClosingString(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || (str.charAt(i) == '[' || (str.charAt(i)) == '{'))
				stack.push(str.charAt(i));
			if (stack.isEmpty() && (str.charAt(i) == ')' || (str.charAt(i) == '}' || (str.charAt(i)) == ']')))
				return false;
			if (str.charAt(i) == ')' && !stack.isEmpty() && stack.pop() != '(')
				return false;
			if (str.charAt(i) == ']' && !stack.isEmpty() && stack.pop() != '[')
				return false;
			if (str.charAt(i) == '}' && !stack.isEmpty() && stack.pop() != '{')
				return false;

		}
		return stack.isEmpty();
	}

	public static boolean isSymmetricalAfterDot(String str) {

		if (str.length() % 2 == 0)
			return false;

		Stack<Character> stack = new Stack<Character>();
		boolean flag = true;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.')
				flag = false;
			if (flag)
				stack.push(str.charAt(i));

			if (!flag && !stack.isEmpty()) {
				if (str.charAt(i + 1) != stack.pop())
					return false;
			}
		}
		return true;
	}

	public static String[] combine(String[] a, String[] b, String[] c) {
		int arr = a.length;
		int brr = b.length;
		int crr = c.length;

		if (arr <= brr && arr <= crr) {
			String[] temp = new String[arr];
			return combHelp(temp, a, b, c);
		} else if (brr <= arr && brr <= crr) {
			String[] temp = new String[brr];
			return combHelp(temp, b, a, c);
		} else {
			String[] temp = new String[crr];
			return combHelp(temp, c, a, b);
		}
	}

	public static String[] combHelp(String[] temp, String[] min, String[] second, String[] third) {
		int k = 0;
		for (int i = 0; i < min.length; i++) {
			if (isExsist(min[i], second) && isExsist(min[i], third))
				temp[k++] = min[i];
		}
		return temp;
	}

	public static boolean isExsist(String str, String[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (str.equals(array[mid]))
				return true;
			else if (str.hashCode() > array[mid].hashCode())
				low = mid + 1;
			else
				high = mid - 1;
		}

		return false;
	}

	public static String stringReverse(String s) {
		return stringHelp(s, "", s.length() - 1);
	}

	public static String stringHelp(String s, String str, int i) {
		if (i == 0)
			return str + s.charAt(0);
		str += s.charAt(i);
		return stringHelp(s, str, i - 1);
	}

//	public static int intReverseRecursia(int n) {
//		int temp = n;
//		int count = 0;
//		while (temp != 0) {
//			count++;
//			temp = temp / 10;
//		}
//		return intHelp(n, count);
//	}
//
//	public static int intHelp(int n, int count) {
//		if (count == 1)
//			return n;
//		else {
//			return intHelp((int) (n % Math.pow(10, count-1)), count - 1)*10 + n/10;
//			
//		}
//		
//	}

	public static int intReverse(int n) {
		int temp = n;
		int count = 0;
		while (temp != 0) {
			count++;
			temp = temp / 10;
		}
		for (int i = 0; i < count; i++) {
			if (i + 1 == count)
				temp = (temp + n % 10);
			else
				temp = (temp + n % 10) * 10;

			n = n / 10;
		}
		return temp;
	}

	public static void main(String[] args) {

	}

}
