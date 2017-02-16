import java.util.Scanner;

public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = calculateTriangleArea(base, height);

        System.out.printf("Area = %.2f", area);
    }

    public static double calculateTriangleArea(double base, double height){
         return (base * height) / 2;
    }
}
