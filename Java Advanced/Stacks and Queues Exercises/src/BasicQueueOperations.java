import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(commands[0]);
        int S = Integer.parseInt(commands[1]);
        String X = commands[2];

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.add(numbers[i]);
        }

        for (int i = 0; i < S; i++) {
            stack.poll();
        }

        for (String s : stack) {
            if (s.equals(X)) {
                System.out.println("true");
                return;
            }
        }

        if (stack.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
