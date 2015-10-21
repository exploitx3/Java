import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyJpgFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\newYork.jpg");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\my-copied-picture.jpg");
        int byteContainer;
        while((byteContainer = fis.read())!=-1)
        {
            fos.write(byteContainer);
        }
        fis.close();
        fos.close();
    }
}
