import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.io.*;
import java.util.ArrayList;

public class SaveAnArrayListOfDoubles {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(
                "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\doubles.list"));
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(5.6);
        doubles.add(45.6);
        doubles.add(3.46);
        oos.writeObject(doubles);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\doubles.list"));
        System.out.println(ois.readObject());
        ois.close();


    }
}
