import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);
        Consumer<int[]> printThem = x -> {
            StringBuilder sb = new StringBuilder();
            for (int aX : x) {
                if(aX % 2 == 0) {
                    sb.append(aX).append(" ");
                }
            }
            for (int aX : x) {
                if(aX % 2 != 0) {
                    sb.append(aX).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        };

        printThem.accept(numbers);
    }
}
