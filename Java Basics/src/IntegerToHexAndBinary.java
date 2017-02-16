import java.util.Scanner;

public class IntegerToHexAndBinary {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
        scan.close();
        String hex = Integer.toHexString(number).toUpperCase();
        String bin = Integer.toBinaryString(number).toUpperCase();
        
        System.out.println(hex);
        System.out.println(bin);
	}
}
