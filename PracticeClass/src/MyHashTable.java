
public class MyHashTable {
	LinkedListSingle[] arr; // array of linked list
	int size; // size of the array

	public MyHashTable(int size) { // default constructor
		arr = new LinkedListSingle[size];
		this.size = size;
		for (int i = 0; i < size; i++) { // initializing the array to linked list
			arr[i] = new LinkedListSingle();
		}
	}

	public MyHashTable(MyHashTable other) { // copy constructor
		this.size = other.size;
		arr = new LinkedListSingle[size];
		for (int i = 0; i < size; i++) {
			arr[i] = other.arr[i];
		}
	}

	public void insert(Integer key, Student data) {
		int h = hash(key);
		boolean exchanged = false;
		for (NodeL temp = arr[h].head; temp != null; temp = temp.next) {
			if (temp.data.key == key) {
				temp.data.s.age = data.age;
				temp.data.s.name = data.name;
				exchanged = true;
			}
		}
		if (!exchanged) {
			NodeL temp = arr[0].head;
			Person p = new Person(key, data);
			arr[h].add(p);
		}
	}

	public void remove(Integer key) {

	}

	public int hash(Integer key) {
		return key % arr.length;
	}

}
