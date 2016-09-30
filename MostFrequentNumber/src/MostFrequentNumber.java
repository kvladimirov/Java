import java.util.Scanner;

public class MostFrequentNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbers = scan.nextLine().toString().split("\\s+");
		int[] nums = new int[numbers.length];
		for(int i = 0 ; i < numbers.length; i++){
		    nums[i] = Integer.parseInt(numbers[i]);
		}
		scan.close();
		int index = 0;
        int currentIndex = 0;
        int currentNum = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                if (nums[i] == nums[j])
                {
                    currentIndex++;
                }
            }
            if (currentIndex > index)
            {
                index = currentIndex;
                currentNum = nums[i];
                
            }
            currentIndex = 0;
	    }
        System.out.print(currentNum);
	}
}
