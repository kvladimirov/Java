
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {

    public static void main(String[] args){
        final String inputPath = "resources/input.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            String line = reader.readLine();

            long sum = 0;

            while (line != null){
                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = reader.readLine();
            }

            System.out.println(sum);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
