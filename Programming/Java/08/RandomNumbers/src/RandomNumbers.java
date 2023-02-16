import java.util.Random;

/**
 * RandomNumbers
 *      Class that demonstrates how to generate randomness in a program.
 */
public class RandomNumbers {

    public static void main(String[] args) {

        Random random = new Random();

        // nextInt()
        int x = random.nextInt();
        System.out.println("Random integer x is " + x);

        // This will generate from 0 to 5, fix this by incrementing by 1
        int x_die = random.nextInt(6) + 1;
        System.out.println("Random integer x_die roll is " + x_die);

        // nextDouble()
        double y = random.nextDouble();
        System.out.println("Random double y is " + y);

        // nextBoolean()
        boolean z = random.nextBoolean();
        System.out.println("Random boolean z is " + z);
    }
}
