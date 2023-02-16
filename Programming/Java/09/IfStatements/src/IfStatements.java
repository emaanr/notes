import java.util.Scanner;

/**
 * IfStatements
 *      Class that demonstrates how if and else statements work.
 */
public class IfStatements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grade recieved: ");
        int grade = scanner.nextInt();

        scanner.close();

        if (grade >= 90) {
            System.out.println("You got an A");
        } else if (90 > grade && grade >= 80) {
            System.out.println("You got an B");
        } else if (80 > grade && grade >= 70) {
            System.out.println("You got an C");
        } else if (70 > grade && grade >= 60) {
            System.out.println("You got an D");
        } else if (60 > grade && grade >= 0) {
            System.out.println("You got an F");
        } else {
            System.out.println("Invalid entry, provide integer 0 - 100");
        }
    }
}
