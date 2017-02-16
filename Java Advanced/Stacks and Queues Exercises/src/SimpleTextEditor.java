import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        String text = "";
        ArrayDeque<String> beforeText = new ArrayDeque<>();

        for (int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch(command){
                case "1":
                    beforeText.push(text);
                    text += input[1];
                    break;
                case "2":
                    int endIndex = text.length() - Integer.parseInt(input[1]);
                    beforeText.push(text);
                    text = text.substring(0, endIndex);
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(input[1]) - 1));
                    break;
                case "4":
                    text = beforeText.pop();
                    break;
            }
        }
    }
}
