import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Optional;


public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Optional<Integer> sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> isNumber(x))
                .map(Integer::valueOf)
                .reduce((x1, x2) -> x1 + x2);

        if (sum.isPresent()){
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }

    }

    private static boolean isNumber(String string) {
        if (string.isEmpty()){
            return false;
        }

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0){
                if (chars[i] == '-' || chars[i] == '+'){
                    continue;
                }
            }
            if (!Character.isDigit(chars[i])){
                return false;
            }
        }

        return true;
    }
}
