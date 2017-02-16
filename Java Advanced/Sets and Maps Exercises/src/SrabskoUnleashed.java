import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashMap<String, Long>> srabskoUnleashed = new LinkedHashMap<>();
        String regex = "^(?<singer>\\w+(\\s\\w+)*?) @(?<place>\\w+(\\s\\w+)*?)\\s(?<price>\\d+)\\s(?<count>\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {

                String singer = matcher.group("singer");
                int ticketPrice = Integer.parseInt(matcher.group("price"));
                long ticketCount = Long.parseLong(matcher.group("count"));
                String place = matcher.group("place");


                if (!srabskoUnleashed.containsKey(place)) {
                    srabskoUnleashed.put(place, new LinkedHashMap<>());
                }

                long currentPrice = ticketPrice * ticketCount;

                HashMap<String, Long> currentLinkedMap = srabskoUnleashed.get(place);
                if (!currentLinkedMap.containsKey(singer)) {
                    currentLinkedMap.put(singer, 0L);
                }

                currentLinkedMap.put(singer, currentLinkedMap.get(singer) + currentPrice);
                srabskoUnleashed.put(place, currentLinkedMap);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, HashMap<String, Long>> entry : srabskoUnleashed.entrySet()) {
            String place = entry.getKey();

            System.out.println(place);
            HashMap<String, Long> currentHashMap = entry.getValue();

            LinkedHashMap<String, Long> sorted = new LinkedHashMap<>();
            currentHashMap.entrySet().stream()
                    .sorted((c1, c2) -> currentHashMap.get(c2.getKey()).compareTo(currentHashMap.get(c1.getKey())))
                    .forEach(x -> sorted.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Long> stringLongEntry : sorted.entrySet()) {
                System.out.println("#  " + stringLongEntry.getKey() + " -> " + stringLongEntry.getValue());
            }
        }
    }
}
