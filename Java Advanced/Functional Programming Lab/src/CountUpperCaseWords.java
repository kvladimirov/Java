import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (checkerUpperCase.test(input[i])) {
                result.add(input[i]);
            }
        }
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}