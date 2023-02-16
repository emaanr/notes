import java.util.Scanner;

/**
 * WhileLoop
 *      Class that demonstrates how while loops and do-while loops work.
 */
public class WhileLoop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String first_name = "";

        // Does not exit until a name is provided as input from user
        while (first_name.isBlank()) {
            System.out.print("Enter your first name: ");
            first_name = scanner.nextLine();
        }

        System.out.println("\nHello " + first_name + "\n");

        String last_name = "";

        // Do-while loop executes the code block AT LEAST once
        do {
            System.out.print("Enter your last name: ");
            last_name = scanner.nextLine();
        } while (last_name.isBlank());

        System.out.println("\nHello " + first_name + " " + last_name);

        scanner.close();
    }
}
