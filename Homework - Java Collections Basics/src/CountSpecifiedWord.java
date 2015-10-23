import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textInput = scanner.nextLine();
        String searchedWord = scanner.nextLine();
        Pattern wordPattern =  Pattern.compile("[^a-z]*"+ searchedWord.toLowerCase() +"+[^a-z]+");

        Matcher wordMatcher = wordPattern.matcher(textInput.toLowerCase());
        Integer wordCounter = 0;
        while(wordMatcher.find()){
            wordCounter++;
        }
        System.out.println(wordCounter);

    }
}
