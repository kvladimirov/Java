import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputText = new StringBuilder();

        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)[^a-zA-Z\\+]*?(?=\\+|[0-9]{2})([0-9\\+]{0,1}[0-9][0-9\\/(). -]*[0-9])");

        String line = "";
        while (!"END".equals(line = reader.readLine())) {
            inputText.append(line);
        }

        String text = inputText.toString();
        Matcher matcher = pattern.matcher(text);
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();

        while (matcher.find()) {
            String name = matcher.group(1);
            String phoneNumber = matcher.group(2);
            phoneNumber = phoneNumber.replace("(", "");
            phoneNumber = phoneNumber.replace(")", "");
            phoneNumber = phoneNumber.replace("/", "");
            phoneNumber = phoneNumber.replace(".", "");
            phoneNumber = phoneNumber.replace("-", "");
            phoneNumber = phoneNumber.replace(" ", "");
            phoneBook.put(name, phoneNumber);
        }


        int cntPrinted = 0;
        if (!phoneBook.isEmpty()) {
            System.out.print("<ol>");
            for (String s : phoneBook.keySet()) {
                if (cntPrinted < phoneBook.size()-1) {
                    System.out.printf("<li><b>%1$s:</b> %2$s</li>", s, phoneBook.get(s));
                    cntPrinted++;
                } else {
                    System.out.printf("<li><b>%1$s:</b> %2$s</li></ol>", s, phoneBook.get(s));
                }
            }
        } else {
            System.out.println("<p>No matches!</p>");
        }
    }
}
