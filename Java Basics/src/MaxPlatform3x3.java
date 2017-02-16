import java.util.Scanner;

public class MaxPlatform3x3 {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		String[] dimension = input.nextLine().trim().split(" ");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        
        
        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < rows; row++)
        {
	       	 String[]numInput = input.nextLine().trim().split(" ");
	       	 for(int col = 0; col < cols; col++)            
	            matrix[row][col] = Integer.parseInt(numInput[col]);
        }
        
        long maxArea = Long.MIN_VALUE;
        int maxRows = 0;
        int maxCols = 0;
        
        for (int row = 0; row < rows - 2; row++)
        {
            long currSum = 0;
            for (int col = 0; col < cols - 2; col++)
            {
                currSum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col] + matrix[row][col + 1]
                    + matrix[row + 1][col + 1] + matrix[row + 2][col + 1]
                    + matrix[row][col + 2] + matrix[row + 1][col + 2] + matrix[row + 2][col + 2];
                if ( currSum > maxArea)
                {
                    maxArea = currSum;
                    maxRows = row;
                    maxCols = col;
                }
            }
        }
        input.close();
        System.out.println(maxArea);
        
        for (int i = maxRows; i < maxRows + 3; i++)
        {
            for (int j = maxCols; j < maxCols + 3; j++)
            {
           	 System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
	}
}
