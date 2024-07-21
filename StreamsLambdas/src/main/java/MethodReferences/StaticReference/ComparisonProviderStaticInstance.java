package MethodReferences.StaticReference;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ComparisonProviderStaticInstance {

	public int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}

	// Date objects can be compared by compareTo method of comparable interface.
	public int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}

	public static void main(String[] args) {

		ComparisonProviderStaticInstance cpsi = new ComparisonProviderStaticInstance();

		Person p1 = new Person("ABC", LocalDate.of(1995, 10, 10));
		Person p2 = new Person("BCD", LocalDate.of(1997, 10, 10));
		Person p3 = new Person("AAA", LocalDate.of(1996, 10, 10));

		Person[] personArr = new Person[3];
		personArr[0] = p1;
		personArr[1] = p2;
		personArr[2] = p3;

		// Reference to static method
//		Arrays.sort(personArr, Person::compareByAge);

		// Reference to instance method of a particular object
//		Arrays.sort(personArr, cpsi::compareByName);
//		Arrays.sort(personArr, cpsi::compareByAge);
		
		Comparator<Person> comp = cpsi::compareByAge;
		Arrays.sort(personArr, comp);

		for (Person p : personArr) {
			System.out.println("Person name:" + p.getName() + " Person DOB " + p.getAge());
		}

	}

}
