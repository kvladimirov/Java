import java.util.Scanner;

public class FromBaseSevenToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();

        int base10 = Integer.valueOf(num, 7);

        System.out.println(base10);
    }
}
