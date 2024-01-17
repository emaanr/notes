import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileReaders
 *      Class that demonstrates the FileReader class in Java.
 */
public class FileReaders {

    public static void main(String[] args) {

        /**
         * Need to set the Filepath relative to the Current Working Directory.
         * In VSCode, it seems the CWD is set to whatever folder is selected
         * in the Workspace GUI.
         */
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            FileReader reader = new FileReader("src/art.txt");
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}