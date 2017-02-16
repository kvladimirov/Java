import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
public class CreateZipArchive {
    public static void main(String[] args){
        String zip = "resources/files.zip";
        String dir = "resources/files";

        try(FileOutputStream fos = new FileOutputStream(zip);
            ZipOutputStream zos = new ZipOutputStream(fos)) {

            byte[] buffer = new  byte[1024];

            File directory = new File(dir);
            File[] files = directory.listFiles();

            for (File file : files) {
                System.out.println("Adding file: " + file.getName());

                FileInputStream fis = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(file.getName()));

                int length = fis.read(buffer);

                while (length > 0){
                    zos.write(buffer, 0, length);
                    length = fis.read();
                }

            }

        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
