import java.io.File;

/**
 * FileClass
 *      Class that demonstrates the File class in Java.
 */
public class FileClass {

    public static void main(String[] args) {

        /**
         * Need to set the Filepath relative to the Current Working Directory.
         * In VSCode, it seems the CWD is set to whatever folder is selected
         * in the Workspace GUI.
         */
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        File file = new File("src/file.txt");

        if (file.exists()) {
            System.out.println("File exists");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
            // System.out.println(file.delete());
        } else {
            System.out.println("File not found");
        }
    }
}
