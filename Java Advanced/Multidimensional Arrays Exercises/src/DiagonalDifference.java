import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int row = 0; row < n; row++)
        {
            String[] cells = scanner.nextLine().split(" ");
            for (int col = 0; col < n; col++)
            {
                matrix[row][col] = Integer.parseInt(cells[col]);

            }

        }
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row == col)
                {
                    firstDiagonal += matrix[row][col];
                }
                if (row + col + 1 == n)
                {
                    secondDiagonal += matrix[row][col];
                }
            }
        }

        System.out.println(Math.abs(firstDiagonal - secondDiagonal));

    }
}
