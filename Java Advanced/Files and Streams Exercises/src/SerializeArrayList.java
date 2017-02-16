import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args){

        final String output = "resources/list.ser";

        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(10.2);
        doubles.add(4.1);
        doubles.add(9.7);
        doubles.add(8.1);


        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output))) {

            oos.writeObject(doubles);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(output))) {

            ArrayList<Double> loadDoubles = (ArrayList<Double>)ois.readObject();
            for (Double loadDouble : loadDoubles) {
                System.out.println(loadDouble);
            }




        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
