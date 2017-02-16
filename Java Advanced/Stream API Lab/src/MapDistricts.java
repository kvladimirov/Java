import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Integer>> cities = new HashMap<>();

        String[] tokens = reader.readLine().split("\\s+");
        int limit = Integer.parseInt(reader.readLine());

        for (String token : tokens) {
            String[] cityArgs = token.split(":");
            String cityName = cityArgs[0];
            int districtPopulation = Integer.parseInt(cityArgs[1]);

            cities.putIfAbsent(cityName, new ArrayList<>());
            cities.get(cityName).add(districtPopulation);
        }

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(limit))
                .sorted(getSortByDescendingPopulationComparator())
                .forEach(getPrintMapEntryConsumer());
    }

    private static Consumer<Map.Entry<String, List<Integer>>> getPrintMapEntryConsumer() {
        return e -> {
            System.out.print(e.getKey() + ": ");
            e.getValue().stream()
                    .sorted((s1, s2) -> s2.compareTo(s1))
                    .limit(5)
                    .forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }

    private static Comparator<Map.Entry<String, List<Integer>>> getSortByDescendingPopulationComparator() {
        return (e1, e2) -> Integer.compare(
        e2.getValue().stream().mapToInt(Integer::valueOf).sum(),
        e1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    private static Predicate<Map.Entry<String, List<Integer>>> getFilterByPopulationPredicate(int limit) {
        return c -> c.getValue().stream().mapToInt(Integer::valueOf).sum() > limit;
    }

}
