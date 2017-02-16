import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        String timeOfDay = scanner.next();

        double totalPrice = 0;

        if (distance < 20){
            if (timeOfDay.equals("day")){
                totalPrice = 0.70 + (distance * 0.79);
            } else {
                totalPrice = 0.70 + (distance * 0.9);
            }
        } else if (distance < 100){
            totalPrice = distance * 0.09;
        } else{
            totalPrice = distance * 0.06;
        }

        System.out.printf("%.2f", totalPrice);

    }
}
