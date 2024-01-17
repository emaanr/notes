/**
 * Constructors
 *      Class that demonstrates how constructors work in OOP.
 */
public class Constructors {

    public static void main(String[] args) {

        Human emaan = new Human("Emaan", 23, 130);
        Human ben = new Human("Ben", 25, 145);

        System.out.println(emaan.name);
        System.out.println(emaan.age);
        System.out.println(emaan.weight);

        System.out.println(ben.name);
        System.out.println(ben.age);
        System.out.println(ben.weight);

        ben.eat();
        emaan.drink();
    }
}

/**
 * Human
 *      Class that represents a Human.
 */
class Human {

    // Attributes

    String name;
    int age;
    double weight;

    // Methods

    /**
     * Human
     *      Constructor for Human class.
     * 
     * Parameters:
     *      name String
     *          Name of human.
     *      age int
     *          Age of human.
     *      weight double
     *          Weight of human.
     */
    Human(String name, int age, double weight) {

        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    /**
     * eat
     *      Prints that this human is eating.
     */
    void eat() {
        System.out.println(this.name + " is eating");
    }

    /**
     * drink
     *      Prints that this human is drinking.
     */
    void drink() {
        System.out.println(this.name + " is drinking");
    }
}
