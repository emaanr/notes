/**
 * OverloadedConstructors
 *      Class that demonstrates overloaded constructors.
 */
public class OverloadedConstructors {

    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        System.out.println(pizza); // Prints address

        Pizza pizza1 = new Pizza("Thick Crust");
        System.out.println("\nHere are the ingreadients of your pizza:");
        System.out.println(pizza1.bread);
        System.out.println(pizza1.sauce);
        System.out.println(pizza1.cheese);
        System.out.println(pizza1.topping);

        Pizza pizza2 = new Pizza("Thick Crust", "Tomato");
        System.out.println("\nHere are the ingreadients of your pizza:");
        System.out.println(pizza2.bread);
        System.out.println(pizza2.sauce);
        System.out.println(pizza2.cheese);
        System.out.println(pizza2.topping);

        Pizza pizza3 = new Pizza("Thick Crust", "Tomato", "Mozzarella");
        System.out.println("\nHere are the ingreadients of your pizza:");
        System.out.println(pizza3.bread);
        System.out.println(pizza3.sauce);
        System.out.println(pizza3.cheese);
        System.out.println(pizza3.topping);

        Pizza pizza4 = new Pizza("Thick Crust", "Tomato", "Mozzarella", "Pineapple");
        System.out.println("\nHere are the ingreadients of your pizza:");
        System.out.println(pizza4.bread);
        System.out.println(pizza4.sauce);
        System.out.println(pizza4.cheese);
        System.out.println(pizza4.topping);
    }
}

/**
 * Pizza
 *      Class that creates a pizza.
 */
class Pizza {

    // Attributes

    String bread;
    String sauce;
    String cheese;
    String topping;

    // Methods

    /**
     * Pizza
     *      Default pizza constructor that takes no arguments.
     */
    Pizza() {
        System.out.println("Customize your pizza by passing arguments");
    }

    /**
     * Pizza
     *      Pizza constructor that takes one argument.
     * 
     * Parameters:
     *      bread String
     *          Bread of the pizza.
     */
    Pizza(String bread) {
        this.bread = bread;
    }

    /**
     * Pizza
     *      Pizza constructor that takes two arguments.
     * 
     * Parameters:
     *      bread String
     *          Bread of the pizza.
     *      sauce String
     *          Sauce on the pizza.
     */
    Pizza(String bread, String sauce) {
        this.bread = bread;
        this.sauce = sauce;
    }

    /**
     * Pizza
     *      Pizza constructor that takes three arguments.
     * 
     * Parameters:
     *      bread String
     *          Bread of the pizza.
     *      sauce String
     *          Sauce on the pizza.
     *      cheese String
     *          Cheese on the pizza.
     */
    Pizza(String bread, String sauce, String cheese) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
    }

    /**
     * Pizza
     *      Pizza constructor that takes four arguments.
     * 
     * Parameters:
     *      bread String
     *          Bread of the pizza.
     *      sauce String
     *          Sauce on the pizza.
     *      cheese String
     *          Cheese on the pizza.
     *      topping String
     *          Topping on the pizza.
     */
    Pizza(String bread, String sauce, String cheese, String topping) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
        this.topping = topping;
    }
}
