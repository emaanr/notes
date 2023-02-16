/**
 * MethodOverriding
 *      Class that demonstrates method overriding.
 */
public class MethodOverriding {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.speak();

        Dog dog = new Dog();
        dog.speak();
    }
}

/**
 * Animal
 *      Class that creates an animal that can speak.
 */
class Animal {

    // Methods

    /**
     * speak
     *      Prints that the animal speaks.
     */
    void speak() {
        System.out.println("The animal speaks");
    }
}

/**
 * Dog
 *      Class that creates a dog which inherits the Animal class.
 */
class Dog extends Animal {

    // Methods

    /**
     * speak
     *      Overrides parent method and prints that the dog barks.
     */
    @Override
    void speak() {
        System.out.println("The dog barks");
    }
}
