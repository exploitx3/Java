import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullText = scanner.nextLine();
        Pattern pattern = Pattern.compile("(([A-Za-z]{1}[A-Za-z\\_\\.\\-]*?)@([a-zA-Z]{1}[A-Za-z\\-\\.]+))(?:\\.|\\b)");
        Matcher emailExtractor = pattern.matcher(fullText);
        while (emailExtractor.find()){
            System.out.println(emailExtractor.group(1));
        }

    }
}
