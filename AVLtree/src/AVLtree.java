class NodeAVL {
	Integer data;
	int balance, height;
	NodeAVL left, right, parent;

	public NodeAVL(Integer data, NodeAVL parent) {
		this.data = data;
		balance = height = 0;
		this.parent = parent;
	}

	public String toString() {
		return data + "";
	}
}

public class AVLtree {
	NodeAVL root;

	public boolean insert(Integer value) { // to add a value
		if (root == null) { // if root is null we can place it there
			root = new NodeAVL(value, null);
		} else {
			NodeAVL n = root;
			NodeAVL parent;
			boolean flag = true;
			while (flag) {
				if (n.data == value)
					return false; // it means the value already in the tree
				parent = n;
				boolean goLeft = n.data > value; // we're checking which way to go by this if
				n = goLeft ? n.left : n.right;
				if (n == null) {
					if (goLeft) {
						parent.left = new NodeAVL(value, parent);
					} else {
						parent.right = new NodeAVL(value, parent);
					}
					reBalance(parent); // re-balance because we added a value
					flag = false;
				}
			}
		}
		return true;
	}

	public int height(NodeAVL tree) { // height of a certain root
		if (tree == null)
			return 0;
		return 1 + Math.max(height(tree.left), height(tree.right));
	}

	private void setBalance(NodeAVL... nodes) { // setting the balance of certain nodes
		for (NodeAVL n : nodes)
			n.balance = height(n.right) - height(n.left);
	}

	public void reBalance(NodeAVL node) { // rotating the tree if balance is not correct
		setBalance(node);

		if (node.balance == -2) { // rotate right
			if (height(node.left.left) >= height(node.left.right))
				node = rotateRight(node);
			else // rotate left and then right
				node = rotateLeftThenRight(node);

		} else if (node.balance == 2) { // rotate left
			if (height(node.right.right) >= height(node.right.left))
				node = rotateLeft(node);
			else // rotate right and then left
				node = rotateRightThenLeft(node);
		}

		if (node.parent != null) {
			reBalance(node.parent);
		} else {
			root = node;
		}
	}

	private NodeAVL rotateLeft(NodeAVL a) {

		NodeAVL b = a.right;
		b.parent = a.parent;

		a.right = b.left;

		if (a.right != null)
			a.right.parent = a;

		b.left = a;
		a.parent = b;

		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} else {
				b.parent.left = b;
			}
		}

		setBalance(a, b);

		return b;
	}

	private NodeAVL rotateRight(NodeAVL a) {

		NodeAVL b = a.left;
		b.parent = a.parent;

		a.left = b.right;

		if (a.left != null)
			a.left.parent = a;

		b.right = a;
		a.parent = b;

		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} else {
				b.parent.left = b;
			}
		}

		setBalance(a, b);

		return b;
	}

	private NodeAVL rotateLeftThenRight(NodeAVL n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}

	private NodeAVL rotateRightThenLeft(NodeAVL n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}

	public void delete(Integer value) {
		NodeAVL child = root;
		NodeAVL parent = root;
		NodeAVL delNode = null;
		NodeAVL n = root;
		if (root == null) // means there is nothing to delete
			return;

		while (child != null) {
			parent = n;
			n = child;
			child = value >= n.data ? n.right : n.left;
			if (value == n.data) {
				delNode = n;
			}
		}

		if (delNode != null) {
			delNode.data = n.data;

			child = n.left != null ? n.left : n.right;

			if (root.data == value) {
				root = child;
			} else {
				if (parent.left == n) {
					parent.left = child;
				} else {
					parent.right = child;
				}
				reBalance(parent);
			}
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(NodeAVL node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node + ", ");
			inOrder(node.right);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(NodeAVL node) {
		if (node != null) {
			System.out.print(node + ", ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(NodeAVL node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node + ", ");
		}
	}

	public boolean isBalanced(NodeAVL n) {
		if (n == null)
			return true;
		if (n.balance >= 2 || n.balance <= -2)
			return false;
		return isBalanced(n.right) && isBalanced(n.left);
	}
}
