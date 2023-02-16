import java.util.ArrayList;

/**
 * TwoDArrayList
 *      Class that demonstrates how 2D ArrayLists work.
 */
public class TwoDArrayList {

    public static void main(String[] args) {

        ArrayList<String> bakeryList = new ArrayList<String>();
        bakeryList.add("Bread");
        bakeryList.add("Pasta");
        bakeryList.add("Donuts");

        System.out.println(bakeryList);

        ArrayList<String> produceList = new ArrayList<String>();
        produceList.add("Mushrooms");
        produceList.add("Garlic");
        produceList.add("Leeks");

        System.out.println(produceList);

        ArrayList<String> beverageList = new ArrayList<String>();
        beverageList.add("Ginger Ale");
        beverageList.add("Water");

        System.out.println(beverageList);

        ArrayList<ArrayList<String>> groceryList = new ArrayList<ArrayList<String>>();
        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(beverageList);

        System.out.println(groceryList);

        // Print first element of first ArrayList in groceryList
        System.out.println(groceryList.get(0).get(0)); // Bread
    }
}
