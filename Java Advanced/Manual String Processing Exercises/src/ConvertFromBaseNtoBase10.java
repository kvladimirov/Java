import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertFromBaseNtoBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int base = Integer.parseInt(input[0]);

        BigInteger base10 = new BigInteger(input[1], base);

        System.out.println(base10);
    }
}
