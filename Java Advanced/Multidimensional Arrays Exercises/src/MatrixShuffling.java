import java.util.Scanner;

public class MatrixShuffling {
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

        String input = scanner.nextLine();

        while (!input.equals("END"))
        {
            String[] data = input.split(" ");
            if(data.length == 5){
                String action = data[0];
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                if(action.equals("swap") && row1 < rows && row2 < rows && col1 < cols && col2 < cols){
                    String element1 = matrix[row1][col1];
                    String element2 = matrix[row2][col2];
                    //System.out.printf("%s %s\n", element1, element2);
                    matrix[row1][col1] = element2;
                    matrix[row2][col2] = element1;

                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }

                }else{
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }
}
