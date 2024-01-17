/**
 * Objects
 *      Class that demonstrates Object Oriented Programming (OOP).
 */
public class Objects {

    public static void main(String[] args) {

        Car myCar = new Car();

        System.out.println(myCar.make);
        System.out.println(myCar.model);
        System.out.println(myCar.year);
        System.out.println(myCar.color);
        System.out.println(myCar.price);

        myCar.drive();
        myCar.brake();
    }
}

/**
 * Car
 *      Class that represents the car I drive for OOP demonstration.
 */
class Car {

    // Attributes

    String make = "Honda";
    String model = "Accord";
    int year = 2021;
    String color = "Sonic Gray";
    double price = 50000.00;

    // Methods

    /**
     * drive
     *      Prints that you are driving the Car object.
     */
    void drive() {
        System.out.println("You drive the car");
    }

    /**
     * brake
     *      Prints that you are braking the Car object.
     */
    void brake() {
        System.out.println("You step on the brakes");
    }
}