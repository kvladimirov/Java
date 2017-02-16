import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input = reader.readLine();

        while (!"END".equals(input)){
            sb.append(input);
            input = reader.readLine();
        }

        String str = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)|([^\\s>]+))[^>]*>";
        Pattern pattern = Pattern.compile(str);
        Matcher m = pattern.matcher(sb);
        while (m.find()) {
            for (int i = 5; i >= 0; i--) {
                if (m.group(i) != null) {
                    System.out.println(m.group(i));
                    break;
                }
            }
        }
    }
}
