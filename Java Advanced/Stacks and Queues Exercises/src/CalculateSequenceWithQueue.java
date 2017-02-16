import java.util.ArrayDeque;
import java.util.Scanner;

public class CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.add(n);

        for (int i = 0; i < 50; i++) {

            long s = stack.peek();
            System.out.print(stack.poll() + " ");
            stack.add(s + 1);
            stack.add(s * 2 + 1);
            stack.add(s + 2);
        }
    }
}
