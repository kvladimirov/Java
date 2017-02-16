import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double aX = scanner.nextDouble();
        double aY = scanner.nextDouble();

        double bX = scanner.nextDouble();
        double bY = scanner.nextDouble();

        double cX = scanner.nextDouble();
        double cY = scanner.nextDouble();

        int area = Math.abs((int)((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2));

        System.out.println(area);
    }
}
