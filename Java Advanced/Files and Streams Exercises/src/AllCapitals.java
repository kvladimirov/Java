
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class AllCapitals {
    public static void main(String[] args){
        final String inputPath = "resources/ALL CAPITALS/input.txt";
        final String outputPath = "resources/ALL CAPITALS/output.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = reader.readLine();
            while (line != null){
                for (char c : line.toCharArray()) {
                    writer.print(Character.toUpperCase(c));
                }
                writer.println();

                line = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
