import java.io.*;

public class SaveACustomObjectInAFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\course.save"));
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\course.save"));
        Course newCourse = new Course("Java Fundamentals",150);
        oos.writeObject(newCourse);
        Course readerObject = (Course)ois.readObject();
        readerObject.printInfo();

    }

}
