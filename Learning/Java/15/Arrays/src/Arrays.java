/**
 * Arrays
 *      Class that demonstrates Array basics.
 */
public class Arrays {

    public static void main(String[] args) {

        // Method 1 of creating an Array
        String[] cars = { "Accord", "Pilot", "Civic" };

        System.out.println("Hondas in Lot:");
        System.out.println(cars[0]);
        System.out.println(cars[1]);
        System.out.println(cars[2]);

        cars[1] = "Camry";

        System.out.println("\nCars in Lot:");
        System.out.println(cars[0]);
        System.out.println(cars[1]);
        System.out.println(cars[2]);

        // This will throw an ArrayIndexOutOfBoundsException
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        // System.out.println(cars[3]);

        // Method 2 of creating an Array
        String games[] = new String[5]; // Creating an array of size 5

        games[0] = "Legend of Zelda";
        games[1] = "Yu-Gi-Oh";
        games[2] = "Sonic the Hedgehog";
        games[3] = "Pokemon";
        games[4] = "Fire Emblem";
        // games[5] = "Digimon"; // ArrayIndexOutOfBoundsException

        System.out.println("\n" + games); // Prints address of Array Reference Variable

        // Need to iterate over an Array's indices to print its contents
        System.out.println("\nGame recommendations:");
        for (int i = 0; i < games.length; i++) {
            System.out.println(games[i]);
        }
    }
}
