import java.util.LinkedHashMap;
import java.util.Scanner;

public class LargestSequenceOfEqualStrings {
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
        Integer maxLength = strings.values().stream().max(Integer::compare).get();

        for(String key : strings.keySet()){
            if(strings.get(key) == maxLength){
                for (int i = 0; i < maxLength; i++) {
                    System.out.print(key+" ");
                }
                System.out.println();
                break;
            }
        }



    }
}
