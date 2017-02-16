import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String > emails = new LinkedHashMap<>();

        while (true){
            String name = scanner.nextLine();
            if (name.equals("stop")){
                break;
            }
            String email = scanner.nextLine();
            if (email.toLowerCase().endsWith("us") ||
                    email.toLowerCase().endsWith("uk") ||
                    email.toLowerCase().endsWith("com")){
                continue;
            }
            emails.put(name, email);
        }

        for (String email : emails.keySet()) {
            System.out.println(email + " -> " + emails.get(email));
        }
    }
}
