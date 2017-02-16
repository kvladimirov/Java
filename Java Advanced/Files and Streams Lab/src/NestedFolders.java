import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        final String stringPath = "resources/Files-and-Streams";
        File root = new File(stringPath);
        Deque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        int count = 0;
        File[] nestedFiles = root.listFiles();
        while (!queue.isEmpty()) {
            File current = queue.poll();
            count++;
            System.out.println(current.getName());

            for (File dir : current.listFiles()) {
                if (dir.isDirectory()) {
                    queue.offer(dir);
                }
            }
        }
        System.out.println(count + " folders");
    }
}