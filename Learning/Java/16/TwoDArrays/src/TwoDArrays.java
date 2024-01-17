/**
 * TwoDArrays
 *      Class that demonstrates how 2D Arrays work using MBTI and Enneagram examples.
 */
public class TwoDArrays {

    public static void main(String[] args) {

        String[][] mbti = new String[4][4]; // 2D Array of size 4 by 4

        // Alpha Quadra (Row 0)
        mbti[0][0] = "INTP";
        mbti[0][1] = "ENTP";
        mbti[0][2] = "ISFJ";
        mbti[0][3] = "ESFJ";

        // Beta Quadra (Row 1)
        mbti[1][0] = "INFJ";
        mbti[1][1] = "ENFJ";
        mbti[1][2] = "ISTP";
        mbti[1][3] = "ESTP";

        // Delta Quadra (Row 2)
        mbti[2][0] = "INFP";
        mbti[2][1] = "ENFP";
        mbti[2][2] = "ISTJ";
        mbti[2][3] = "ESTJ";

        // Gamma Quadra (Row 3)
        mbti[3][0] = "INTJ";
        mbti[3][1] = "ENTJ";
        mbti[3][2] = "ISFP";
        mbti[3][3] = "ESFP";

        for (int i = 0; i < mbti.length; i++) {
            // Labelling each element of the outer array
            if (i == 0) { // Test for equality using double ==
                System.out.println("Alpha Quadra:");
            } else if (i == 1) {
                System.out.println("\nBeta Quadra:");
            } else if (i == 2) {
                System.out.println("\nDelta Quadra:");
            } else if (i == 3) {
                System.out.println("\nGamma Quadra:");
            }
            // Printing inner array elements
            for (int j = 0; j < mbti[i].length; j++) {
                System.out.print(mbti[i][j] + " ");
            }
            System.out.println(); // Newline for each Array in the 2D Array
        }

        // Alternative Method for declaring 2D Array
        String enneagram[][] = {
                { "Eight", "Nine", "One" }, // Array of Gut Types
                { "Two", "Three", "Four" }, // Array of Heart Types
                { "Five", "Six", "Seven" } // Array of Head Types
        };

        System.out.println("\n" + enneagram + "\n"); // Prints address of the 2D Array

        for (int i = 0; i < enneagram.length; i++) {
            // Labelling each element of the outer array
            if (i == 0) { // Test for equality using double ==
                System.out.println("Enneagram Gut Types:");
            } else if (i == 1) {
                System.out.println("\nEnneagram Heart Types:");
            } else if (i == 2) {
                System.out.println("\nEnneagram Head Types:");
            }
            // Printing inner array elements
            for (int j = 0; j < enneagram[i].length; j++) {
                System.out.print(enneagram[i][j] + " ");
            }
            System.out.println(); // Newline for each Array in the 2D Array
        }
    }
}
