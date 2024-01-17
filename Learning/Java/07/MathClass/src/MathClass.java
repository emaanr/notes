import java.util.Scanner;

/**
 * MathClass
 *      Class that demonstrates some functionalities of the Math Class.
 */
public class MathClass {

    public static void main(String[] args) {

        double x = 3.14;
        double y = -3.14;

        // max()
        Math.max(x, y);
        System.out.println(x + " is greater than " + y);

        // min()
        Math.min(x, y);
        System.out.println(y + " is less than " + x);

        // abs()
        double y_abs = Math.abs(y);
        System.out.println("Absolute value of y = -3.14 is " + y_abs);

        // sqrt()
        double z = 25;
        double z_sqrt = Math.sqrt(z);
        System.out.println("Square root of z = 25 is " + z_sqrt);

        // round()
        double x_round = Math.round(x);
        System.out.println(x + " rounded is " + x_round);

        // ceil()
        double x_ceil = Math.ceil(x);
        System.out.println("Ceil of x = 3.14 is " + x_ceil);

        // floor()
        double x_floor = Math.floor(x);
        System.out.println("Floor of x = 3.14 is " + x_floor);

        // Hypotenuse Calculator
        double s1; // Side 1
        double s2; // Side 2
        double h; // Hypotenuse

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter length of first side: ");
        s1 = scanner.nextDouble();

        System.out.print("Enter length of second side: ");
        s2 = scanner.nextDouble();

        h = Math.sqrt((x * x) + (y * y));
        System.out.println("Hypotenuse of a triangle with side 1 = " + s1 + " and side 2 = " + s2 + " is: " + h);

        scanner.close();
    }
}
