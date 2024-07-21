package MethodReferences.StaticReference;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

	private String name;
	private LocalDate age;

	public static int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}

}
