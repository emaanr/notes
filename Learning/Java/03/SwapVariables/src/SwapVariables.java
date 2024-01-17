/**
 * SwapVariables
 *      Class that demonstrates how to correctly swap the contents of two variables in Java.
 */
public class SwapVariables {

    public static void main(String[] args) {

        String x = "White";
        String y = "Red";

        System.out.println("After assigning x to be White and y to be Red");
        System.out.println("Contents of x: " + x);
        System.out.println("Contents of y: " + y);

        // x = y; // Now x is pointing to "Red"

        // System.out.println("\nAfter assigning x = y");
        // System.out.println("Contents of x: " + x); // Red
        // System.out.println("Contents of y: " + y); // Red

        // y = x; // Now y is pointing to "White"

        // System.out.println("\nAfter assigning y = x");
        // System.out.println("Contents of x: " + x); // White
        // System.out.println("Contents of y: " + y); // White

        String temp; // Could assign this to null or ""

        temp = x; // Now temp is pointing to "White"

        System.out.println("\nAfter assigning temp to be x");
        System.out.println("Contents of temp: " + temp);
        System.out.println("Contents of x: " + x);
        System.out.println("Contents of y: " + y);

        x = y; // Now x is pointing to "Red"

        System.out.println("\nAfter assigning x = y");
        System.out.println("Contents of temp: " + temp);
        System.out.println("Contents of x: " + x);
        System.out.println("Contents of y: " + y);

        y = temp; // Now y is pointing to "White"

        System.out.println("\nAfter assigning x = y");
        System.out.println("Contents of temp: " + temp);
        System.out.println("Contents of x: " + x);
        System.out.println("Contents of y: " + y);

        System.out.println("\nContents of variables x and y have been swapped");
        System.out.println("Contents of x: White -> " + x);
        System.out.println("Contents of y: Red -> " + y);
    }
}
