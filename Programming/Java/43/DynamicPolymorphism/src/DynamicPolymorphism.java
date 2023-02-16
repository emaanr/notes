import java.util.Scanner;

/**
 * DynamicPolymorphism
 *      Class that demonstrates dynamic polymorphism.
 */
public class DynamicPolymorphism {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input either \"Cat\" or \"Dog\": ");
        String input = scanner.next();

        scanner.close();

        if (input.equals("Cat") || input.equals("cat")) {
            Animal animal = new Cat();
            animal.speak();
        } else if (input.equals("Dog") || input.equals("dog")) {
            Animal animal = new Dog();
            animal.speak();
        } else {
            Animal animal = new Animal();
            animal.speak();
            System.out.println("Please input either \"Cat\" or \"Dog\"");
        }
    }
}

/**
 * Animal
 *      Class that creates an Animal that can speak.
 */
class Animal {

    // Methods

    /**
     * speak
     *      Default behavior if no animal specified by user.
     */
    public void speak() {
        System.out.println("Animal goes ???");
    };
}

/**
 * Dog
 *      Class that creates a Dog that goes woof.
 */
class Dog extends Animal {

    // Methods

    /**
     * speak
     *      Dog goes woof.
     */
    @Override
    public void speak() {
        System.out.println("Dog goes woof");
    }
}

/**
 * Cat
 *      Class that creates a Cat that goes meow.
 */
class Cat extends Animal {

    // Methods

    /**
     * speak
     *      Cat goes meow.
     */
    @Override
    public void speak() {
        System.out.println("Cat goes meow");
    }
}