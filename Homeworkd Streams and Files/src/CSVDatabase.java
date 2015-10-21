import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CSVDatabase {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(
                new FileReader(
                        "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\students.txt"));

        try {
            Pattern getStudents = Pattern.compile("(\\d+?),([A-Za-z]+?),([A-Za-z]+?),(\\d+?),([A-Za-z\\s]*)\\b");
            Pattern getGrades = Pattern.compile(".*\\n");
            HashMap<Integer, Student> students = new HashMap<>();
            HashMap<Integer, HashMap<String, ArrayList<String>>> grades = new HashMap<>();


            StringBuilder fullTextStudents = new StringBuilder();
            String readerValue;
            while ((readerValue = bfr.readLine()) != null) {
                fullTextStudents.append(readerValue + "\n");
            }
            StringBuilder fullTextGrades = new StringBuilder();
            bfr = new BufferedReader(
                    new FileReader(
                            "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\grades.txt"));
            while ((readerValue = bfr.readLine()) != null) {
                fullTextGrades.append(readerValue + "\n");
            }
            Matcher matcherStudents = getStudents.matcher(fullTextStudents);
            while (matcherStudents.find()) {
                Integer id = Integer.parseInt(matcherStudents.group(1));
                String name = matcherStudents.group(2) + " " + matcherStudents.group(3);
                Integer age = Integer.parseInt(matcherStudents.group(4));
                String town = matcherStudents.group(5).trim();

                if (!students.containsKey(id)) {
                    students.put(id, new Student(name, age, town));
                }
            }

            String lastId = "";
            Matcher matcherGrades = getGrades.matcher(fullTextGrades);
            while (matcherGrades.find()) {
                String nextLine = matcherGrades.group();
                Pattern gradesInnerExtractor = Pattern.compile("(\\d+?|),([A-Za-z]+?)\\s+?([0-9\\.\\s]+)");
                Matcher innerMacher = gradesInnerExtractor.matcher(nextLine);
                HashMap<String, ArrayList<String>> tempMap = new HashMap<>();
                int id = 0;
                while (innerMacher.find()) {
                    if (!innerMacher.group(1).isEmpty()) {
                        id = Integer.parseInt(innerMacher.group(1));
                    }
                    String subject = innerMacher.group(2);
                    ArrayList<String> gradesList = new ArrayList<>();
                    String[] gradesStr = innerMacher.group(3).split("\\s+");
                    for (String s : gradesStr) {
                        gradesList.add(s);
                    }
                    tempMap.put(subject, gradesList);
                }

                if (!grades.containsKey(id)) {
                    grades.put(id, tempMap);
                }

            }

            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);

            boolean hasFound = false;
            boolean exit = false;
            while(!exit) {
                System.out.println("0-Print Information\r\n"+
                        "1-Search-by-full-name(Example:Gosho Ivanov )\r\n" +
                        "2-Search-by-id(Example: 3\r\n" +
                        "3-Delete-by-id(Example: 3\r\n" +
                        "4-Update-by-id(Example: 3\r\n" +
                        "5-Insert-student(Example: Georgi Mamarchev 19 Sofia)\r\n" +
                        "6-Insert-grade-by-id(Example: 5 Math 4.00 Meth 6.00 Fizkultura 6.56)\r\n" +
                        "7-Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        for (Integer idStudent : students.keySet()) {

                            System.out.printf("%s (age: %d,town: %s)%n", students.get(idStudent).getName(), students.get(idStudent).getAge(), students.get(idStudent).getTown());
                            boolean notEmpty = grades.containsKey(idStudent);
                            if(notEmpty){
                            for (String idStudentGrades : grades.get(idStudent).keySet()) {
                                String gradesString = String.join(", ", grades.get(idStudent).get(idStudentGrades));
                                System.out.printf("# %s: %s%n", idStudentGrades, gradesString);
                            }
                          }
                        }
                        break;
                    case 1:
                        System.out.println("Enter full name: ");
                        String searchName = scanner.nextLine();
                        hasFound = false;
                        for (Integer idStudent : students.keySet()) {
                            if (students.get(idStudent).getName().compareTo(searchName) == 0) {
                                System.out.printf("%s (age: %d,town: %s)%n", students.get(idStudent).getName(), students.get(idStudent).getAge(), students.get(idStudent).getTown());
                                for (String idStudentGrades : grades.get(idStudent).keySet()) {
                                    String gradesString = String.join(", ", grades.get(idStudent).get(idStudentGrades));
                                    System.out.printf("# %s: %s%n", idStudentGrades, gradesString);
                                }
                                hasFound = true;
                            }
                        }
                        if (!hasFound) {
                            System.out.println("Student does not exist");
                        }
                        break;
                    case 2:
                        System.out.println("Enter ID: ");
                        Integer searchedId = scanner.nextInt();
                        hasFound = false;
                        for (Integer idStudent : students.keySet()) {
                            if (searchedId == idStudent) {
                                System.out.printf("%s (age: %d,town: %s)", students.get(idStudent).getName(), students.get(idStudent).getAge(), students.get(idStudent).getTown());
                                for (String idStudentGrades : grades.get(idStudent).keySet()) {
                                    String gradesString = String.join(", ", grades.get(idStudent).get(idStudentGrades));
                                    System.out.printf("# %s: %s%n", idStudentGrades, gradesString);
                                }
                                hasFound = true;
                            }
                        }
                        if (!hasFound) {
                            System.out.println("Student does not exist");
                        }

                        break;
                    case 3:
                        System.out.println("Enter ID: ");
                        Integer deleteId = scanner.nextInt();
                        boolean hasRemoved = false;
                        for (Integer idStudent : students.keySet()) {
                            if (deleteId == idStudent) {
                                students.remove(deleteId);
                                grades.remove(deleteId);
                                hasRemoved = true;
                                break;
                            }
                        }
                        if (!hasRemoved) {
                            System.out.println("Student does not exist");
                        }
                        break;
                    case 4:
                        bfr.close();
                        System.out.println("Enter ID: ");
                        Integer updateId = scanner.nextInt();
                        boolean hasUpdated = false;
                        BufferedReader newBfr = new BufferedReader(
                                new FileReader("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\students.txt"));

                        StringBuilder updateContainer = new StringBuilder();
                        String inputReader;
                        while ((inputReader = newBfr.readLine()) != null) {
                            updateContainer.append(inputReader + "\r\n");
                        }

                        Matcher updateMatcher = getStudents.matcher(updateContainer);
                        while (updateMatcher.find()) {
                            Integer id = Integer.parseInt(updateMatcher.group(1));
                            String name = updateMatcher.group(2) + " " + updateMatcher.group(3);
                            Integer age = Integer.parseInt(updateMatcher.group(4));
                            String town = updateMatcher.group(5).trim();

                            if (id == updateId) {
                                students.replace(id, new Student(name, age, town));
                                hasUpdated = true;
                            }
                        }
                        if (!hasUpdated) {
                            System.out.println("Student does not exist");
                        }
                        newBfr.close();
                        break;
                    case 5:
                        System.out.println("Insert Student: ");
                        String[] studentStr = scanner.nextLine().split("\\s+");
                        String name = studentStr[0] + " " + studentStr[1];
                        Integer age = Integer.parseInt(studentStr[2]);
                        String town = studentStr.length == 4 ? studentStr[3] : studentStr[3] + " " + studentStr[4];
                        students.put(students.size() + 1, new Student(name, age, town));

                        break;
                    case 6:
                        System.out.println("Insert Grades by ID: ");
                        String lineGrades = scanner.nextLine();


                        Pattern gradesInnerExtractor = Pattern.compile("(\\d*?)([A-Za-z\\s]+?)([0-9\\.\\s]+)");
                        Matcher innerMacher = gradesInnerExtractor.matcher(lineGrades);

                        HashMap<String, ArrayList<String>> tempMap = new HashMap<>();
                        int id = grades.size()-1;
                        hasFound = false;

                        while (innerMacher.find()) {
                            if (!innerMacher.group(1).isEmpty()) {

                                id = Integer.parseInt(innerMacher.group(1));
                            }
                            String subject = innerMacher.group(2);
                            ArrayList<String> gradesList = new ArrayList<>();
                            String[] gradesStr = innerMacher.group(3).split("\\s+");
                            for (String s : gradesStr) {
                                gradesList.add(s);
                            }
                            tempMap.put(subject.trim(), gradesList);
                            if (!grades.containsKey(id)) {
                                grades.put(grades.size() + 1,tempMap);

                            } else {
                                hasFound = true;
                                for (String subjectStr : tempMap.keySet()) {
                                    if (!grades.get(id).containsKey(subjectStr)) {
                                        grades.get(id).putAll(tempMap);
                                    } else {
                                        grades.get(id).get(subjectStr).addAll(tempMap.get(subjectStr));
                                    }
                                }
                            }
                        }
                        if(!hasFound)
                        {
                            System.out.println("Student does not exist");
                        }
                        break;
                    case 7:
                        exit = true;
                        break;


                }
            }
            BufferedWriter  bfwS =  new BufferedWriter(
                        new FileWriter(
                                "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\students.txt"));
                BufferedWriter  bfwG =  new BufferedWriter(
                        new FileWriter(
                                "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\grades.txt"));


                for (Integer idStudent : students.keySet()) {
                    StringBuilder gradesInfo = new StringBuilder();
                    //System.out.printf("%s (age: %d,town: %s)", students.get(idStudent).getName(), students.get(idStudent).getAge(), students.get(idStudent).getTown());
                    if(!grades.get(idStudent).isEmpty()) {
                        for (String idStudentGrades : grades.get(idStudent).keySet()) {
                            String gradesString = String.join(" ", grades.get(idStudent).get(idStudentGrades));
                            // System.out.printf("# %s: %s%n", idStudentGrades, gradesString);
                            gradesInfo.append("," + idStudentGrades + " " + gradesString);
                        }
                    }
                    String[] nameSeperated = students.get(idStudent).getName().split("\\s+");
                    bfwS.write(String.format("%d,%s,%s,%d,%s%n",
                            idStudent,
                            nameSeperated[0],
                            nameSeperated[1],
                            students.get(idStudent).getAge(),
                            students.get(idStudent).getTown()));
                    String joinedString = idStudent + gradesInfo.toString()+"\r\n";
                    bfwG.write(joinedString);
                }

            bfwG.close();
            bfwS.close();
        }
        finally {
            bfr.close();

        }

    }
}
