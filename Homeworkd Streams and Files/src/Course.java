import java.io.Serializable;


public class Course implements Serializable {
    private  String name;
    private Integer numberOfStudents;
    Course(String nameInput,Integer numberOfStudentsInput){
        name = nameInput;
        numberOfStudents = numberOfStudentsInput;
    }
    public void printInfo()
    {
        System.out.println(name + " " + numberOfStudents);
    }

}
