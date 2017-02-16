import java.util.ArrayList;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carsInput = scanner.nextLine().trim().split("\\s");
        ArrayList<String> cars = new ArrayList<>();

        for (String car : carsInput){
            cars.add(car);
        }

        String input = scanner.nextLine();

        int sale = 0;

        while (!input.equals("End of customers!"))
        {
            String[] data = input.split(" ");
            String carWanted = data[0].toLowerCase().charAt(0) + data[2];
            int index = -1;
            for (int i = 0; i < cars.size(); i++)
            {
                if (carWanted.equals(cars.get(i)))
                {
                    index = i;
                    break;
                }

            }
            if (index == - 1)
            {
                System.out.println("No");

            }

            else
            {

                int price = carWanted.charAt(0) * Integer.parseInt(carWanted.substring(1));
                cars.remove(index);
                System.out.printf("Yes, sold for %d$\n", price);
                sale++;

            }
            input = scanner.nextLine();
        }

        System.out.printf("Vehicles left: %s\n", String.join(", ", cars));
        System.out.printf("Vehicles sold: %d", sale);
    }
}
