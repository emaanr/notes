/**
 * FinalKeyword
 *      Class that demonstrates how the 'final' keyword works.
 */
public class FinalKeyword {

    public static void main(String[] args) {

        double pi = 3.14159;

        pi = 4;

        System.out.println(pi);

        final double PI = 3.14159;

        // Throws an Error: The final local variable PI cannot be assigned
        //PI = 4;

        System.out.println(PI);
    }
}
