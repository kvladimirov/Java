import java.util.Scanner;

public class MaxSequenceOfEqualElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbers = scan.nextLine().toString().split("\\s+");
		int[] maxSeq = new int[numbers.length];
		for(int i = 0 ; i < numbers.length; i++){
		    maxSeq[i] = Integer.parseInt(numbers[i]);
		}
		scan.close();
        int maxIndex = 0;
        int maxLenght = 1;
        int currentLenght = 1;
        int prev = maxSeq[0];
        for (int i = 1; i < maxSeq.length; i++){
            if (prev == maxSeq[i]){
                currentLenght++;
            }
            else{
                if (currentLenght > maxLenght){
                    maxLenght = currentLenght;
                    maxIndex = i - 1;
                }
                currentLenght = 1;
            }
            prev = maxSeq[i];
            if (i == maxSeq.length - 1){
                if (currentLenght > maxLenght){
                    maxLenght = currentLenght;
                    maxIndex = i;
                }
            }
        }
        for (int k = maxIndex - maxLenght + 1; k <= maxIndex; k++){
             System.out.print(maxSeq[k] + " ");
         }
         System.out.println();
	}
}
