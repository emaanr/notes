import java.util.Random;

/**
 * VariableScope
 *      Class that demonstrates variable scope.
 */
public class VariableScope {

    public static void main(String[] args) {

        // Prints actual values because it calls constructor
        DiceRoller roller = new DiceRoller();
        System.out.println(roller); // Print address
    }
}

/**
 * DiceRoller
 *      Class that rolls a dice.
 */
class DiceRoller {

    // Methods

    /**
     * DiceRoller
     *      Constructor for DiceRoller class that outputs rolls.
     */
    DiceRoller() {
        // Local
        Random local_random = new Random();
        int number = 0;
        local_roll(local_random, number); // Local Approach

        // Global
        global_random = new Random(); // Finish instantiating Global random
        global_roll(); // Global Approach
    }

    // Global Variables Approach

    // Attributes

    Random global_random;
    int number;

    /**
     * global_roll
     *      Method thats rolls a die globally.
     */
    void global_roll() {
        // 0 to 5 + 1 makes range 1 to 6
        number = global_random.nextInt(6) + 1;
        System.out.println(number);
    }

    // Local Variables Approach

    /**
     * local_roll
     *      Method that rolls a die locally.
     * 
     * Parameters:
     *      random Random
     *          Random object to pass as argument.
     *      number int
     *          Integer variable to pass in order
     *          to store the number rolled to print.
     * 
     * Note that int number = 0 outside of this method call.
     * It's value is updated solely during this method call.
     */
    void local_roll(Random random, int number) {
        number = random.nextInt(6) + 1; // 0 to 5 + 1 makes range 1 to 6
        System.out.println(number);
    }
}
