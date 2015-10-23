import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumCards {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String fullText = scanner.nextLine();
        Pattern pattern = Pattern.compile("([^SCHD\\ ]+)([SCHD])");
        Matcher cardExtractor = pattern.matcher(fullText);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> faces = new ArrayList<>();

        while(cardExtractor.find()){
            String currentValue = cardExtractor.group(1);
            String currentFace = cardExtractor.group(2);
            Integer currentIntegerValue = 0;
            switch (currentValue){
                case "J":
                    currentIntegerValue = 12;
                    break;
                case "Q":
                    currentIntegerValue = 13;
                    break;
                case "K":
                    currentIntegerValue = 14;
                    break;
                case "A":
                    currentIntegerValue = 15;
                    break;
                default:
                    currentIntegerValue = Integer.parseInt(currentValue);
                    break;
            }
            numbers.add(currentIntegerValue);
            faces.add(currentFace);
        }
        numbers.add(0);
        Integer sum = 0;
        Integer counter = 1;
        Integer lastValue = numbers.get(0);
        for (int i = 0; i < numbers.size()-1; i++) {
                if(numbers.get(i) == numbers.get(i+1)){
                    counter++;
                }else{
                    if(counter != 1){
                        sum+=(numbers.get(i)*counter)*2;
                    }else{
                        sum+=numbers.get(i);
                    }
                    counter = 1;
                }
        }

        System.out.println(sum);
    }
}
