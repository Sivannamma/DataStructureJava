
public class Queue {
	private int size; // length of out array
	private int count; // how many values we already have in
	private int front; // point to the head, first value
	private int tail; // point to the free place
	private Integer[] data;

	public Queue(int size) { // default constructor that gets size;
		this.size = size;
		count = front = tail = 0;
		data = new Integer[size];
	}

	public boolean enQueue(int val) {// adding new value
		boolean ans = false;
		if (count < size)// it means we can add new value
		{
			data[tail] = val;
			tail = (tail + 1) % size;
			count++; // because we added new val
			ans = true;
		}
		return ans;
	}

	public Integer deQueue() {
		Integer val = null;
		if (count > 0) {
			val = data[front];
			front = (front + 1) % size;
			count--; // because we deleted value, less in the queue
		}
		return val;
	}

	public String toString() {
		String str = "[ ";
		for (int i = front; i < data.length; i++) {
			if (i + 1 == data.length)
				str = str + data[i] + " ]";
			else
				str = str + data[i] + " -> ";
		}
		return str;
	}
}
