package MethodReferences.ObjectReference;

@FunctionalInterface
public interface Sayable {

	void say();

	// Accessed via the interface directly
	static int getSquareValue(int n) {
		return n * n;
	}

	// Accessed via the interface object
	default int getCubeValue(int n) {
		return n * n * n;
	}

}
