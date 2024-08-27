package Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import lombok.Data;

/*
 * Externalization: Programmer is responsible for customizing serialization and deserialization of class instance.
 * Serialization uses Reflection and Metadata which causes relatively slow performance.
 * 
 * With transient keyword JVM interface won't serialize the field
 * But it'll add the field with default value in the file storage.
 */
@Data
public class User implements Externalizable {

	// If this is absent then JVM will add one
	// It's compiler dependent and may cause an unlikely InvalidClassException
	private static final long serialVersionUID = 1l;

	// transient keyword doesn't works in Externalization
	protected transient String name;
	protected int age;
	protected int id;

	// A default constructor is required for deserialization
	public User() {

	}

	public User(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	// Ensure the ordering is maintained while reading and writing
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeInt(id);
		out.writeUTF(name);// or out.writeObject(name)
		out.writeInt(age);
	}

	// Read the properties in same exact order as they were written
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		this.id = in.readInt();
		this.name = in.readUTF(); // or (String) in.readObject()
		this.age = in.readInt();
	}

}
