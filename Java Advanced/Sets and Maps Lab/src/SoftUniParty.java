import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        HashSet<String> regular = new HashSet<String>();
        TreeSet<String> vip = new TreeSet<String>();
        while(true){
            String input = scanner.nextLine();
            if("PARTY".equals(input)){
                break;
            }
            if(numbers.contains(input.charAt(0))){
                vip.add(input);
            } else {
                regular.add(input);
            }
        }


        while(true){
            String guestCome = scanner.nextLine();
            if("END".equals(guestCome)){
                break;
            }
            if (numbers.contains(guestCome.charAt(0))) {
                vip.remove(guestCome);
            } else {
                regular.remove(guestCome);
            }
        }

        vip.addAll(regular);
        System.out.println(vip.size());

        for( String s : vip){
            System.out.println(s);
        }
    }
}
