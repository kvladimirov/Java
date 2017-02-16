import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //stationsInfo contains - amount of petrol for each station and the distance to the next station.
        Deque<int[]> stationsInfo = new ArrayDeque<>();

        for (int iEnqueue = 0; iEnqueue < n; iEnqueue++) {
            String currentLine = scanner.nextLine();
            int[] currentStationInfo = Arrays.stream(currentLine.substring(0, currentLine.length()).split("\\s+"))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
            stationsInfo.offer(currentStationInfo);
        }

        //Station number which has enough petrol to cover full stations lap distance.
        int resultIndex = 0;
        boolean solutionFound = false;

        while (true) {
            //Get the very first station at the START of the queue.
            int[] startStation = stationsInfo.poll();

            //Add the station back at the END of the queue.
            stationsInfo.offer(startStation);
            int petrolQuantity = startStation[0];
            int distanceToNext = startStation[1];
            petrolQuantity -= distanceToNext;
            int currentStationsCount = 1;

            while(petrolQuantity >= 0){
                int[] currentStation = stationsInfo.poll();
                if(currentStation == startStation){
                    solutionFound = true;
                    break;
                }

                stationsInfo.offer(currentStation);
                //Add(+) the current station petrol quantity.
                petrolQuantity += currentStation[0];

                //Subtract(-) the petrol necessary to cover the distance to next station.
                petrolQuantity -= currentStation[1];
                currentStationsCount++;
            }

            if(solutionFound){
                break;
            }
            resultIndex += currentStationsCount;
        }
        System.out.println(resultIndex);
    }
}
