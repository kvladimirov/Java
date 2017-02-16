import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;


public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        OptionalDouble min = Arrays.stream(tokens)
                .filter(x -> !x.isEmpty())
                .mapToDouble(x -> Double.parseDouble(x))
                .filter(x -> x % 2 == 0)
                .min();

        if (min.isPresent()) {
            System.out.printf("%.2f", min.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
