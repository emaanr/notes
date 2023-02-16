import java.util.Scanner;

/**
 * AcceptInput
 *      Class that demonstrates how to accept user input and a common issue related to the Scanner class methods.
 */
public class AcceptInput {

    public static void main(String[] args) {

        // Create a new Scanner that takes user input via the System.in stream
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = scanner.nextLine();

        System.out.println("\nHello " + name);

        System.out.print("\nEnter your age: ");

        int age = scanner.nextInt();

        // scanner.nextLine() // One solution for clearing \n from buffer after nextInt()

        System.out.println("\nYou are " + age + " years old");

        System.out.print("\nEnter your favorite color: ");

        // String color = scanner.nextLine(); // .nextLine() works if calling scanner.NextLine() immediately after nextInt() call
        /**
         * Otherwise, we can use next()
         *      Note, however, that this delimits on spaces, so it will not print more than one "word"
         *      For example, if the user inputs "Light Blue" then the output will be:
         *          "Your favorite color is Light" 
         */
        String color = scanner.next();

        System.out.println("\nYour favorite color is " + color);

        scanner.close();
    }
}
