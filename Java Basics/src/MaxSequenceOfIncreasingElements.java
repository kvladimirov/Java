import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbers = scan.nextLine().toString().split("\\s+");
		int[] maxSeq = new int[numbers.length];
		for(int i = 0 ; i < numbers.length; i++){
		    maxSeq[i] = Integer.parseInt(numbers[i]);
		}
		scan.close();

		int countCurrSeq = 0;
        int startCurrSeq = 0;
        int countMaxSeq = 0;
        int startMaxSeq = 0;

        for (int i = 1; i < maxSeq.length; i++)
        {
            if (maxSeq[i] - maxSeq[i - 1] >= 1)
            {
                countCurrSeq++;
                startCurrSeq = i - countCurrSeq;

                if (countCurrSeq > countMaxSeq)
                {
                    countMaxSeq = countCurrSeq;
                    startMaxSeq = startCurrSeq;
                }
            }
            else
            {
                countCurrSeq = 0;
            }
        }
        for (int k = startMaxSeq; k <= (startMaxSeq + countMaxSeq); k++){
            System.out.print(maxSeq[k] + " ");
        }
        System.out.println();
	}
}
