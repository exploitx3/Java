import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

                BufferedReader bfr = new BufferedReader(
                        new FileReader(
                                "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\lines.txt"));
                String fullText = "";
                String tempStr;

                while ((tempStr = bfr.readLine()) != null) {
                    fullText += tempStr.toUpperCase() + "\r\n";
                }

                PrintWriter prw = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(
                                        "C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\lines.txt")));
                prw.write(fullText);
                prw.flush();
                bfr.close();
                prw.close();


        }

    }
