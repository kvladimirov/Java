import java.util.Scanner;

public class VowelOrDigit {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char symbol = scan.next().charAt(0);
		scan.close();
        if (symbol == 'a' | symbol == 'o' | symbol == 'u' | symbol == 'e' | symbol == 'i'){
        	System.out.println("vowel");
        }
        else if (symbol >= '0' & symbol <= '9'){
        	System.out.println("digit");
        }
        else{
        	System.out.println("other");
        }
	}
}
