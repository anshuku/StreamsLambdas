package MethodReferences.ObjectReference;

interface Sayable1 {
	void said();
}

public class Hello implements Sayable, Sayable1 {

	@Override
	public void say() {
		System.out.println("This is non-static overridden method for Sayable");
	}

	@Override
	public void said() {
		System.out.println("This is non-static overridden method for Sayable1");

	}

	// implements say method of interface Sayable without overriding
	public void saySomething() {
		System.out.println("This is non-static method");
	}

	public static void main(String[] args) {

		Hello ref = new Hello();// creates object

		// referring to non static method using reference
		Sayable sayable = ref::saySomething;

		// Lambda expression or method reference implements the Sayable interface's
		// say method
		Sayable sayableLambda = () -> ref.saySomething();

		// when say method is called saySomething is checked
		sayable.say();
		sayableLambda.say();

		System.out.println("===============================");

		Sayable1 saying = ref::saySomething;
		saying.said();

		System.out.println("===============================");

		// referring non static method using anonymous object
		Sayable sayable2 = new Hello()::saySomething;

		// when say method is called saySomething is checked
		sayable2.say();

		System.out.println("===============================");

		int sqVal = Sayable.getSquareValue(4);
		System.out.printf("The square of %d from functional interface is " + sqVal, 4);
		System.out.println();

		System.out.println("===============================");

		int cubeVal = sayable.getCubeValue(5);
		System.out.printf("The cube of %d from functional interface is " + cubeVal, 5);
		System.out.println();

		System.out.println("===============================");

		Sayable said = new Hello();

		// when say method is called overriden say method is called in Hello class
		said.say();

		// Can't be called since (in compile time) Sayable interface doesn't have
		// saySomething method
		// said.saySomething();
	}

}
