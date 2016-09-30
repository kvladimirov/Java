import java.util.Scanner;

public class ReverseCharacters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] array = new char[3];
		array[0] = scan.next().charAt(0);
		array[1] = scan.next().charAt(0);
		array[2] = scan.next().charAt(0);
		scan.close();
		char[] reversed = new char[3]; 
		for(int i = 0; i < array.length; i++){
			reversed[array.length - i - 1] = array[i];
		}
		for(int i = 0; i < reversed.length; i++){
			System.out.print(reversed[i]);
		}    
	}
}
