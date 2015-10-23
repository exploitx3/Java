import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountAllWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern wordPattern =  Pattern.compile("\\b\\w+\\b");
        String textInput = scanner.nextLine();
        Matcher wordMatcher = wordPattern.matcher(textInput);
        Integer wordCounter = 0;
        while(wordMatcher.find()){
            wordCounter++;
        }
        System.out.println(wordCounter);

    }
}
