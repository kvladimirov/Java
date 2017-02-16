import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.asList(reader.readLine().split(", "));
        List<Double> result = new ArrayList<>();
        UnaryOperator<Double> vat = n -> n * 1.2;

        for (String s : input) {
            double num = Double.parseDouble(s);
            result.add(vat.apply(num));
        }

        System.out.println("Prices with VAT:");
        for (Double aDouble : result) {
            String sumWithVat = String.format("%1.2f", aDouble);
            sumWithVat = sumWithVat.replace('.', ',');
            System.out.println(sumWithVat);
        }
    }
}
