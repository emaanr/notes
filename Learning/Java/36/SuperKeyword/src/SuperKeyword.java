/**
 * SuperKeyword
 *      Class that demonstrates the 'super' keyword.
 */
public class SuperKeyword {

    public static void main(String[] args) {

        Hero shoto = new Hero("Shoto", 16, "Half-Cold Half-Hot");
        Hero deku = new Hero("Deku", 16, "One For All");

        System.out.println(shoto.toString());
        System.out.println(deku.toString());
    }
}

/**
 * Person
 *      Class that creates a person.
 */
class Person {

    // Attributes

    String name;
    int age;

    // Methods

    /**
     * Person
     *      Person constructor.
     * 
     * Parameters:
     *      name String
     *          The name of the person.
     *      age int
     *          The age of the person.
     */
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * toString
     *      Overrides toString method.
     */
    @Override
    public String toString() {
        return this.name + "\n" + this.age;
    }
}

/**
 * Hero
 *      Class that creates a hero which inherits the Person class.
 */
class Hero extends Person {

    // Attributes

    String quirk;

    // Methods

    /**
     * Hero
     *      Hero constructor which calls superclass constructor.
     * 
     * Parameters:
     *      name String
     *          The name of the hero.
     *      age int
     *          The age of the hero.
     *      quirk String
     *          The power of the hero.
     */
    Hero(String name, int age, String quirk) {
        super(name, age);
        this.quirk = quirk;
    }

    /**
     * toString
     *      Overrides toString method and calls superclass toString method.
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + this.quirk;
    }
}