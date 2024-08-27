package Externalization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import lombok.Data;

/*
 * When a class inherits from Serializable interface(JVM Takes care of serializing class instance). 
 * The JVM automatically collects all field subclasses as well and make them Serializable.
 * 
 * This can be achieved in Externalization(programmer takes care of it) as well. We just need to implement
 * read/write methods for every subclasses of the inheritance hierarchy.
 */
@Data
public class Student extends User {// Not implementing Externalizable as it'll be redundant

	private static final long serialVersionUID = 1l;

	// transient keyword doesn't works in Externalization
	protected transient int rollNo;
	protected String rank;

	Student() {

	}

	Student(String name, int age, int id, int rollNo, String rank) {

		this.name = name;
		this.age = age;
		this.id = id;
		this.rollNo = rollNo;
		this.rank = rank;

	}

	// Serializer method
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeUTF(rank);
		out.writeInt(rollNo);
		super.writeExternal(out);
	}

	// Deserializer method
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		this.rank = in.readUTF();
		this.rollNo = in.readInt();
		// call the parent readExternal later as it follows an order
		super.readExternal(in);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + ", rollNo=" + rollNo + ", rank=" + rank + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Student student = new Student("abc", 3, 10, 15, "2");

		File f = new File("sample.txt");
		FileOutputStream fOut = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fOut);

		student.writeExternal(out);

		out.flush();
		out.close();
		fOut.close();

		FileInputStream fInt = new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fInt);

		Student student2 = new Student();

		student2.readExternal(in);

		System.out.println(student2);

		// if using readExternal then FileInputStream and ObjectInputStream is closed in
		// any order
		fInt.close();
		in.close();

	}

}
