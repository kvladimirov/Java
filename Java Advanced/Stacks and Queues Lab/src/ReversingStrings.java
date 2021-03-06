import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversingStrings {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> reversed = new ArrayDeque<>();

        for (Character ch : input.toCharArray()) {
            reversed.push(ch);
        }

        while (!reversed.isEmpty()) {
            System.out.print(reversed.pop());
        }
    }
}
