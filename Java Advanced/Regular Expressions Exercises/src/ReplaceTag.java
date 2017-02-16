import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        String line = "";

        while(!"END".equals(line = reader.readLine())){
            input.append(line).append("\r\n");
        }

        Pattern pattern = Pattern.compile("<a(\\s+href=[^>]+)>([^<]+)<\\/a>");
        Matcher matcher = pattern.matcher(input.toString().trim());

        while(matcher.find()){
            int startMatch = matcher.start();
            int endMatch = matcher.end();
            String replacement = createNewReplacement(matcher);
            input.replace(startMatch,endMatch,replacement);
            matcher = pattern.matcher(input);
        }
        System.out.println(input.toString());
    }

    private static String createNewReplacement(Matcher matcher){
        return"[URL" + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
    }
}
