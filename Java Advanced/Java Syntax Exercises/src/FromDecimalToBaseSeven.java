import java.util.Scanner;

public class FromDecimalToBaseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        String base7 = Integer.toString(num, 7);

        System.out.println(base7);
    }
}
