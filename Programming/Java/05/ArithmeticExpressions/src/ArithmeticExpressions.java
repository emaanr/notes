/**
 * ArithmeticExpressions
 *      Class that demonstrates common arithmetic expressions.
 */
public class ArithmeticExpressions {

    public static void main(String[] args) {

        int x = 1; // x is 1

        System.out.println("Variable x is " + x);

        x++; // x is 2

        System.out.println("After doing x++, Variable x is " + x);

        x = x * 5; // x is 10

        System.out.println("After doing x = x * 5, Variable x is " + x);

        x *= 2; // x is 20

        System.out.println("After doing x *= 2, Variable x is " + x);

        x = x / 4; // x = 5

        System.out.println("After doing x = x / 4, Variable x is " + x);

        x = x % 3; // x = 2

        System.out.println("After doing x = x % 3, Variable x is " + x);

        x += 98; // x = 100

        System.out.println("After doing x += 98, Variable x is " + x);

        x %= 15; // x = 10

        System.out.println("After doing x %= 15, Variable x is " + x);

        x /= 2; // x = 5

        System.out.println("After doing x /= 2, Variable x is " + x);
    }
}
