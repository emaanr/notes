/**
 * Inheritance
 *      Class that demonstrates inheritance.
 */
public class Inheritance {

    public static void main(String[] args) {

        Car car = new Car();
        car.go();

        Motorcycle bike = new Motorcycle();
        bike.stop();

        System.out.println(car.speed);
        System.out.println(bike.speed);

        System.out.println(car.wheels);
        System.out.println(car.doors);

        System.out.println(bike.wheels);
        System.out.println(bike.pedals);
    }
}

/**
 * Vehicle
 *      Class that creates a vehicle.
 */
class Vehicle {

    // Attributes

    double speed;

    // Methods

    /**
     * go
     *      Prints that the vehicle is going.
     */
    void go() {
        System.out.println("Vehicle is going");
    }

    /**
     * stop
     *      Prints that the vehicle is stopped.
     */
    void stop() {
        System.out.println("Vehicle is stopped");
    }
}

/**
 * Car
 *      Class that creates a car which inherits the Vehicle class.
 */
class Car extends Vehicle {

    // Attributes

    int wheels = 4;
    int doors = 4;
}

/**
 * Motorcycle
 *      Class that creates a motorcycle which inherits the Vehicle class.
 */
class Motorcycle extends Vehicle {

    // Attributes

    int wheels = 2;
    int pedals = 2;
}