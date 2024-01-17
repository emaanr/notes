import java.util.Scanner;

/**
 * NestedLoops
 *      Class that demonstrates how nested loops work.
 */
public class NestedLoops {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows;
        int columns;
        String symbol = "";

        System.out.print("Enter # of Rows: ");
        rows = scanner.nextInt();

        System.out.print("\nEnter # of Columns: ");
        columns = scanner.nextInt();

        System.out.print("\nEnter symbol to use: ");
        symbol = scanner.next();

        scanner.close();

        // For every row we will fill some number of columns
        for (int i = 1; i <= rows; i++) {
            System.out.println();
            for (int j = 1; j <= columns; j++) {
                System.out.print(symbol);
            }
        }
    }
}
