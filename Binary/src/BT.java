class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}

	public String toString() {
		return "" + data;
	}
}

public class BT { // binary tree
	Node root;

	public BT() {
		root = null;
	}

	public void insert(int val) {
		if (root == null)
			root = new Node(val);
		else
			add(root, val);
	}

	public Node add(Node current, int val) {
		if (current != null) {
			double r = Math.random();
			if (r < 0.5) {
				current.left = add(current.left, val);
				return current;
			} else {
				current.right = add(current.right, val);
				return current;
			}
		} else
			return new Node(val);
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node + ", ");
			inOrder(node.right);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node + ", ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node + ", ");
		}
	}

	public boolean contains(Node node, int val) {
		boolean ans = false;
		if (node != null) {
			ans = ((node.data == val) || contains(node.left, val) || contains(node.right, val));
		}
		return ans;
	}

	public int height() {
		return height(root);
	}

	public int height(Node root) {
		int ans = 0;
		if (root != null) {
			int heightLeft = height(root.left);
			int heightRight = height(root.right);
			ans = (heightLeft > heightRight ? heightLeft : heightRight) + 1;
		}
		return ans;
	}
}
