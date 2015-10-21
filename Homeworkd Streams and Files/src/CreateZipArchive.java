import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Leet on 10/20/2015.
 */
public class CreateZipArchive {
    public static void main(String[] args) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(
                new FileOutputStream("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\text-files.zip"));
        FileInputStream fis = new FileInputStream(
                new File("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\words.txt"));
        int byteContainter;
        zos.putNextEntry(new ZipEntry("words.txt"));

        while((byteContainter = fis.read())!=-1){
            zos.write(byteContainter);
        }
        zos.closeEntry();
        zos.putNextEntry(new ZipEntry("count-chars.txt"));
        fis = new FileInputStream(
                new File("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\count-chars.txt"));
        while((byteContainter = fis.read())!=-1){
            zos.write(byteContainter);
        }
        zos.closeEntry();
        zos.putNextEntry(new ZipEntry("lines.txt"));
        fis = new FileInputStream(
                new File("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\lines.txt"));
        while((byteContainter = fis.read())!=-1){
            zos.write(byteContainter);
        }
        zos.closeEntry();
        zos.finish();
        zos.close();




    }
}
