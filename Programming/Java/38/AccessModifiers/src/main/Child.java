package main;

import other.*;

/**
 * Child
 *      Class that demonstrates permission granted by access modifiers for subclasses.
 */
public class Child extends Parent {

    public static void main(String[] args) {

        System.out.println(AccessModifiers.defaultMessage);
        System.out.println(AccessModifiers.protectedMessage);
    }
}
