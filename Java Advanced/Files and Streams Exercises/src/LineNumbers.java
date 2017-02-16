import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
public class LineNumbers {
    public static void main(String[] args){
        final String inputPat = "resources/Line Numbers/input.txt";
        final String outputPat = "resources/Line Numbers/output.txt";


        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPat));
            PrintWriter writer = new PrintWriter(outputPat)) {

            int counter = 1;
            String line = reader.readLine();

            while (line != null){
                writer.println(counter + "." + "  " + line);
                counter++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
