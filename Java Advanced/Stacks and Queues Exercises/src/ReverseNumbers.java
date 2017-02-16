import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> reversed = new ArrayDeque<>();

        for (String str : input) {
            reversed.push(Integer.parseInt(str));
        }

        while (!reversed.isEmpty()) {
            System.out.print(reversed.pop() + " ");
        }
    }
}
