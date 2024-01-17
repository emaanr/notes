import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ExceptionHandling
 *      Class that demonstrates exception handling.
 */
public class ExceptionHandling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a whole number to divide: ");
            int dividend = scanner.nextInt();

            System.out.print("Enter a whole number to divide by: ");
            int divisor = scanner.nextInt();

            int result = dividend / divisor;

            System.out.printf("Result: %d", result);
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a whole number");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            scanner.close();
        }

        /**
         * Exception
         *      Exception in thread "main" java.lang.ArithmeticException:
         *      / by zero
         * 
         * Caused by:
         *      int divisor = 0
         */

        /**
         * Exception
         *      Exception in thread "main" java.util.InputMismatchException
         * 
         * Caused by:
         *      int divident = "String"
         *      int divisor = "String"
         */
    }
}
