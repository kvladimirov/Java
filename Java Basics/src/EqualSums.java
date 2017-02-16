import java.util.Scanner;

public class EqualSums {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbers = scan.nextLine().toString().split("\\s+");
		int[] nums = new int[numbers.length];
		for(int i = 0 ; i < numbers.length; i++){
		    nums[i] = Integer.parseInt(numbers[i]);
		}
		scan.close();
		for (int i = 0; i <= nums.length - 1; i++)
        {
            if (nums.length == 1)
            {
                System.out.println(0);
                return;
            }
            int sumLeft = 0;
            for (int j = 0; j <= i; j++)
            {
                sumLeft += nums[j];
            }
            int sumRight = 0;
            for (int j = i; j < nums.length; j++)
            {
                sumRight += nums[j];
            }
            if (sumLeft == sumRight)
            {
            	System.out.println(i);
                return;
            }
        }
		System.out.println("no");
	}
}
