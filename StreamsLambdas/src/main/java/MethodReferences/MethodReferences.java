package MethodReferences;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReferences {

	public static void main(String[] args) {
		
		Supplier<String> supplier = () -> "Hello World!";
		
		Consumer<String> consumer = System.out::println;
		
		consumer.accept(supplier.get());

	}

}
