import java.io.*;
public class CopyAPicture {
    public static void main(String[] args){

        String source = "resources/photo.jpg";
        String destination = "resources/photo-copy.jpg";

        try(InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length = is.read(buffer);
            while (length > 0){
                os.write(buffer, 0, length);
                length = is.read(buffer);
            }


        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
