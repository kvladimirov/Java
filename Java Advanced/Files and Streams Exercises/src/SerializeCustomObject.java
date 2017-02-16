import java.io.*;
public class SerializeCustomObject {
    public static void main(String[] args){
        final String output = "resources/Course.ser";

        Course course = new Course();
        course.name = "Pesho";
        course.numberOfStudents = 22;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output))) {

            oos.writeObject(course);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(output))) {

            Course courseLoaded = (Course) ois.readObject();
            System.out.println("Student name: " + courseLoaded.name);
            System.out.println("Number of students: " + courseLoaded.numberOfStudents);


        }  catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
