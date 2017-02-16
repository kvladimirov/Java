import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TheBiggestSmallestInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String searched = reader.readLine();

        switch (searched) {
            case "minEven":
                OptionalInt minEven = numbers.stream()
                        .filter(x -> x % 2 == 0)
                        .mapToInt(x -> x)
                        .min();

                if (minEven.isPresent()) {
                    System.out.println(minEven.getAsInt());
                }
                break;
            case "maxEven":
                OptionalInt maxEven = numbers.stream()
                        .filter(x -> x % 2 == 0)
                        .mapToInt(x -> x)
                        .max();

                if (maxEven.isPresent()) {
                    System.out.println(maxEven.getAsInt());
                }
                break;
            case "minOdd":
                OptionalInt minOdd = numbers.stream()
                        .filter(x -> x % 2 == 1)
                        .mapToInt(x -> x)
                        .min();

                if (minOdd.isPresent()) {
                    System.out.println(minOdd.getAsInt());
                }
                break;
            case "maxOdd":
                OptionalInt maxOdd = numbers.stream()
                        .filter(x -> x % 2 == 1)
                        .mapToInt(x -> x)
                        .max();

                if (maxOdd.isPresent()) {
                    System.out.println(maxOdd.getAsInt());
                }
                break;
        }
    }
}
