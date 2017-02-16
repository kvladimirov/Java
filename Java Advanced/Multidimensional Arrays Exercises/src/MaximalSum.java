import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeMatrix = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(sizeMatrix[0]);
        int cols = Integer.parseInt(sizeMatrix[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++)
        {
            String[] rowNums = scanner.nextLine().split(" ");

            for (int col = 0; col < matrix[row].length; col++)
            {
                matrix[row][col] = Integer.parseInt(rowNums[col]);
            }
        }

        long bestSum = Long.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++)
        {
            for (int col = 0; col < matrix[row].length - 2; col++)
            {

                long currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                    matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                    matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentSum > bestSum)
                {
                    bestSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.printf("Sum = %d\n", bestSum);

        for (int rowSave = bestRow; rowSave < bestRow + 3; rowSave++)
        {
            for (int colSave = bestCol; colSave < bestCol + 3; colSave++)
            {
                System.out.print(matrix[rowSave][colSave] + " ");
            }
            System.out.println();
        }
    }
}
