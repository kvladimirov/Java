
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logInfo = new TreeMap<>();

        while(true){
            String imput = scanner.nextLine();
            if(imput.equals("end")){
                break;
            }
            String[] dataLog = imput.split(" ");
            String[] userData = dataLog[2].split("=");
            String user = userData[1];
            String[] ipData = dataLog[0].split("=");
            String ip = ipData[1];

            if(!logInfo.containsKey(user)){
                logInfo.put(user, new LinkedHashMap<>());
            }
            if(!logInfo.get(user).containsKey(ip)){
                logInfo.get(user).put(ip, 1);
            }else{
                logInfo.get(user).put(ip, logInfo.get(user).get(ip) + 1);
            }
        }


        for (String log : logInfo.keySet()) {
            System.out.println(log + ":");
            int count = logInfo.get(log).keySet().size();
            for (String s : logInfo.get(log).keySet()) {
                if (count > 1) {
                    System.out.print(s + " => " + logInfo.get(log).get(s) + ", ");
                }else {
                    System.out.print(s + " => " + logInfo.get(log).get(s) + ".");
                }
                count--;
            }
            System.out.println( );
        }
    }
}
