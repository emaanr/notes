/**
 * WrapperClasses
 *      Class that demonstrates how Wrapper classes work.
 */
public class WrapperClasses {

    public static void main(String[] args) {
        
        // Using autoboxing to directly assign a primitive value to this reference data type
        Boolean b = true;
        Character c = 'C';
        Integer i = 25;
        Double d = 3.14;
        String s = "Emaan"; // Already a reference data type

        // Using unboxing to convert to a primitive
        if(b == true) {
            System.out.println(b);
        }

        // Some print statements to get rid of unused variable warnings
        System.out.println(c);
        System.out.println(i);
        System.out.println(d);
        System.out.println(s);
    }
}
