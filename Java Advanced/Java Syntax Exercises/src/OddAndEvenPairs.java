import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();

        String[] line = numbers.split(" ");

        int[] newline = new int[line.length];

        if ((line.length % 2)!= 0){
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < line.length; i += 2) {
                newline[i] = Integer.parseInt(line[i]);

                newline[i + 1] = Integer.parseInt(line[i + 1]);

                if (newline[i] % 2 == 0 && newline[i + 1] % 2 == 0) {
                    System.out.printf("%d, %d -> both are even\n", newline[i], newline[i + 1]);
                } else if (newline[i] % 2 != 0 && newline[i + 1] % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd\n", newline[i], newline[i + 1]);
                } else {
                    System.out.printf("%d, %d -> different\n", newline[i], newline[i + 1]);
                }
            }
        }
    }
}
