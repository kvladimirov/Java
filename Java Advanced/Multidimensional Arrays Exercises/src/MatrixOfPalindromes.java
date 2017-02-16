import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int matrixRows = Integer.parseInt(input[0]);
        int matrixCols = Integer.parseInt(input[1]);

        String[][] palindromesMatrix = new String[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            for (int col = 0; col < matrixCols; col++)
            {
                palindromesMatrix[row][col] = "" + (char)('a' + row) + (char)('a' + row + col) + (char)('a' + row);


            }
        }

        for (int row = 0; row < matrixRows; row++)
        {
            for (int col = 0; col < matrixCols; col++)
            {
                System.out.print(palindromesMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
