import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesinArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input =scan.nextLine().split(" ");

        HashMap<String, Integer> result = new HashMap<>();
        for(int i =0; i < input.length; i++){
            if(!result.containsKey(input[i])){
                result.put(input[i], 1);
            } else {
                result.put(input[i], result.get(input[i]) + 1);
            }
        }

        for(String key : result.keySet()){
            System.out.println(key + " - " + result.get(key) + " times");
        }
    }
}
