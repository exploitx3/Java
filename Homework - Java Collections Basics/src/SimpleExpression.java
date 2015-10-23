import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression {
    public static void main(String[] args) {
        ArrayList<BigDecimal> numbersList = new ArrayList<>();
        Scanner scanner= new Scanner(System.in);
        String fullText = scanner.nextLine();
        fullText = fullText.replaceAll("\\s+","");
        Pattern numbers = Pattern.compile("([+-]|\\b)([\\d\\.]+)");
        Matcher numExtractor = numbers.matcher(fullText);
        BigDecimal sum = new BigDecimal(0);
        while (numExtractor.find()){
            BigDecimal num = new BigDecimal(numExtractor.group(2));
            String symbol = numExtractor.group(1);
            if(symbol.equals("+") || symbol.isEmpty()){
                sum = sum.add(num);
            }else{
                sum = sum.subtract(num);
            }
        }
        System.out.println(sum);

    }
}
