/**
 * Abstraction
 *      Class that demonstrates abstraction.
 */
public class Abstraction {

    public static void main(String[] args) {

        // Cannot instantiate the type Vehicle
        // Vehicle vehicle = new Vehicle();
        // But we can create a Car
        Car car = new Car();
        car.go();
    }
}

/**
 * Vehicle
 *      Abstract class that defines a vehicle but forbids the direct creation of one.
 */
abstract class Vehicle {

    /**
     * go
     *      Abstract methods to be implemented by children classes.
     */
    abstract void go();
}

/**
 * Car
 *      Class that creates a car and inherits the abstract Vehicle class.
 */
class Car extends Vehicle {

    /**
     * go
     *      Inherited abstract method implemented using method overriding.
     */
    @Override
    void go() {
        System.out.println("The car is going");
    }
}
