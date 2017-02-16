import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashMap<String, Long>> populationInfo = new LinkedHashMap<>();

        while (true) {
            String imput = scanner.nextLine();
            if (imput.equals("report")) {
                break;
            }
            String[] data = imput.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            if (!populationInfo.containsKey(country)) {
                populationInfo.put(country, new HashMap<>());
            }
            if (!populationInfo.get(country).containsKey(city)) {
                populationInfo.get(country).put(city, population);
            }
        }

        Map<String, Long> countries = new LinkedHashMap<>();

        for (String country : populationInfo.keySet()) {
            long totalPopulation = 0;
            for (Long populationCount : populationInfo.get(country).values()) {
                totalPopulation += populationCount;
            }
            countries.put(country, totalPopulation);
        }

        Map<String, Long> countriesSorted = new LinkedHashMap<>();

        countries.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> countriesSorted.put(x.getKey(), x.getValue()));

        for (String country : countriesSorted.keySet()) {
            System.out.println(country + " (total population: " + countriesSorted.get(country) + ")");
            LinkedHashMap<String, Long> cities = new LinkedHashMap<>();

            populationInfo.get(country).entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEachOrdered(x -> cities.put(x.getKey(), x.getValue()));

            for (String city : cities.keySet()) {
                System.out.println("=>" + city + ": " + cities.get(city));
            }
        }
    }
}
