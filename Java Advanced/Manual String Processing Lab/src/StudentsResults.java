import java.util.*;

public class StudentsResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        TreeMap<String, List<Double>> result = new TreeMap<>();
        for(int i = 0; i < number; i++){
            String[] input = scan.nextLine().split(" - ");
            String[] examResultsLikeString = input[1].split(", ");
            double sum = 0;
            List<Double> examResults = new ArrayList<>();
            for(String res : examResultsLikeString){
                double remainder = Double.parseDouble(res);
                sum += remainder;
                examResults.add(remainder);
            }
            examResults.add(sum / 3);
            result.put(input[0], examResults);
        }

        if(number != 0) {
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
            for (String s : result.keySet()) {
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", s, result.get(s).get(0), result.get(s).get(1), result.get(s).get(2), result.get(s).get(3)).replace(".", ","));

            }
        }
    }
}
