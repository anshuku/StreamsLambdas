package Lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaExperssions {

	public static void main(String[] args) {
		// Supplier
		Supplier<String> supplier = () -> "Hello World!";

		// Consumer
		Consumer<String> consumer = (String str) -> System.out.println(str);
//		Consumer<String> consumer = str -> System.out.println(str); // same

		consumer.accept(supplier.get());

		// Predicate
		Predicate<Integer> predicate = (num) -> num % 2 == 0;

		System.out.printf("the given integer %d is even - " + predicate.test(4), 2);
		System.out.println();
		System.out.printf("the given integer %d is even - " + predicate.test(4), 5);
		System.out.println();

		// Function
		Function<Integer, Integer> squareFunction = (num) -> num * num;

		System.out.printf("the square of the given integer %d is " + squareFunction.apply(2), 2);
		System.out.println();
		System.out.printf("the square of the given integer %d is " + squareFunction.apply(3), 3);
		System.out.println();

		// BiFunction
		BiFunction<Integer, Integer, Integer> maxFunction = (num1, num2) -> num1 > num2 ? num1 : num2;

		System.out.printf("the maximum of the given integers %d and %d is " + maxFunction.apply(2, 3), 2, 3);
		System.out.println();
		System.out.printf("the maximum of the given integers %d and %d is " + maxFunction.apply(100, 150), 100, 150);
		System.out.println();

		// UnaryOperator
		UnaryOperator<Integer> sqFunction = num -> num * num;

		System.out.printf("the square of the given integer %d is " + sqFunction.apply(2), 2);
		System.out.println();
		System.out.printf("the square of the given integer %d is " + sqFunction.apply(3), 3);
		System.out.println();

		// BinaryOperator
		BinaryOperator<Integer> minFunction = (num1, num2) -> num1 < num2 ? num1 : num2;

		System.out.printf("the minimum of the given integers %d and %d is " + minFunction.apply(2, 3), 2, 3);
		System.out.println();
		System.out.printf("the minimum of the given integers %d and %d is " + minFunction.apply(100, 150), 100, 150);
		System.out.println();

	}

}
