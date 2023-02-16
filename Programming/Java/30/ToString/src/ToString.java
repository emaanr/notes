/**
 * ToString
 *      Class that demonstrates how the toString() method works.
 */
public class ToString {

    public static void main(String[] args) {

        Accord myAccord = new Accord();

        System.out.println(myAccord); // Implicit
        System.out.println(myAccord.toString()); // Explicit
    }
}

/**
 * Accord
 *      Class that creates a Honda Accord, Sonic Grey color, year 2021.
 */
class Accord {

    // Attributes

    String make = "Honda";
    String model = "Accord";
    String color = "Sonic Gray";
    int year = 2021;

    // Methods

    /**
     * toString
     *      Overrides the default toString() method. Returns the
     *      attributes of the object as a String.
     */
    @Override
    public String toString() {
        return make + "\n" + model + "\n" + color + "\n" + year;
    }
}
