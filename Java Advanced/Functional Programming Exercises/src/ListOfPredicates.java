import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] numbersArray = reader.readLine().split(" ");

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String numStr : numbersArray) {
            numbers.add(Integer.parseInt(numStr));
        }

        Consumer<String> printThem = x -> System.out.println(x);

        BiFunction<List<Integer>, Integer, String> predicates = (x, y) -> {

            BiPredicate<Integer, Integer> doMagic = (a, b) -> a % b == 0;

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= y; i++) {
                int counter = 0;
                for (Integer aX : x) {
                    if (doMagic.test(i, aX)) {
                        counter++;
                    }
                }
                if (counter == x.size()) {
                    sb.append(i).append(" ");
                }
            }
            return sb.toString().trim();
        };

        printThem.accept(predicates.apply(numbers, n));
    }
}
