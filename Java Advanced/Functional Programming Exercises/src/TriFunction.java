import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        List<String> names = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));

        for (int k = 0; k < names.size(); k++) {
            int sum = 0;
            for (int i = 0; i < names.get(k).length(); i++) {
                sum += names.get(k).charAt(i);
            }

            if (sum >= number){
                System.out.println(names.get(k));
                return;
            }
        }
    }
}
