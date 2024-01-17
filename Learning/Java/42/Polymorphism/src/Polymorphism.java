/**
 * Polymorphism
 *      Class that demonstrates polymorphism.
 */
public class Polymorphism {

    public static void main(String[] args) {

        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Boat boat = new Boat();

        Vehicle[] racers = { car, bicycle, boat };

        // car.go();
        // bicycle.go();
        // boat.go();

        for (Vehicle racer : racers) {
            racer.go();
        }
    }
}

/**
 * Vehicle
 *      Abstract class that has an abstract method called go().
 */
abstract class Vehicle {

    // Methods

    /**
     * go
     *      Abstract method to be implemented by inheritors (children).
     */
    abstract void go();
}

/**
 * Car
 *      Class that creates a car and inherits the class Vehicle.
 */
class Car extends Vehicle {

    // Methods

    /**
     * go
     *      Abstract method that says the car is going.
     */
    @Override
    public void go() {
        System.out.println("The car is going");
    }
}

/**
 * Bicycle
 *      Class that creates a bicycle and inherits the class Vehicle.
 */
class Bicycle extends Vehicle {

    // Methods

    /**
     * go
     *      Abstract method that says the bicycle is going.
     */
    @Override
    public void go() {
        System.out.println("The bicycle is going");
    }
}

/**
 * Boat
 *      Class that creates a boat and inherits the class Vehicle.
 */
class Boat extends Vehicle {

    // Methods

    /**
     * go
     *      Abstract method that says the boat is going.
     */
    @Override
    public void go() {
        System.out.println("The boat is going");
    }
}