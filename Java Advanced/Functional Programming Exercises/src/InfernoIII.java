import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class InfernoIII {
    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        HashMap<String, Predicate<Integer>> filter = new HashMap<>();

        String command = "";

        while (!"Forge".equals(command = reader.readLine())){
            String[] commands = command.split(";");
            String modifier = commands[1];
            int variable = Integer.parseInt(commands[2]);

            switch (commands[0]){
                case "Exclude":
                    Predicate<Integer> predicate = buildPredicate(modifier, variable);
                    filter.put(modifier + variable, predicate);
                    break;

                case "Reverse":
                    filter.remove(modifier + variable);
                    break;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean shouldPrint = false;
            for (Predicate<Integer> predicate : filter.values()) {
                if (predicate.test(i)){
                    shouldPrint = true;
                    break;
                }
            }
            if (!shouldPrint){
                System.out.printf("%d ", numbers[i]);
            }
        }

    }

    private static Predicate<Integer> buildPredicate(String modifier, int variable) {
        switch (modifier){
            case "Sum Left":
                return x -> (x - 1 < 0 ? 0 : numbers[x - 1]) + numbers[x] == variable;

            case "Sum Right":
                return x -> (x + 1 >= numbers.length ? 0 : numbers[x + 1]) + numbers[x] == variable;

            case  "Sum Left Right":
                return x -> (x - 1 < 0 ? 0 : numbers[x - 1]) + numbers[x] + (x + 1 >= numbers.length ? 0 : numbers[x + 1]) == variable;

            default:
                return null;
        }
    }
}
