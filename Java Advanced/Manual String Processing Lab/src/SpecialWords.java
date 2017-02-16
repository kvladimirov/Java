import java.util.HashMap;
import java.util.Scanner;

public class SpecialWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] specialWords = scan.nextLine().split(" ");
        String[] text = scan.nextLine().split(" ");
        HashMap<String, Integer> result = new HashMap<>();
        for (String specialWord : specialWords) {
            for (String s : text) {
                if(specialWord.compareToIgnoreCase(s) == 0){
                    if(result.containsKey(specialWord)){
                        result.put(specialWord, result.get(specialWord) + 1);
                    } else {
                        result.put(specialWord, 1);
                    }
                }
            }
        }
        for (String s : result.keySet()) {
            System.out.println(s + " - " + result.get(s));
        }
    }
}
