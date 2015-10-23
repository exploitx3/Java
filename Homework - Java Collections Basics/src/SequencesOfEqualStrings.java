import java.util.LinkedHashMap;
import java.util.Scanner;

public class SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputText = scanner.nextLine().split("\\s+");
        LinkedHashMap<String,Integer> strings = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < inputText.length; i++) {
            if(strings.containsKey(inputText[i])){
                strings.put(inputText[i],strings.get(inputText[i])+1);
            }else{
                strings.put(inputText[i],1);
            }
        }
        for(String key : strings.keySet()){
            for (int i = 0; i < strings.get(key); i++) {
                System.out.print(key + " ");
            }
            System.out.println();
        }


    }
}
