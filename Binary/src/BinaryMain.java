
public class BinaryMain {

	public static String isLeaf(int data, Node current) {
		if (current == null)
			return "not a vertex";
		if (data < current.data)
			return isLeaf(data, current.left);
		if (data > current.data)
			return isLeaf(data, current.right);
		else {
			if (current.left == null && current.right == null)
				return "is a leaf";
			else
				return "not a leaf";
		}
	}

	public static void main(String[] args) {

	}

}
