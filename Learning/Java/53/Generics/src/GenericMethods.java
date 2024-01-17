/**
 * GenericMethods
 *      Class that demonstrates Generic Methods.
 */
public class GenericMethods {

    public static void main(String[] args) {

        // Arrays of different Reference Types
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 5.5, 4.4, 3.3, 2.2, 1.1 };
        Character[] charArray = { 'E', 'M', 'A', 'A', 'N' };
        String[] strArray = { "R", "A", "N", "A" };

        // displayArray
        displayArray(intArray);
        displayArray(doubleArray);
        displayArray(charArray);
        displayArray(strArray);

        // getFirst
        System.out.println(getFirst(intArray));
        System.out.println(getFirst(doubleArray));
        System.out.println(getFirst(charArray));
        System.out.println(getFirst(strArray));
    }

    /**
     * displayArray
     *      Displays the array to console.
     * 
     * @param <T>
     *      Type of the Array
     * @param array T[]
     *      Array of type T
     */
    public static <T> void displayArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * getFirst
     *      Returns the first element of the array argument.
     * 
     * @param <T>
     *      Type of the Array
     * @return T
     *      Type T
     */
    public static <T> T getFirst(T[] array) {
        return array[0];
    }

    // /**
    //  * displayArray
    //  *      Displays the array to console.
    //  * 
    //  * @param array Integer[]
    //  *      Array of Integers
    //  */
    // public static void displayArray(Integer[] array) {
    //     for (Integer i : array) {
    //         System.out.print(i + " ");
    //     }
    //     System.out.println();
    // }

    //  /**
    //  * displayArray
    //  *      Displays the array to console.
    //  * 
    //  * @param array Double[]
    //  *      Array of Doubles
    //  */
    // public static void displayArray(Double[] array) {
    //     for (Double d : array) {
    //         System.out.print(d + " ");
    //     }
    //     System.out.println();
    // }

    //  /**
    //  * displayArray
    //  *      Displays the array to console.
    //  * 
    //  * @param array Character[]
    //  *      Array of Characters
    //  */
    // public static void displayArray(Character[] array) {
    //     for (Character c : array) {
    //         System.out.print(c + " ");
    //     }
    //     System.out.println();
    // }

    //  /**
    //  * displayArray
    //  *      Displays the array to console.
    //  * 
    //  * @param array String[]
    //  *      Array of String
    //  */
    // public static void displayArray(String[] array) {
    //     for (String s : array) {
    //         System.out.print(s + " ");
    //     }
    //     System.out.println();
    // }
}
