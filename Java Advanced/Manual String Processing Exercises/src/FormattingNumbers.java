import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);
        String binaryStringA = Integer.toString(a, 2);
        while(binaryStringA.length() < 10){
            binaryStringA = "0" + binaryStringA;
        }
        if(binaryStringA.length() > 10){
            binaryStringA = binaryStringA.substring(0, 10);
        }
        System.out.println(String.format("|%-10X|%s|%10.2f|%-10.3f|", a, binaryStringA, b, c));
    }
}
