
public class Stack {
	Integer[] data;
	final int INIT_SIZE = 10;
	int size;
	int count;

	public Stack() { // default constructor
		data = new Integer[INIT_SIZE];
		count = 0;
		size = INIT_SIZE;
	}

	public Stack(int size) { // constructor that gets the length of the stack
		data = new Integer[size];
		this.size = size;
		count = 0;
	}

	public Stack(Stack other) {
		this.size = other.size;
		this.count = other.count;
		data = new Integer[size];
		for (int i = 0; i < data.length; i++) {
			this.data[i] = other.data[i];
		}
	}

	public void push(int val) {
		if (count == size)
			reSize();
		data[count++] = val;
	}

	public Integer pop() {
		Integer ans;
		if (count == 0) // if the stack is null, there is no value to delete
			return null;
		else {
			ans = data[--count]; // taking the value, than --, -- means we "delete" it, next add we will go over
									// it
			return ans;
		}
	}

	public void reSize() {
		Integer[] temp = new Integer[size + INIT_SIZE];
		for (int i = 0; i < count; i++) {
			temp[i] = data[i];
		}
		data = temp; // setting the pointer (in class it does save)
	}

	public boolean empty() {
		return count == 0; // if count==0 it return true, else- false.
	}

	public String toString() {
		String str = "[ ";
		for (int i = count - 1; i >= 0; i--) {
			if (i == 0)
				str = str + data[i] + " ]";
			else
				str = str + data[i] + " ,";

		}
		return str;
	}
}
