/**
 * MethodChaining
 *      Class that demonstrates method chaining.
 */
public class MethodChaining {

    public static void main(String[] args) {

        // Three method calls

        String name = "   Emaan";

        System.out.println("Three method calls:");

        name = name.concat(" Rana   ");

        System.out.println(name);

        name = name.toUpperCase();

        System.out.println(name);

        name = name.trim();

        System.out.println(name);

        // Same three method calls using method chaining

        String chainName = "   Emaan";

        System.out.println("\nSame three method calls using method chaining:");

        chainName = chainName.concat(" Rana   ").toUpperCase().trim();

        System.out.println(chainName);
    }
}
