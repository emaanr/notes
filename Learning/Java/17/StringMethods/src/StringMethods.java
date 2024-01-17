/**
 * StringMethods
 *      Class that demonstrates some String class methods.
 */
public class StringMethods {

    public static void main(String[] args) {

        String name = "Emaan";

        // Assign result to boolean equals
        boolean equals = name.equals("Emaan");

        // Prints true
        System.out.println(equals);

        // Reassigning different result to boolean equals
        equals = name.equals("emaan");

        // Prints false because equals() is case sensitive
        System.out.println(equals);

        // Reassigning different result to boolean equals using different method
        equals = name.equalsIgnoreCase("emaan");

        // Prints true because equalsIgnoreCase() is not case sensitive
        System.out.println(equals);

        // Assign length of String to int length
        int length = name.length();

        // Prints 5
        System.out.println(length);

        // Assign char at index 0 to char charat
        char charat = name.charAt(0);

        // Prints char 'E'
        System.out.println(charat);

        // Reassign char at index that does not exist to char charat
        // charat = name.charAt(99);

        // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 99
        // System.out.println(charat);

        // Searches for first instance of char a and returns its index
        int index = name.indexOf("a");

        // Prints index 2
        System.out.println(index);

        // Reassigning int index with index of a different chararacter
        index = name.indexOf("e");

        // Prints -1 because index not found since indexOf() is case sensitive
        System.out.println(index);

        // Returns true if empty and false if not
        boolean empty = name.isEmpty();

        // Prints false
        System.out.println(empty);

        // Returns String in upper case
        String uppercase = name.toUpperCase();

        // Prints 'EMAAN'
        System.out.println(uppercase);

        // Returns String in lower case
        String lowercase = name.toLowerCase();

        // Prints 'emaan'
        System.out.println(lowercase);

        // New String variable with excess white space
        String spacename = "   Emaan   ";

        // Prints String spacename
        System.out.println(spacename);

        // Trims whitespace before and after
        spacename = spacename.trim();

        // Prints String spacename without excess white space
        System.out.println(spacename);

        // Replaces all instances of a character with another character
        String moon = name.replace('a', 'o');

        // Prints 'Emoon'
        System.out.println(moon);
    }
}
