import java.util.Scanner;

/**
 * LogicalOperators
 *      Class that demonstrates use of logical operators.
 */
public class LogicalOperators {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        int temperature = scanner.nextInt();

        // Temperature dialogue using AND operator
        if (temperature >= 30) {
            System.out.println("It is hot outside.");
        } else if (30 > temperature && temperature >= 20) {
            System.out.println("It is warm outside.");
        } else {
            System.out.println("Anything lower than 20C is cold outside.");
        }

        System.out.println("\nPress q or Q to quit");
        String response1 = scanner.next();

        // Quit dialogue using OR operator 
        if (response1.equals("q") || response1.equals("Q")) {
            System.out.println("You quit");
        } else {
            System.out.println("You didn't press q or Q");
        }

        System.out.println("\nPress q or Q to quit");
        String response2 = scanner.next();

        // Quit dialogue using NOT operator with AND
        if (!response2.equals("q") && !response2.equals("Q")) {
            System.out.println("You didn't press q or Q");
        } else {
            System.out.println("You quit");
        }

        scanner.close();
    }
}
