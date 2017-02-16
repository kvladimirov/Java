import java.util.Scanner;

public class CensorEmailAdress {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] eMail = scan.nextLine().toString().split("@");
		String message = scan.nextLine();
        scan.close();
        StringBuilder censored = new StringBuilder(); 
    	for(int i = 0; i < eMail[0].length(); i++){
    		censored.append('*');
    	} 
    	censored.append('@');
    	for(int i = 0; i < eMail[1].length(); i++){
    		censored.append(eMail[1].charAt(i));
    	}       
        System.out.println(message.replace((eMail[0] + '@' + eMail[1]), censored));
	}
}
