import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxNumbers = new ArrayDeque<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            switch (command) {
                case "1":
                    int num = Integer.parseInt(input[1]);
                    if (num > max) {
                        max = num;
                        maxNumbers.push(num);
                    }
                    stack.push(num);
                    break;
                case "2":
                    int currNum = stack.pop();
                    if (currNum == max) {
                        maxNumbers.pop();
                        if (!maxNumbers.isEmpty()) {
                            max = maxNumbers.peek();
                        } else {
                            max = Integer.MIN_VALUE;
                        }
                    }

                    break;
                case "3":
                    System.out.println(maxNumbers.peek());
                    break;
            }
        }
    }
}
