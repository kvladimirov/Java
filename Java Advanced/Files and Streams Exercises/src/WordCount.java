import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args){

        final String wordsPath = "resources/Word Count/words.txt";
        final String inputPath = "resources/Word Count/text.txt";
        final String outputPath = "resources/Word Count/results.txt";

        Map<String, Integer> words = new LinkedHashMap<>();
        Map<String, Integer> wordsSorted = new LinkedHashMap<>();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(wordsPath))) {
            String line = reader.readLine();

            while (line != null){
                String[] w = line.split(" ");
                for (String s : w) {
                    words.put(s.toLowerCase(), 0);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
            PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();

            while (line != null){

                String[] w = line.split(" ");
                for (String s : w) {
                    if(words.containsKey(s)){
                        words.put(s.toLowerCase(), words.get(s) + 1);
                    }
                }

                line = reader.readLine();
            }

            words.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                    .forEachOrdered(x -> wordsSorted.put(x.getKey(), x.getValue()));


            for (String s : wordsSorted.keySet()) {
                System.out.println(s + " -> " + wordsSorted.get(s));
                writer.println(s + " -> " + wordsSorted.get(s));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
