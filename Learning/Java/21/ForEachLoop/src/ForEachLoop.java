import java.util.ArrayList;

/**
 * ForEachLoop
 *      Class that demonstrates how to use a for-each loop.
 */
public class ForEachLoop {

    public static void main(String[] args) {

        String colorsArr[] = { "Red", "Orange", "Yellow", "Green", "Blue", "Violet" };
        System.out.println("Colors in Array:");
        for (String color : colorsArr) {
            System.out.println(color);
        }

        ArrayList<String> colorsArrList = new ArrayList<String>();
        colorsArrList.add("Violet");
        colorsArrList.add("Blue");
        colorsArrList.add("Green");
        colorsArrList.add("Yellow");
        colorsArrList.add("Orange");
        colorsArrList.add("Red");

        System.out.println("\nColors in ArrayList:");
        for (String color : colorsArrList) {
            System.out.println(color);
        }
    }
}
