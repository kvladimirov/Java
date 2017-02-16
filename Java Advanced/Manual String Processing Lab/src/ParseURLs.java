import java.util.Scanner;

public class ParseURLs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] reminder = input.split("://");
        if(reminder.length != 2){
            System.out.println("Invalid URL");
        } else {
            System.out.println(String.format("Protocol = %s", reminder[0]));
            int index = reminder[1].indexOf("/");
            String server = String.format("Server = %s", reminder[1].substring(0, index));
            System.out.println(server);
            String resources = String.format("Resources = %s", reminder[1].substring(index + 1));
            System.out.println(resources);
        }
    }
}
