import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));

        LinkedHashMap<String, HashSet<String>> filters = new LinkedHashMap<>();
        filters.put("Starts with", new HashSet<>());
        filters.put("Ends with", new HashSet<>());
        filters.put("Length", new HashSet<>());
        filters.put("Contains", new HashSet<>());

        String command = "";

        while (!"Print".equals(command = reader.readLine())){
            String[] commands = command.split(";");

            switch (commands[0]){
                case "Add filter":
                    filters.get(commands[1]).add(commands[2]);
                    break;

                case "Remove filter":
                    filters.get(commands[1]).remove(commands[2]);
                    break;
            }
        }

        for (String filter : filters.keySet()) {
            for (String f : filters.get(filter)) {
                switch (filter) {
                    case "Starts with":
                        names.removeIf(x -> x.startsWith(f));
                        break;
                    case "Ends with":
                        names.removeIf(x -> x.endsWith(f));
                        break;
                    case "Length":
                        names.removeIf(x -> x.length() == Integer.parseInt(f));
                        break;
                    case "Contains":
                        names.removeIf(x -> x.contains(f));
                        break;
                    default:
                        break;
                }
            }

        }


        Consumer<String> print = str -> System.out.print(str);
        if (!names.isEmpty()) {
            for (String name : names) {
                print.accept(name + " ");
            }
        }
    }

}
