import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by Leet on 10/22/2015.
 */
public class LongestIncreasingSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputText = scanner.nextLine().split("\\s+");
        ArrayList<String> maxList = new ArrayList<>();
        ArrayList<String> currentList = new ArrayList<>();

        for (int i = 0; i < inputText.length-1; i++) {
              if(Integer.parseInt(inputText[i])<Integer.parseInt(inputText[i+1])){
                  currentList.add(inputText[i]);
                  if(i==inputText.length-2){
                      currentList.add(inputText[i+1]);
                      if (maxList.size() < currentList.size()) {
                          maxList = currentList;
                      }
                      System.out.println(String.join(" ", currentList));
                  }

              }else {
                  currentList.add(inputText[i]);
                  if (maxList.size() < currentList.size()) {
                      maxList = new ArrayList<String>(currentList);
                  }
                  System.out.println(String.join(" ", currentList));
                  currentList.clear();
                  if (i == inputText.length-2){
                      System.out.println(inputText[i+1]);
                  }
              }
        }
        System.out.println("Longest: " + String.join(" ",maxList));




    }
}
