/**
 * GenericClasses
 *      Class that demonstrates Generic Classes.
 */
public class GenericClasses {

    public static void main(String[] args) {

        /**
         * For this example, we will create instances of different classes
         * that will store different values and have different data types.
         */

        /**
         * Non-Generic Classes
         */
        // IntegerClass myInt = new IntegerClass(25);
        // DoubleClass myDouble = new DoubleClass(2.71828);
        // CharacterClass myChar = new CharacterClass('E');
        // StringClass myStr = new StringClass("Emaan");

        /**
         * Print out values of each Non-Generic Class
         */
        // System.out.println(myInt.getIntger());
        // System.out.println(myDouble.getDouble());
        // System.out.println(myChar.getCharacter());
        // System.out.println(myStr.getString());

        /**
         * Generic Classes
         */
        GenericClass<Integer> myInt = new GenericClass<Integer>(25);
        GenericClass<Double> myDouble = new GenericClass<Double>(2.71828);
        GenericClass<Character> myChar = new GenericClass<Character>('E');
        GenericClass<String> myStr = new GenericClass<String>("Emaan");

        /**
         * Print out values of each Generic Class
         */
        System.out.println(myInt.getGeneric());
        System.out.println(myDouble.getGeneric());
        System.out.println(myChar.getGeneric());
        System.out.println(myStr.getGeneric());

        /**
         * Generic Classes with 2 Parameters
         */
        GenericClass2<String, Character> myStrChar = new GenericClass2<String, Character>("Emaan", 'E');

        /**
         * Print out T and V values of each Generic Class with two parameters
         */
        System.out.printf("%s, %s\n", myStrChar.getT(), myStrChar.getV());

        /**
         * Generic Classes that accept bounded parameter types that extend the 'Number' class
         */
        GenericClassBounded<Integer, Integer> myIntInt = new GenericClassBounded<Integer, Integer>(10, 31);
        GenericClassBounded<Double, Double> myDubDub = new GenericClassBounded<Double, Double>(3.141592, 2.718281);

        /**
         * Print out T and N values of each Generic Class with bounded parameter types that extend the 'Number' class
         */
        System.out.printf("%d, %d\n", myIntInt.getT(), myIntInt.getN());
        System.out.printf("%f, %f\n", myDubDub.getT(), myDubDub.getN());
    }
}

/**
 * GenericClass
 *      Generic class that can store any type T.
 */
class GenericClass<T> {

    // Attributes

    T t;

    // Methods

    /**
     * GenericClass
     *      Constructor of the GenericClass.
     * 
     * @param t T
     *      Type T parameter.
     */
    GenericClass(T t) {
        this.t = t;
    }

    /**
     * getGeneric
     *      Gets t of type T.
     * 
     * @return t T
     *      Returns t of type T.
     */
    public T getGeneric() {
        return t;
    }
}

/**
 * GenericClass2
 *      Another generic class that can store any two types T and V.
 */
class GenericClass2<T, V> {

    // Attributes

    T t;
    V v;

    // Methods

    /**
     * GenericClass2
     *      Constructor of the GenericClass2.
     * 
     * @param t T
     *      Type T parameter.
     * @param v V
     *      Type V parameter.
     */
    GenericClass2(T t, V v) {
        this.t = t;
        this.v = v;
    }

    /**
     * getT
     *      Gets t of type T.
     * 
     * @return t T
     *      Returns t of type T.
     */
    public T getT() {
        return t;
    }

    /**
    * getV
    *      Gets v of type V.
    * 
    * @return v V
    *      Returns v of type V.
    */
    public V getV() {
        return v;
    }
}

/**
 * GenericClassBounded
 *      Another generic class that can store any two types T and N
 *      such that both types are of some derived type. In this case,
 *      the specified derived type is the 'Number' class in Java.
 */
class GenericClassBounded<T extends Number, N extends Number> {

    // Attributes

    T t;
    N n;

    // Methods

    /**
     * GenericClassBounded
     *      Constructor of the GenericClassBounded.
     * 
     * @param t T
     *      Type T parameter.
     * @param n N
     *      Type N parameter.
     */
    GenericClassBounded(T t, N n) {
        this.t = t;
        this.n = n;
    }

    /**
     * getT
     *      Gets t of type T.
     * 
     * @return t T
     *      Returns t of type T.
     */
    public T getT() {
        return t;
    }

    /**
    * getN
    *      Gets n of type N.
    * 
    * @return n N
    *      Returns n of type N.
    */
    public N getN() {
        return n;
    }
}

// /**
//  * IntegerClass
//  *      Stores a single Integer.
//  */
// class IntegerClass {

//     // Attributes

//     Integer i;

//     // Methods

//     /**
//      * IntegerClass
//      *      Constructor of the IntegerClass.
//      * 
//      * @param i Integer
//      *      Integer parameter.
//      */
//     IntegerClass(Integer i) {
//         this.i = i;
//     }

//     /**
//      * getInteger
//      *      Gets the Integer i.
//      * 
//      * @return i Integer
//      *      Returns i of type Integer.
//      */
//     public Integer getIntger() {
//         return i;
//     }
// }

// /**
//  * DoubleClass
//  *      Stores a single Double.
//  */
// class DoubleClass {

//     // Attributes

//     Double d;

//     // Methods

//     /**
//      * DoubleClass
//      *      Constructor of the DoubleClass.
//      * 
//      * @param d Double
//      *      Double parameter.
//      */
//     DoubleClass(Double d) {
//         this.d = d;
//     }

//     /**
//      * getDouble
//      *      Gets the Double d.
//      * 
//      * @return d Double
//      *      Returns d of type Double.
//      */
//     public Double getDouble() {
//         return d;
//     }
// }

// /**
//  * CharacterClass
//  *      Stores a single Character.
//  */
// class CharacterClass {

//     // Attributes

//     Character c;

//     // Methods

//     /**
//      * CharacterClass
//      *      Constructor of the CharacterClass.
//      * 
//      * @param c Character
//      *      Character parameter.
//      */
//     CharacterClass(Character c) {
//         this.c = c;
//     }

//     /**
//      * getCharacter
//      *      Gets the Character c.
//      * 
//      * @return c Character
//      *      Returns c of type Character.
//      */
//     public Character getCharacter() {
//         return c;
//     }
// }

// /**
//  * StringClass
//  *      Stores a single String.
//  */
// class StringClass {

//     // Attributes

//     String s;

//     // Methods

//     /**
//      * StringClass
//      *      Constructor of the StringClass.
//      * 
//      * @param s String
//      *      String parameter.
//      */
//     StringClass(String s) {
//         this.s = s;
//     }

//     /**
//      * getString
//      *      Gets the String s.
//      * 
//      * @return s String
//      *      Returns s of type String.
//      */
//     public String getString() {
//         return s;
//     }
// }
