import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int[][] matrix = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }

        int sum = 0;

        for (int[] nums : matrix){
            for (int num : nums){
                sum += num;
            }
        }
        System.out.println(sum);
    }
}
