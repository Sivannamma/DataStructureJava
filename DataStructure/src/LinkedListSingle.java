class NodeL {
	double data;
	NodeL next;

	public NodeL(double data) {
		this.data = data;
		next = null;
	}
}

public class LinkedListSingle {
	NodeL head;

	public LinkedListSingle() {
		head = null;
	}

	public void add(double val) {
		if (head == null) {
			head = new NodeL(val);
		} else {
			NodeL temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new NodeL(val);
		}

	}

	public String toString() {
		String ans = "[";
		if (head == null)
			ans = "[]";
		else {
			NodeL n = head;
			while (n.next != null) {
				ans = ans + n.data + ", ";
				n = n.next;
			}
			ans = ans + n.data + "]";
		}
		return ans;
	}
}
