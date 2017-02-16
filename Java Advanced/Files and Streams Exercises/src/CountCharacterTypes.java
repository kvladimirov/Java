

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;


public class CountCharacterTypes {
    public static void main(String[] args){

        final String inputPath = "resources/Count Character Types/input.txt";
        HashSet<Character> punct = new HashSet<>();
        Collections.addAll(punct, '!', '.', ',', '?');

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;

            String line = reader.readLine();

            while (line != null){
                for (char c : line.toCharArray()) {
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                        vowels++;
                    }else if(punct.contains(c)){
                        punctuation++;
                    }else if(c != ' ') {
                        consonants++;
                    }

                }


                line = reader.readLine();
            }

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
            System.out.println("Punctuation: " + punctuation);



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
