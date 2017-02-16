import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        double result = 0;
        for (int i = 0; i < input.length; i++) {
            char firstChar = input[i].charAt(0);
            char lastChar = input[i].charAt(input[i].length() - 1);
            double number = Double.parseDouble(input[i].substring(1, input[i].length() - 1));

            if (Character.toString(firstChar).equals(Character.toString(firstChar).toLowerCase())) {
                number *= firstChar - 96;
            } else {
                number /= firstChar - 64;
            }

            if (Character.toString(lastChar).equals(Character.toString(lastChar).toLowerCase())) {
                number += lastChar - 96;
            } else {
                number -= lastChar - 64;
            }

            result += number;
        }

        System.out.printf("%.2f\n", result);
    }
}
