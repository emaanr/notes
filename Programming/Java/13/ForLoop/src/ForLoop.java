/**
 * ForLoop
 *      Class that demonstrates how for-loops work.
 */
public class ForLoop {

    public static void main(String[] args) {

        // 0 to 10 will run 11 times
        for (int i = 0; i <= 10; i++) {
            System.out.println("Iteration number " + (int) (i + 1));
        }

        // 1 to 10 will run 10 times
        for (int i = 1; i <= 10;) {
            System.out.println("Iteration number " + i);
            i++; // We can move the Post-Condition into the code block itself
        }
    }
}
