import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        while(true){
            String resource = scanner.nextLine();
            if(resource.equals("stop")){
                break;
            }
            if(!resources.containsKey(resource)){
                resources.put(resource, 0);
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            resources.put(resource, resources.get(resource) + quantity);
        }


        for (String resource : resources.keySet()) {
            System.out.println(resource + " -> " + resources.get(resource));
        }
    }
}
