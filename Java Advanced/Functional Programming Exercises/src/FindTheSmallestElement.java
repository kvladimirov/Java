import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        Consumer<Integer> print = name -> System.out.println(name);
        Function<List<Integer>, Integer> minNumberIndex = x -> {
            int minValue = x.get(0);
            int minIndex = 0;
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) <= minValue){
                    minValue = x.get(i);
                    minIndex = i;
                }

            }
            return minIndex;
        };

        print.accept(minNumberIndex.apply(numbers));
    }
}
