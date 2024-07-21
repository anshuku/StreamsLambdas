package MethodReferences.ObjectReference;

interface Vehicle {
	int speed(int numOfWheels, int petrol);
}

public class Car implements Vehicle {

	@Override
	public int speed(int numOfWheels, int petrol) {
		System.out.println("speed invoked ->");
		return petrol / numOfWheels;
	}

	public int speedOfCar(int numOfWheels, int petrol) {
		System.out.println("speedOfCar invoked ->");
		return petrol / numOfWheels;
	}

	public static void main(String[] args) {

		Car car = new Car();
		Vehicle vehicle = car::speedOfCar;

		int speedOfVehicle = vehicle.speed(4, 50);

		System.out.println("The speed of vehicle is " + speedOfVehicle);

		Vehicle v = new Car();

		int speedOfV = v.speed(4, 20);
		System.out.println("The speed of v is " + speedOfV);

	}

}
