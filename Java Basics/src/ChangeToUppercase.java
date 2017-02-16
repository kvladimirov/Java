import java.util.Scanner;

public class ChangeToUppercase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		scan.close();
		 String tag1 = "<upcase>";
		  String tag2 = "</upcase>";
		  
		  while (true){
		  int indexTag1 = -1;
		   int indexTag2 = -1;
		   String low = "";
		   String up = "";
		   indexTag1 = text.indexOf(tag1);
		   indexTag2 = text.indexOf(tag2);
		   if (indexTag1 > -1 && indexTag2 > -1){
		    low = text.substring((indexTag1), (indexTag1) + indexTag2 + 9 - indexTag1);
		    up = text.substring(indexTag1 + 8, indexTag1 + 8 + indexTag2 - indexTag1 - 8).toUpperCase();
		    text = text.replace(low, up);
		   }
		   else{
		    break;
		   }
		  }
		  System.out.println(text);
    }
}
