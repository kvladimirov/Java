import java.util.Scanner;

public class Squares2x2InMatrix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		    

		String[] dimension = input.nextLine().trim().split(" ");
		int rows = Integer.parseInt(dimension[0]);
		int cols = Integer.parseInt(dimension[1]);
		
		char[][] matrix = new char[rows][cols];

		for (int row = 0; row < rows; row++) {
			String[] charsInput = input.nextLine().trim().split(" ");
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = charsInput[col].charAt(0);
			}
		}
		input.close();
		int arrCounter = 0;

		for (int row = 0; row < rows - 1; row++)
		{
			for (int col = 0; col < cols - 1; col++)
			{
				if (matrix[row][col] == matrix[row][col + 1] && matrix[row][col] == matrix[row + 1][col + 1] && matrix[row][col] == matrix[row + 1][col])
				{
					 arrCounter++;
				}
			}
		}
		System.out.println(arrCounter);
	}
}
