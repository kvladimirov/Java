import java.util.Scanner;

public class CompareCharArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array1 = scan.nextLine().toString().split("\\s+");
		String[] array2 = scan.nextLine().toString().split("\\s+");
		scan.close();
		
		StringBuilder str1 = new StringBuilder();  
		for(int i = 0; i < array1.length; i++){
			str1.append(array1[i]);
		}
		
		StringBuilder str2 = new StringBuilder();
		for(int i = 0; i < array2.length; i++){
			str2.append(array2[i]);
		}
		
		int sum1 = 0;
		for(int i = 0; i < array1.length; i++){
			sum1 = sum1 + array1[i].charAt(0);
		}
		int sum2 = 0;
		for(int i = 0; i < array2.length; i++){
			sum2 = sum2 + array2[i].charAt(0);
		}
		if(sum1 == sum2){
		System.out.println(str1);
		System.out.println(str2);
		}
		if(sum1 < sum2){
			System.out.println(str1);
			System.out.println(str2);
		}
		if(sum1 > sum2){
			System.out.println(str2);
			System.out.println(str1);
		}
		System.out.println(sum1);
	}
}
