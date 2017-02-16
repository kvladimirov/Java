import java.util.Scanner;

public class IndexOfLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		char[] check = input.toCharArray();
		int inputLenght = input.length(); 
        scan.close();
	    for(int i = 0; i < inputLenght ; i++){ 		
	        char character = input.charAt(i); 	        
	        if (Character.isLetter(check[i]))
	        {
	        	System.out.println(character+" -> "+ (int)(check[i] - 'a')); 
	        }
	    }
    } 
}