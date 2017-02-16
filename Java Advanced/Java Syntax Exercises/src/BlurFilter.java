import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());

        String[] data = scanner.nextLine().trim().split("\\s");

        int matrixRows = Integer.parseInt(data[0]);
        int matrixCols = Integer.parseInt(data[1]);

        long[][] matrix = new long[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++)
        {
            String[] columns = scanner.nextLine().trim().split("\\s");
            for (int col = 0; col < matrixCols; col++)
            {
                matrix[row][col] = Integer.parseInt(columns[col]);
            }

        }

        String[] cordinates = scanner.nextLine().trim().split("\\s");

        int wantedRow = Integer.parseInt(cordinates[0]);
        int wantedCol = Integer.parseInt(cordinates[1]);

        int startRow = Math.max(0, wantedRow - 1);
        int endRow = Math.min(matrixRows - 1, wantedRow + 1);
        int startCol = Math.max(0, wantedCol - 1);
        int endCol = Math.min(matrixCols - 1, wantedCol + 1);

        for (int row = startRow; row <= endRow; row++)
        {
            for (int col = startCol; col <= endCol; col++)
            {
                matrix[row][col] += blurAmount;
            }

        }

        for (int row = 0; row < matrixRows; row++)
        {
            for (int col = 0; col < matrixCols; col++)
            {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

}
