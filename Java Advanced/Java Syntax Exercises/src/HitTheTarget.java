import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for (int n1 = 1; n1 <= 20; n1++) {
            for (int n2 = 1; n2 <= 20; n2++) {
                if(n1 + n2 == num){
                    System.out.printf("%d + %d = %d\n", n1, n2, num);
                }
            }

        }

        for (int n3 = 1; n3 <= 20; n3++) {
            for (int n4 = 1; n4 <= 20; n4++) {

                if(n4 - n3 == num){
                    System.out.printf("%d - %d = %d\n", n4, n3, num);
                }
            }
        }
    }
}
