import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}$";

        Pattern pattern = Pattern.compile(regex);

        String input = reader.readLine();

        while (!input.equals("end")) {
            Matcher match = pattern.matcher(input);
            if (match.find()) {
                System.out.println(match.group());
            }
            input = reader.readLine();
        }
    }
}
