/**
 * InnerClasses
 *      Class that demonstrates Inner Classes.
 */
public class InnerClasses {

    public static void main(String[] args) {

        Outside out = new Outside();
        Outside.Inside in = out.new Inside();

        // System.out.printf("%s %s", out.strout, in.strin);

        in.greeting();
    }
}

/**
 * Outer class of the Inside class.
 */
class Outside {

    // Attributes

    String strout = "Hello";

    /**
     * Inside 
     *      Inner class of the Outside class.
     */
    class Inside {

        // Attributes

        String strin = "World";

        // Methods

        /**
         * greeting
         *      Prints concatenation of Outside's 'strout'
         *      and Inside's 'strin' to the console.
         */
        public void greeting() {
            System.out.printf("%s %s", strout, strin);
        }
    }
}
