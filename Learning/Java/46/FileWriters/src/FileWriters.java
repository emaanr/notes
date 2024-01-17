import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriters
 *      Class that demonstrates the FileWriter class in Java.
 */
public class FileWriters {

    public static void main(String[] args) {

        /**
         * Need to set the Filepath relative to the Current Working Directory.
         * In VSCode, it seems the CWD is set to whatever folder is selected
         * in the Workspace GUI.
         */
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            FileWriter writer = new FileWriter("src/poem.txt");
            writer.write(
                    "The shopping mall melts in the evening sun.\nLights in the summer night make a false start in the evening sunset.\n");
            writer.append("\nFrom \"Words Bubble Up Like Soda Pop\"");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}