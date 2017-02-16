import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.asList(reader.readLine().split(", "));
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }

        StringBuilder sb = new StringBuilder();
        numbers.removeIf(n -> n % 2 != 0);
        for (Integer s : numbers) {
            sb.append(s);
            sb.append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);

        sb = new StringBuilder();
        numbers.sort((a, b) -> a.compareTo(b));
        for (Integer s : numbers) {
            sb.append(s);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}