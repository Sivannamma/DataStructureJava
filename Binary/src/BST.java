
public class BST {
	Node root;
	int size;

	public BST() {
		root = null;
		size = 0;
	}

	public void insert(int elem) {

		if (root == null) { // if the tree is empty; we can insert the element to the root
			root = new Node(elem); // initializing the Node with the element
			size++; // because we inserted an element
			return;
		}
		// if not, we need to find its right place

		Node n = root;
		boolean flag = false;
		while (!flag) {
			if (elem < n.data) { // if it< means we go left
				if (n.left == null) { // if spot null, fit it there
					n.left = new Node(elem);
					flag = true;
					size++;
				} else // else, continue to promote until we find an open spot
					n = n.left;
			} else if (elem > n.data) { // means < we go right
				if (n.right == null) {
					n.right = new Node(elem);
					flag = true;
					size++;
				} else
					n = n.right;
			}
		}
	}

	public boolean search(int elem) { // to search if value is in our tree
		Node n = root;
		boolean ans = false;
		while (n != null && !ans) {
			if (elem == n.data)
				return true;
			else if (elem > n.data)
				n = n.right;
			else if (elem < n.data)
				n = n.left;
		}
		return ans;
	}

	public void delete(int elem) {
		root = delete(root, elem);
	}

	public Node delete(Node node, int elem) {
		if (node == null) // base case if the tree is empty
			return node;
		// otherwise, we go down the tree
		if (elem < node.data)
			node.left = delete(node.left, elem);
		else if (elem > node.data)
			node.right = delete(node.right, elem);
		// means the element is equals to node.data, and this is the node to be deleted
		else {
			if (node.left == null && node.right == null)
				return null;
			// a case with a node with only one child
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;

			node.data = predecessor(node.right); // finding the min successor
			node.right = delete(node.right, node.data); // deleting the successor because we replaced it
		}
		return node;
	}

	public int predecessor(Node node) { // the smallest among the maximum
		int minValue = node.data;
		while (node.left != null) {
			minValue = node.left.data;
			node = node.left;
		}
		return minValue;
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

	public int height() {
		return height(root) - 1;
	}

	public int height(Node tree) {
		if (tree == null)
			return 0;
		return 1 + Math.max(height(tree.left), height(tree.right));
	}

	public boolean isBalanced() { // if the three is balanced
		int heightLeft = height(root.left);
		int heightRight = height(root.right);
		return (Math.abs(heightRight - heightLeft) > 1 ? false : true);

	}

	public boolean isComplete(Node node) {
		int x = (int) (Math.pow(2, height(node))) - 1;
		int y = vertex(node);
		if (x == y)
			return true;
		return false;
	}

	public int vertex(Node n) {
		if (n == null)
			return 0;
		return 1 + vertex(n.right) + vertex(n.left);
	}
}