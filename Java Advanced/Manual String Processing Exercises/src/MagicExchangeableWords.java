import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        String firstWord = input[0];
        String secondWord = input[1];

        HashSet<Character> firstWordCharacters = new HashSet<>();
        HashSet<Character> secondWordCharacters = new HashSet<>();

        for (Character ch : firstWord.toCharArray()) {
            firstWordCharacters.add(ch);
        }

        for (Character ch : secondWord.toCharArray()) {
            secondWordCharacters.add(ch);
        }

        if (firstWordCharacters.size() == secondWordCharacters.size()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
