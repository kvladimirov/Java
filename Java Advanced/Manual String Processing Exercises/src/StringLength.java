import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        for(int i = 0; i < 20; i++) {
            if (i < input.length()) {
                System.out.print(input.charAt(i));
            } else {
                System.out.print('*');
            }
        }
    }
}
