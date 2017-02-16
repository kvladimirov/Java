import java.util.Scanner;

public class SquaresInMatrix2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeMatrix = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(sizeMatrix[0]);
        int cols = Integer.parseInt(sizeMatrix[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++)
        {
            String[] rowNums = scanner.nextLine().split(" ");

            for (int col = 0; col < matrix[row].length; col++)
            {
                matrix[row][col] = rowNums[col];
            }
        }

        int squaresInMatrix = 0;
        for (int row = 0; row < matrix.length - 1; row++)
        {
            for (int col = 0; col < matrix[row].length - 1; col++)
            {

                if (matrix[row][col].equals(matrix[row][col + 1]) &&
                matrix[row][col + 1].equals(matrix[row + 1][col]) &&
                matrix[row + 1][col].equals(matrix[row + 1][col + 1]))
                {
                    squaresInMatrix++;
                }
            }
        }
        System.out.println(squaresInMatrix);
    }

}
