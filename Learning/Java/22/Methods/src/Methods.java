/**
 * Methods
 *      Class that demonstrates how methods work.
 */
public class Methods {

    public static void main(String[] args) {

        hello();

        String name = "Emaan";
        String myName = "Emaan";

        helloName("Emaan");
        helloName(name);

        // Note that the passed argument is not called "name"
        // You can pass any argument of data type 'String' to the method
        helloName(myName);

        int age = 23;

        helloNameAge(name, age);

        // Integer Return Type Example
        int x = 3;
        int y = 4;

        sum(x, y); // This does not output to console, it simply runs its code

        int sum = sum(x, y); // This actually stores the returned value so we can call it later
        System.out.println(sum);

        // We could also print it directly without storing the value
        // Lifespan of the result exists in the following line of code only since we don't store it anywhere
        System.out.println(sum(20, 5));
    }

    /**
     * hello
     *      Method that prints "Hello" to console.
     */
    static void hello() {
        System.out.println("Hello");
    }

    /**
     * helloName
     *      Method that prints "Hello (name)" to console.
     * 
     * Parameters:
     *      name String
     *          Name to print to console.
     * 
     * Parameter is called 'name' locally. But we could call it
     * anything so long as we use the same name in the code block.
     */
    static void helloName(String name) {
        System.out.println("Hello " + name);
    }

    /**
     * helloNameAge
     *      Method that prints
     *          "Hello (name) you are (age) years old"
     *      to console.
     * 
     * Parameters:
     *      name String
     *          Name to print to console.
     *      age int
     *          Age to print to console.
     */
    static void helloNameAge(String name, int age) {
        System.out.println("Hello " + name + ", you are " + age + " years old");
    }

    /**
     * sum
     *      Method that sums two integers.
     * 
     * Parameters:
     *      x int
     *          First integer to sum.
     *      y int
     *          Second integer to sum.
     */
    static int sum(int x, int y) {
        return x + y;
        // int z = x + y
        // return z
    }

}
