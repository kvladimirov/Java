import java.util.Scanner;

public class BooleanVariable {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 boolean bool = scan.nextBoolean();
         scan.close();
		 if ( bool == true) {
		 System.out.println("Yes");
		 }
		 else {
		 System.out.println("No");
		 } 
	}
}
