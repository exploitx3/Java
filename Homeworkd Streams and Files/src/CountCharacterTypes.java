import java.io.*;


public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String vowelsSymbols = "aeiou";
        String punctuationSymbols = "!.,?";
        Integer consonants = 0;
        Integer vowels = 0;
        Integer punctuation = 0;
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\words.txt"));
        FileWriter fos = new FileWriter(new File("C:\\Users\\Leet\\IdeaProjects\\Homeworkd Streams and Files\\src\\count-chars.txt"));
        int symbol;
        while((symbol = fis.read())!=-1)
        {
            char ch = (char)symbol;
            if(vowelsSymbols.contains(ch+"")){
                vowels++;
            }else if(punctuationSymbols.contains(ch+"")){
                punctuation++;
            }else if(Character.isLetter(ch)){
                consonants++;
            }
        }
        fos.write(String.format("Vowels: %d%n",vowels));
        fos.write(String.format("Consonants: %d%n",consonants));
        fos.write(String.format("Punctuation: %d%n",punctuation));
        fis.close();
        fos.close();
    }
}
