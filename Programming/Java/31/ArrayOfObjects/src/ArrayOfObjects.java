/**
 * ArrayOfObjects
 *      Class that demonstrates how to create an Array of Objects.
 */
public class ArrayOfObjects {

    public static void main(String[] args) {

        // Food fridge[] = new Food[3];
        Food[] fridge = new Food[3];

        Food food1 = new Food("Rice");
        Food food2 = new Food("Pasta");
        Food food3 = new Food("Soup");

        fridge[0] = food1;
        fridge[1] = food2;
        fridge[2] = food3;

        // System.out.println(food1.name);
        System.out.println(fridge[0].name);
        // System.out.println(food2.name);
        System.out.println(fridge[1].name);
        // System.out.println(food3.name);
        System.out.println(fridge[2].name);

        // Another way to create and populate an Array of Objects
        Food[] refrigerator = { food1, food2, food3 };

        // Another way to print elements in an Array of Objects
        for (Food food : refrigerator) {
            System.out.println(food.name);
        }
    }
}

/**
 * Food
 *      Class that creates a food item.
 */
class Food {

    // Attributes

    String name;

    // Methods

    /**
    * Food
    *      Food constructor that takes one argument.
    * 
    * Parameters:
    *      name String
    *          Name of the food item.
    */
    Food(String name) {
        this.name = name;
    }
}
