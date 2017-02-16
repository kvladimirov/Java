import java.io.File;
import java.util.ArrayDeque;
public class GetFolderSize {
    public static void main(String[] args){

        String pathname = "resources/Files-and-Streams";
        File file = new File(pathname);

        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(file);

        long size = 0;

        while (!directories.isEmpty()){
            File currentFolder = directories.poll();

            for (File file1 : currentFolder.listFiles()) {
                if(file1.isFile()){
                    size += file1.length();
                }
            }
        }

        System.out.println("Folder size: " +size);
    }
}
