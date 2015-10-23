import java.util.Scanner;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textInput = scanner.nextLine();
        String searchedWord = scanner.nextLine();
        Integer wordCounter = 0;
        for (int i = 0; i < textInput.length()-searchedWord.length()+1; i++) {
            String textSubstring = textInput.substring(i,i+searchedWord.length());
            if(textSubstring.toLowerCase().equals(searchedWord.toLowerCase())){
                wordCounter++;
            }
        }
        System.out.println(wordCounter);
    }
}
