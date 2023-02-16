/**
 * StaticKeyword
 *      Class that demonstrates the 'static' keyword.
 */
public class StaticKeyword {

    public static void main(String[] args) {

        System.out.printf("Static Friends: %s\n", Friend.staticFriends);
        System.out.printf("Non-Static Friends: %s\n", Friend.staticFriends);

        Friend friend1 = new Friend("Friend1");
        System.out.printf("\nStatic Friends: %s\n", Friend.staticFriends);
        System.out.printf("Non-Static Friends: %s\n", friend1.nonStaticFriends);

        Friend friend2 = new Friend("Friend2");
        System.out.printf("\nStatic Friends: %s\n", Friend.staticFriends);
        System.out.printf("Non-Static Friends: %s\n", friend2.nonStaticFriends);

        Friend.instances();

        /**
         * Warning
         *      The static field Friend.numberOfFriends
         *      should be accessed in a static way.
         * 
         * Caused by:
         *      friend1.numberOfFriends
         *      friend2.numberOfFriends
         */

        /**
         * Warning
         *      Cannot make a static reference to
         *      the non-static field Friend.nonStaticFriends
         * 
         * Caused by:
         *      Friend.nonStaticFriends
         */
    }
}

/**
 * Friend
 *      Class that creates a friend and tracks static and
 *      non-static number of friends.
 */
class Friend {

    // Attributes/Fields

    String name;
    static int staticFriends;
    int nonStaticFriends;

    // Methods

    /**
     * Friend
     *      Friend constructor that takes one argument.
     *      Increments static and non-static number of friends.
     * 
     * Parameters:
     *      name String
     *          The name of the friend.
     */
    Friend(String name) {
        this.name = name;
        staticFriends++;
        nonStaticFriends++;
    }

    /**
     * instances
     *      Outputs number of static friends, that is, how many
     *      instances of the Friend object exists.
     */
    static void instances() {
        System.out.printf("\nInstances of Friend Object: %s\n", Friend.staticFriends);
    }
}