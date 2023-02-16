/**
 * Printf
 *      Class that demonstrates how printf() works.
 */
public class Printf {

    public static void main(String[] args) {

        boolean myBoolean = true;
        char myChar = 'E';
        String myString = "Emaan";
        int myInt = -25;
        double myDouble = 1031;

        // [conversion-character]
        System.out.print("\n[converstion-character]\n");
        System.out.printf("%b\n", myBoolean);
        System.out.printf("%c\n", myChar);
        System.out.printf("%s\n", myString);
        System.out.printf("%d\n", myInt);
        System.out.printf("%f\n", myDouble);
        System.out.printf("%b, %c, %s, %d, %f\n", myBoolean, myChar, myString, myInt, myDouble);

        // [width]
        System.out.print("\n[width]\n");
        System.out.printf("Hello %10s\n", myString);

        // [.precision]
        System.out.print("\n[.precision]\n");
        System.out.printf("%.2f\n", myDouble); // Float Precision
        System.out.printf("%.2s\n", myString); // String Precision

        // [flags]
        System.out.print("\n[flags]:\n");
        System.out.printf("Hello %-10s\n", myString); // Left-Justify
        System.out.printf("%+d\n", myInt); // Numeric Signage
        System.out.printf("%010d\n", myInt); // Numeric Zero-Padding
        System.out.printf("%,f\n", myDouble); // Numeric Comma Separation
    }
}
