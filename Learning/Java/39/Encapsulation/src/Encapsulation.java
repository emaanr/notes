/**
 * Encapsulation
 *      Class that demonstrates encapsulation.
 */
public class Encapsulation {

    public static void main(String[] args) {

        Car car = new Car("Honda", "Accord", 2021);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

        car.setYear(2023);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());
    }
}

/**
 * Car
 *      Class that creates an encapsulated car object.
 */
class Car {

    // Attributes

    private String make;
    private String model;
    private int year;

    // Methods

    /**
    * Car
    *      Car constructor.
    * 
    * Parameters:
    *      make String
    *          Make of the car.
    *      model String
    *          Model of the car.
    *      year int
    *          Year the car was manufactured.
    */
    Car(String make, String model, int year) {
        // this.make = make;
        this.setMake(make);
        // this.model = model;
        this.setModel(model);
        // this.year = year;
        this.setYear(year);
    }

    /**
     * getMake
     *      Getter method for private make attribute.
     */
    public String getMake() {
        return make;
    }

    /**
     * setMake
     *      Setter method for private make attribute.
     * 
     * Parameters:
     *      make String
     *          Make of the car.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * getModel
     *      Getter method for private model attribute.
     */
    public String getModel() {
        return model;
    }

    /**
     * setModel
     *      Setter method for private model attribute.
     * 
     * Parameters:
     *      model String
     *          Model of the car.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * getYear
     *      Getter method for private year attribute.
     */
    public int getYear() {
        return year;
    }

    /**
     * setYear
     *      Setter method for private year attribute.
     * 
     * Parameters:
     *      year int
     *          Year the car was manufactured.
     */
    public void setYear(int year) {
        this.year = year;
    }
}
