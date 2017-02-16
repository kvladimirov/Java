import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        long n1 = 1;
        long n2 = 1;

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.add(n1);
        stack.add(n2);
        while(n > 1){
            long fib = stack.peek() + stack.pollLast();
            stack.push(fib);
            n--;
        }
        System.out.println(stack.poll());
    }
}
