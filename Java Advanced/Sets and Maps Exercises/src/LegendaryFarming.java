import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (true) {
            String[] data = scanner.nextLine().split("\\s");

            boolean hasBroken = false;
            for (int i = 0; i < data.length; i += 2) {
                String material = data[i + 1].toLowerCase();
                int quantity = Integer.parseInt(data[i]);

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, 0);
                    }
                    junkMaterials.put(material, junkMaterials.get(material) + quantity);
                }

                for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                    String currentMaterial = entry.getKey();
                    long currentQuantity = entry.getValue();

                    if (currentQuantity >= 250) {
                        switch (currentMaterial) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                                hasBroken = true;
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
                                hasBroken = true;
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                keyMaterials.put("motes", keyMaterials.get("motes") - 250);
                                hasBroken = true;
                                break;
                        }

                        break;
                    }
                }
                if (hasBroken) {
                    break;
                }

            }

            if (hasBroken) {
                break;
            }
        }

        keyMaterials.entrySet().stream()
                .sorted((c1, c2) -> keyMaterials.get(c2.getKey()).compareTo(keyMaterials.get(c1.getKey())))
                .forEach(item -> System.out.printf("%s: %d\n", item.getKey(), item.getValue()));

        for (Map.Entry<String, Integer> entry : junkMaterials.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

