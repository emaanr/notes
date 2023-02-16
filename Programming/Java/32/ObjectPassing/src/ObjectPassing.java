/**
 * ObjectPassing
 *      Class that demonstrates how to pass Objects as arguments.
 */
public class ObjectPassing {

    public static void main(String[] args) {

        Garage garage = new Garage();
        Car car = new Car("Accord");

        garage.park(car);
    }
}

/**
 * Car
 *      Class that represents a car.
 */
class Car {

    // Attributes

    String name;

    // Methods

    /**
     * Car
     *      Car constructor that takes one argument.
     * 
     * Parameters:
     *      name String
     *          The model of the car.
     */
    Car(String name) {
        this.name = name;
    }
}

/**
 * Garage
 *      Class that represents a garage to park cars in.
 */
class Garage {

    // Methods

    /**
    * park
    *      Parks a car.
    * 
    * Parameters:
    *      car Car
    *          Car to park.
    */
    void park(Car car) {
        System.out.println("The " + car.name + " is parked in the garage");
    }
}
