import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> logInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s");
            String user = data[1];
            String ip = data[0];
            int duration = Integer.parseInt(data[2]);

            if (!logInfo.containsKey(user)) {
                logInfo.put(user, new TreeMap<>());

            }
            if (!logInfo.get(user).containsKey(ip)) {
                logInfo.get(user).put(ip, duration);
            }else{
                logInfo.get(user).put(ip, logInfo.get(user).get(ip) + duration);
            }

        }

        Map<String, Integer> users = new TreeMap<>();

        for (String user : logInfo.keySet()) {
            int totalDuration = 0;
            for (String ip: logInfo.get(user).keySet()) {
                totalDuration += logInfo.get(user).get(ip);
            }

            users.put(user, totalDuration);
        }

        for (String user : users.keySet()) {
            TreeSet<String> ipData = new TreeSet<>();
            for (String ip : logInfo.get(user).keySet()) {
                ipData.add(ip);
            }
            System.out.println(user + ": " + users.get(user) + " " + ipData);
        }
    }
}
