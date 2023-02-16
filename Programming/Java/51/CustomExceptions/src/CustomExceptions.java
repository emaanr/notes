import java.util.Scanner;

/**
 * CustomExceptions
 *      Class that demonstates how to use custom exceptions.
 */
public class CustomExceptions {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Pokedex Number: ");
        int number = scanner.nextInt();

        try {
            checkPokedex(number);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            scanner.close();
        }
    }

    /**
     * checkPokedex
     *      Checks the Pokedex for the entry number provided.
     * 
     * @param number int
     *      Takes an integer as input (from the user).
     * @throws PokedexException
     *      If input is less than or equal to 0 or greater than 1008.
     */
    static void checkPokedex(int number) throws PokedexException {
        if (number <= 0) {
            throw new PokedexException("There are never Pokedex entries less than or equal to 0");
        } else if (number > 1008) {
            throw new PokedexException("There are currently no Pokedex entries greater than 1008");
        } else {
            System.out.println("That is a valid Pokedex entry");
        }
    }
}

/**
 * PokedexException
 *      Custom (User-Defined) Exception that extends the Exception class
 *      in Java and throws an exception for invalid Pokedex entries.
 */
class PokedexException extends Exception {

    // Methods

    /**
     * PokedexException
     *      Constructor for the PokedexException class.
     * @param message String
     *      Returns cause of Exception as a String.
     */
    PokedexException(String message) {
        super(message);
    }

}
