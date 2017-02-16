import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("search") || input.toLowerCase().equals("stop")) {
                break;
            }
            String[] info = input.split("-");
            phonebook.put(info[0], info[1]);
        }

        while (true) {
            String input = scanner.nextLine();
            if ("stop".equals(input)) {
                break;
            }
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));

            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
