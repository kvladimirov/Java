import java.util.Scanner;

public class MatrixOfPalindromes {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);	
		String[] input = scan.nextLine().trim().split(" ");
		scan.close();
		int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        
        int[][] matrix = new int[rows][cols];
        char firstLetter = 'a';
		
        for (char i = 'a'; i <= firstLetter + rows - 1; i++)
        {
        	for (char j = i; j < i + cols; j++){
        		String letters = String.valueOf(i) + String.valueOf(j) + String.valueOf(i);
        		System.out.print(letters + " ");
        	}
        	System.out.println();
        }
	}
}
