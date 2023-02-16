/**
 * OverloadedMethods
 *      Class that demonstrates how overloaded methods work.
 */
public class OverloadedMethods {

    public static void main(String[] args) {

        // Overloaded Method #1
        int x_int = add(1, 2);
        System.out.println(x_int);

        // Overloaded Method #2
        int y_int = add(1, 2, 3);
        System.out.println(y_int);

        // Overloaded Method #3
        int z_int = add(1, 2, 3, 4);
        System.out.println(z_int);

        // Overloaded Method #4
        double x_double = add(1.0, 2.0);
        System.out.println(x_double);

        // Overloaded Method #5
        double y_double = add(1.0, 2.0, 3.0);
        System.out.println(y_double);

        // Overloaded Method #6
        double z_double = add(1.0, 2.0, 3.0, 4.0);
        System.out.println(z_double);

        /**
         * Note that if we call add() with int parameters
         * and assign it to a variable of type double, the
         * method call will be one of the Overloaded Methods
         * #1 through #3 whose return of type int will be
         * converted to a double by the compiler.
         */

        // Overloaded Method #1
        double x_int_to_double = add(1, 2);
        System.out.println(x_int_to_double);

        // Overloaded Method #2
        double y_int_to_double = add(1, 2, 3);
        System.out.println(y_int_to_double);

        // Overloaded Method #3
        double z_int_to_double = add(1, 2, 3, 4);
        System.out.println(z_int_to_double);
    }

    /**
     * add
     *      Method that adds two integers.
     * 
     * Parameters:
     *      a int
     *          First integer to add.
     *      b int
     *          Second integer to add.
     */
    static int add(int a, int b) {
        System.out.println("Overloaded Method #1");
        return a + b;
    }

    /**
     * add
     *      Method that adds three integers.
     * 
     * Parameters:
     *      a int
     *          First integer to add.
     *      b int
     *          Second integer to add.
     *      c int
     *          Third integer to add.
     */
    static int add(int a, int b, int c) {
        System.out.println("Overloaded Method #2");
        return a + b + c;
    }

    /**
     * add
     *      Method that adds four integers.
     * 
     * Parameters:
     *      a int
     *          First integer to add.
     *      b int
     *          Second integer to add.
     *      c int
     *          Third integer to add.
     *      d int
     *          Fourth integer to add.
     */
    static int add(int a, int b, int c, int d) {
        System.out.println("Overloaded Method #3");
        return a + b + c + d;
    }

    /**
     * add
     *      Method that adds two doubles.
     * 
     * Parameters:
     *      a double
     *          First double to add.
     *      b double
     *          Second double to add.
     */
    static double add(double a, double b) {
        System.out.println("Overloaded Method #4");
        return a + b;
    }

    /**
     * add
     *      Method that adds three doubles.
     * 
     * Parameters:
     *      a double
     *          First double to add.
     *      b double
     *          Second double to add.
     *      c double
     *          Third double to add.
     */
    static double add(double a, double b, double c) {
        System.out.println("Overloaded Method #5");
        return a + b + c;
    }

    /**
     * add
     *      Method that adds four doubles.
     * 
     * Parameters:
     *      a double
     *          First double to add.
     *      b double
     *          Second double to add.
     *      c double
     *          Third double to add.
     *      d double
     *          Fourth double to add.
     */
    static double add(double a, double b, double c, double d) {
        System.out.println("Overloaded Method #6");
        return a + b + c + d;
    }
}
