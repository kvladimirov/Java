import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] censoredStrings = reader.readLine().split(", ");
        String text = reader.readLine();
        for (String word : censoredStrings) {
            text = text.replaceAll(word, new String(new char[word.length()]).replace('\0', '*'));
        }
        System.out.println(text);
    }
}
