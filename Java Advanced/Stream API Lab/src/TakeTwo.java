import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        numbers.stream()
                .filter(n -> 10 <= n && n <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));

    }
}
