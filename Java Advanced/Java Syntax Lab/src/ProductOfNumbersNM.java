import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbersNM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int index = n;
        BigInteger product = new BigInteger("1");
        do {
            product = product.multiply(new BigInteger(String.valueOf(index)));
            index++;
        } while (index <= m);
        System.out.printf("product[%s..%s] = %s", n, m, product);

    }
}
