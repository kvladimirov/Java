import java.util.Scanner;

public class VariableInHexadecimalFormat {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputHex = scan.nextLine();
		scan.close();
		Integer outputDecimal  = Integer.parseInt(inputHex, 16 );
		System.out.println(outputDecimal);
	}

}
