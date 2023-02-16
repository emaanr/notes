/**
 * CopyObjects
 *      Class that demonstrates how to copy objects.
 */
public class CopyObjects {

    public static void main(String[] args) {

        Car car = new Car("Honda", "Accord", 2021);
        Car shallowCopy = car;
        //Car car2 = new Car("Honda","Pilot",2022);
        //deepCopy.copy(car1);
        Car deepCopy = new Car(car);

        System.out.println(car); // Returns Same Adresses (Same Reference)
        System.out.println(shallowCopy); // Returns Same Adresses (Same Reference)
        System.out.println(deepCopy); // Returns Different Address (Different Reference)
        System.out.println();
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());
        System.out.println();
        System.out.println(shallowCopy.getMake());
        System.out.println(shallowCopy.getModel());
        System.out.println(shallowCopy.getYear());
        System.out.println();
        System.out.println(deepCopy.getMake());
        System.out.println(deepCopy.getModel());
        System.out.println(deepCopy.getYear());
    }
}

/**
 * Car
 *      Class that creates a car and can create deep copies of a car.
 */
class Car {

    // Attributes

    private String make;
    private String model;
    private int year;

    //Methods

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
        this.setMake(make);
        this.setModel(model);
        this.setYear(year);
    }

    /**
     * Car
     *      Overloaded constructor that creates a deep copy of a car.
     * 
     * Parameters:
     *      copy Car
     *          Car to be deep copied.
     */
    Car(Car copy) {
        this.copy(copy);
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

    /**
     * copy
     *      Creates a deep copy of a car.
     * 
     * Parameters:
     *      copy Car
     *          Car to be deep copied.
     */
    public void copy(Car copy) {
        this.setMake(copy.getMake());
        this.setModel(copy.getModel());
        this.setYear(copy.getYear());
    }
}