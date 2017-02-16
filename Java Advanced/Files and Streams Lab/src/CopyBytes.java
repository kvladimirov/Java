import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = "resources/03input.txt";
        String outputPath = "resources/03output.txt";

        try (InputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                    fos.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (char c : digits.toCharArray()) {
                        fos.write(c);
                    }
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}