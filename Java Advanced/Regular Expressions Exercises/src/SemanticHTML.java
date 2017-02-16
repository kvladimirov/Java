import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern openDiv = Pattern.compile("(<div).*?(\\s*(?:id|class)(?:\\s*=\\s*\")(\\w+)\")");
        Pattern closeDiv = Pattern.compile("(<\\/div>\\s*<!--\\s*(\\w+)\\s*-->)");

        String input = "";
        while (!"END".equals(input = reader.readLine())){
            Matcher openMatch = openDiv.matcher(input);
            Matcher closeMatch = closeDiv.matcher(input);

            while (openMatch.find()){
                input = input.replace(openMatch.group(1), "<" + openMatch.group(3));
                input = input.replace(openMatch.group(2), "");
                input = input.replaceAll("\\s+>", ">");
                input = input.replaceAll("\\s+", " ");
            }
            while (closeMatch.find()){
                input = input.replace(closeMatch.group(1), "</" + closeMatch.group(2) + ">");
            }
            System.out.println(input);
        }
    }
}
