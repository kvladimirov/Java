import java.util.Scanner;
import java.util.stream.IntStream;

public class BombNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] numbers = scan.nextLine().trim().split(" ");	
		
		int[] matrix = new int[numbers.length];
		for (int i = 0; i < matrix.length; i++){
		    matrix[i] = Integer.parseInt(numbers[i]);
		}        
        
        String[] input = scan.nextLine().trim().split(" ");
		int bombNumber = Integer.parseInt(input[0]);
        int bombPerimeter = Integer.parseInt(input[1]);
		
        for (int i = 0; i < numbers.length; i++)
        {
        	if (matrix[i] == bombNumber)
        	{
        		int left = Math.max(0, i - bombPerimeter);
                int right = Math.min(numbers.length - 1, i + bombPerimeter);
                
                for (int j = left; j <= right; j++)
                {
                    matrix[j] = 0;
                }
        	}
        }
        scan.close();
       System.out.println(IntStream.of(matrix).sum());
	}
}
