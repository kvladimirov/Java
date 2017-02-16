import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double f1 = Math.pow((((a * a) + (b * b)) / ((a * a) - (b * b))), (a + b + c) / Math.sqrt(c));
        double f2 = Math.pow(((a * a) + (b * b) - (c * c * c)), (a - b));
        double diff = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}