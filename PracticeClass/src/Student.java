
public class Student {
	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "<" + name + "," + age + ">";
	}
}

class Person {
	Integer key; // id of a student
	Student s;

	public Person(Integer key, Student s) { // default constructor
		this.key = key;
		this.s = s;
	}

	public String toString() {
		return "(" + key + ", " + s.toString() + " )";
	}
}