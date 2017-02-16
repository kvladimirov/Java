import java.util.Scanner;

public class FitStringIn20Chars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine().toString();
        scan.close();
        if (text.length() < 20){
        	StringBuilder str = new StringBuilder(); 
        	for(int i = 0; i < text.length(); i++){
    			str.append(text.charAt(i));
        	} 
        	for(int i = text.length(); i < 20 ; i++){
    			str.append('*');
        	} 
            System.out.println(str);
        }
        else{
            System.out.println(text.substring(0, 20));
        }
	}
}
