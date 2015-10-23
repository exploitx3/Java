import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MostFrequentWord {
    public static void main(String[] args) {
        TreeMap<String,Integer> strings = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        Pattern pattern = Pattern.compile("[^a-z]*([a-z]+)[^a-z]+");
        Matcher wordExtractor = pattern.matcher(inputText.toLowerCase());
        while(wordExtractor.find()) {
            if(strings.containsKey(wordExtractor.group(1))){
                strings.put(wordExtractor.group(1),strings.get(wordExtractor.group(1))+1);
            }else{
                strings.put(wordExtractor.group(1),1);
            }
        }
        Integer maxLength = strings.values().stream().max(Integer::compare).get();

        for(String key : strings.keySet()){
            if(strings.get(key) == maxLength){
                System.out.printf("%s -> %d times%n",key,maxLength);
            }
        }
    }
}
