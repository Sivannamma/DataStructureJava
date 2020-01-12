class Node {
	int data;
	int appearance = 1;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class smartStack {
	Node head;
	int size;

	public smartStack() {
		size = 0;
		head = null;
	}

	public int pop(int val) { // delete the first value

		if (head == null)
			return Integer.MIN_VALUE; // if stack is empty, nothing to delete

		int save = head.data; // saving the data i want to delete before promoting head
		head = head.next; // head.next to delete the first value
		size--; // size-- because i delete value
		return save;
	}

	public void push(int val) {
		if (head == null) { // if head is null, the value i enter is the first value
			head = new Node(val);
			size++; // i add a value so size grows
		}

		else {
			Node headHelp = head;
			for (headHelp = head; headHelp != null; headHelp = headHelp.next) {
				if (headHelp.data == val) { // if one time the value suits the stack, no need to add it
					headHelp.appearance++;
					return;
				}
			}
			// if we are at this code; it means we didn't find the value inside the stack so
			// far
			headHelp = new Node(val);
			headHelp.next = head;
			head = headHelp;
			size++;
			return;
		}
	}

	public String toString() {
		String str = "[";
		for (Node h = head; h != null; h = h.next) {

			while (h.appearance >= 1) {
				if (h.next == null)
					str = str + h.data;
				else
					str = str + h.data + " ,";

				h.appearance--;
			}
		}
		return str + "]";
	}

}
