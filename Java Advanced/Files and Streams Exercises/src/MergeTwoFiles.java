import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MergeTwoFiles {
    public static void main(String[] args){
        final String file1 = "resources/Merge Two Files/file1.txt";
        final String file2 = "resources/Merge Two Files/file2.txt";
        final String output = "resources/Merge Two Files/output.txt";

        ArrayList<String> strings = new ArrayList<>();

        try(BufferedReader firstReader = Files.newBufferedReader(Paths.get(file1));
        BufferedReader secondReader = Files.newBufferedReader(Paths.get(file2));
        PrintWriter writer = new PrintWriter(output)) {

            String line = firstReader.readLine();
            while (line != null){
                strings.add(line);
                line = firstReader.readLine();
            }

            line = secondReader.readLine();
            while (line != null){
                strings.add(line);
                line = secondReader.readLine();
            }

            for (String string : strings) {
                writer.println(string);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
