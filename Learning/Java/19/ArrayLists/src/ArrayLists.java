import java.util.ArrayList;

/**
 * ArrayLists
 *      Class that demonstrates how ArrayList works.
 */
public class ArrayLists {

    public static void main(String[] args) {

        ArrayList<String> ingredients = new ArrayList<String>();

        ingredients.add("Quinoa");
        ingredients.add("Sweet Potato");
        ingredients.add("Bell Pepper");
        ingredients.add("Brocolli");
        ingredients.add("Cauliflower");

        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(ingredients.get(i));
        }

        ingredients.set(0, "Rice"); // Set element at index 0
        ingredients.remove(2); // Remove element at index 2

        System.out.println("\nModified recipe: ");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(ingredients.get(i));
        }

        ingredients.clear();

        // For-loop runs but doesn't print anything because we cleared the ArrayList
        System.out.println("\nAll done!");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println(ingredients.get(i));
        }
    }
}
