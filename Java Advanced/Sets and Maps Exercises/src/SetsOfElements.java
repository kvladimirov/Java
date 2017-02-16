import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> setN = new LinkedHashSet<>();
        LinkedHashSet<Integer> setM = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            setN.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            setM.add(Integer.parseInt(scanner.nextLine()));
        }

        for(Integer number : setN){
            if (setM.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
