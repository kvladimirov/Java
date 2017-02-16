import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;

public class WriteToAFile {
    public static void main(String[] args) {
        String inputPath = "resources/02input.txt";
        String outputPath = "resources/02output.txt";

        HashSet<Character> punctoation = new HashSet<>();
        Collections.addAll(punctoation, '.', ',', '!', '?');
        try (InputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if(!punctoation.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
