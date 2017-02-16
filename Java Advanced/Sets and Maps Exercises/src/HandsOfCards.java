import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> powerOfCards = new LinkedHashMap<>();

        while(true){
            String imput = scanner.nextLine();
            if(imput.equals("JOKER")){
                break;
            }
            String[] personAndCards = imput.split(": ");
            String person = personAndCards[0];
            String[] cards = personAndCards[1].split(", ");

            int power = 0;
            if(!powerOfCards.containsKey(person)){
                powerOfCards.put(person, new HashSet<>());

            }
            for (String card : cards) {
                powerOfCards.get(person).add(card);
            }
        }

        for (String person : powerOfCards.keySet()) {
            int power = 0;
            for (String card: powerOfCards.get(person)){
                char multiplierChar = ' ';
                int powerL = 0;
                int multiplierL = 0;
                if (card.length() == 2)
                {
                    multiplierChar = card.charAt(1);
                }
                else
                {
                    multiplierChar = card.charAt(2);
                }
                switch (card.charAt(0))
                {
                    case '2': powerL = 2; break;
                    case '3': powerL = 3; break;
                    case '4': powerL = 4; break;
                    case '5': powerL = 5; break;
                    case '6': powerL = 6; break;
                    case '7': powerL = 7; break;
                    case '8': powerL = 8; break;
                    case '9': powerL = 9; break;
                    case 'J': powerL = 11; break;
                    case 'Q': powerL = 12; break;
                    case 'K': powerL = 13; break;
                    case 'A': powerL = 14; break;
                    case '1': powerL = 10; break;
                }
                switch (multiplierChar)
                {
                    case 'S': multiplierL = 4; break;
                    case 'H': multiplierL = 3; break;
                    case 'D': multiplierL = 2; break;
                    case 'C': multiplierL = 1; break;
                }
                power += powerL * multiplierL;
            }
            System.out.println(person + ": " + power);
        }
    }
}
