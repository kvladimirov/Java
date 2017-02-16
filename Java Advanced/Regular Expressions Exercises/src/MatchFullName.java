import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

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

