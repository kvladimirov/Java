import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> doMagic = (x, y) -> x % y != 0;

        Consumer<int[]> printThem = x -> {
            StringBuilder sb = new StringBuilder();

            for (int i = x.length - 1; i >= 0; i--) {
                if(doMagic.test(x[i], n)){
                    sb.append(x[i]).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        };

        printThem.accept(numbers);
    }
}
