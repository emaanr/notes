import javax.swing.JOptionPane;

/**
 * GUI
 *      Class that demonstrates how to use some GUI in Java.
 */
public class GUI {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Hello " + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        JOptionPane.showMessageDialog(null, "You are " + age + " years old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height in inches"));
        JOptionPane.showMessageDialog(null, "Your are " + height + " inches tall");
    }
}
