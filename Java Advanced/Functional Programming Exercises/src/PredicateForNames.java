import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        BiPredicate<String, Integer> doMagic = (x, y) -> x.length() <= y;
        Consumer<String> print = x -> System.out.println(x);

        for (String name : names) {
            if (doMagic.test(name, n)){
                print.accept(name);
            }
        }
    }
}
