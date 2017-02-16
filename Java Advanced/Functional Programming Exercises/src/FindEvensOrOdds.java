import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNumbersRange = reader.readLine().split("\\s+");

        int startN = Integer.parseInt(inputNumbersRange[0]);
        int endN = Integer.parseInt(inputNumbersRange[1]);

        String oddOrEven = reader.readLine();

        Predicate<Integer> tester = createTester(oddOrEven);
        Consumer<Integer> print = x -> System.out.print(x + " ");

        for (int i = startN; i <= endN; i++) {
            if (tester.test(i)) {
                print.accept(i);
            }
        }

    }

    private static Predicate<Integer> createTester(String oddOrEven) {
        switch (oddOrEven) {
            case "odd":
                return x -> x % 2 != 0;
            case "even":
                return x -> x % 2 == 0;
            default:
                return null;
        }
    }
}
