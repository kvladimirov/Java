import java.util.Scanner;

/**
 * Created by User on 19.1.2017 г..
 */
public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        int[][] matrix = new int[matrixSize][matrixSize];

        String typeMatrix = input[1];

        if (typeMatrix.equals("A")) {
            int current = 0;
            for (int col = 0; col < matrix.length; col++) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = current + 1;
                    current = matrix[row][col];

                }
            }
        }

        if (typeMatrix.equals("B")) {
            int current = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (row % 2 == 0) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        matrix[col][row] = current + 1;
                        current = matrix[col][row];
                    }
                }
                if (row % 2 == 1) {
                    for (int col = matrix[row].length - 1; col >= 0; col--) {
                        matrix[col][row] = current + 1;
                        current = matrix[col][row];
                    }
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
