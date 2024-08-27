package Externalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * First creating a user object and writing it to a file. 
 * We're then deserializing the user object from the file.
 */
public class ExternalizableMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File f = new File("sample.txt");
		FileOutputStream fOut = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fOut);

		User user = new User("abc", 3, 10);

//		User user = new User();
//		user.setName("abc");
//		user.setAge(3);
//		user.setId(10);

		user.writeExternal(out);
//		out.writeObject(user);


		// Close the streams otherwise there will be resource leak
		out.flush();
		out.close();
		// if using writeExternal then FileOutputStream is closed after
		// ObjectOutputStream
		fOut.close();

		FileInputStream fInt = new FileInputStream(f);
		ObjectInputStream in = new ObjectInputStream(fInt);

		User user2 = new User();
		user2.readExternal(in);

		System.out.println(user2);
//		System.out.println(user);

//		System.out.println("After De externalization username: " + user.getName() + " and age is:" + user.getAge());

		in.close();
		fInt.close();

	}

}
