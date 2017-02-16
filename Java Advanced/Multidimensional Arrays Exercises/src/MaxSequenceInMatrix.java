import java.util.ArrayList;
import java.util.Scanner;

public class MaxSequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currentLine[j];
            }
        }


        ArrayList<String> sequence = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currentRow = i;
                int currentCol = j;
                String currentCell = matrix[currentRow][currentCol];
                ArrayList<String> currentSequence = new ArrayList<>();

                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentRow++;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() > sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

                currentSequence = new ArrayList<>();
                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentCol++;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() > sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

                currentSequence = new ArrayList<>();
                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentRow++;
                    currentCol++;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() > sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

                currentSequence = new ArrayList<>();
                while (true) {
                    if (isInMatrix(currentRow, currentCol, rows, cols) && matrix[currentRow][currentCol].equals(currentCell)) {
                        currentSequence.add(matrix[currentRow][currentCol]);
                    } else {
                        break;
                    }

                    currentRow--;
                }

                currentRow = i;
                currentCol = j;
                if (currentSequence.size() >= sequence.size()) {
                    sequence = new ArrayList<>(currentSequence);
                }

            }
        }

        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + ", ");
        }
    }

    private static boolean isInMatrix(int currentRow, int currentCol, int rows, int cols) {
        boolean isInRow = currentRow >= 0 && currentRow < rows;
        boolean isInCol = currentCol >= 0 && currentCol < cols;

        return isInRow && isInCol;
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String[] sizeMatrix = scanner.nextLine().split(" ");
//
//        int rows = Integer.parseInt(sizeMatrix[0]);
//        int cols = Integer.parseInt(sizeMatrix[1]);
//
//        String[][] matrix = new String[rows][cols];
//
//        for (int row = 0; row < matrix.length; row++)
//        {
//            String[] rowNums = scanner.nextLine().split(" ");
//
//            for (int col = 0; col < matrix[row].length; col++)
//            {
//                matrix[row][col] = rowNums[col];
//            }
//        }
//
//        String sequence = null;
//        int counter = 0;
//
//        for (int row = 0; row < rows; row++)
//        {
//            int currentCounter = 1;
//
//            for (int col = 1; col < cols; col++)
//            {
//                if(matrix[row][col].equals(matrix[row][col - 1])){
//                    currentCounter++;
//
//                }
//                if(currentCounter > counter){
//                    counter = currentCounter;
//                    sequence = matrix[row][col - 1];
//                }
//            }
//        }
//
//        for (int col = 0; col < cols; col++)
//        {
//            int currentCounterCol = 1;
//
//            for (int row = 1; row < rows; row++)
//            {
//                if(matrix[row][col].equals(matrix[row - 1][col])){
//                    currentCounterCol++;
//
//                }
//                if(counter <= currentCounterCol){
//                    counter = currentCounterCol;
//                    sequence = matrix[row - 1][col];
//                }
//
//            }
//        }
//
//        int rotate = 0;
//        while (rotate < rows) {
//            int currentCounterDiagonal = 1;
//            for (int row = 0; row < rows - 1; row++) {
//
//                for (int col = row + rotate; col < cols - 1; col++) {
//
//                    if (matrix[row][col].equals(matrix[row + 1][col + 1])) {
//                        currentCounterDiagonal++;
//                    }
//                    if (currentCounterDiagonal >= counter) {
//                        counter = currentCounterDiagonal;
//                        sequence = matrix[row][col];
//                    }
//                    break;
//                }
//            }
//            rotate++;
//        }
//
//        rotate = 0;
//        while (rotate < rows) {
//            int currentCounterDiagonal = 1;
//            for (int row = rows - 1; row >= 0; row--) {
//
//                for (int col = 0; col < cols - 1; col++) {
//
//                    if (matrix[row][col].equals(matrix[row - 1][col + 1])) {
//                        currentCounterDiagonal++;
//                    }
//                    if (currentCounterDiagonal >= counter) {
//                        counter = currentCounterDiagonal;
//                        sequence = matrix[row][col];
//                    }
//                    break;
//                }
//            }
//            rotate++;
//        }
//
//        rotate = 0;
//        while (rotate < rows) {
//            int currentCounterDiagonal = 1;
//            for (int row = 0; row < rows - 1; row++) {
//                if (matrix[row][cols - 1 - row].equals(matrix[row + 1][cols - 1 - row])) {
//                    currentCounterDiagonal++;
//                }
//                if (currentCounterDiagonal >= counter) {
//                    counter = currentCounterDiagonal;
//                    sequence = matrix[row][cols - 1 - row];
//                }
//            }
//            rotate++;
//        }
//
//        for (int i = 0; i < counter; i++) {
//            System.out.print(sequence + ", ");
//        }
//
//    }
}
