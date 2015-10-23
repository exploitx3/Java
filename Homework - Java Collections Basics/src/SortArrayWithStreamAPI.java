import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class SortArrayWithStreamAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> stringsList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        String order = scanner.nextLine();
        if(order.equals("Ascending")){
            stringsList.stream().sorted().forEach(s -> System.out.print(s+ " "));
        }else {
            Collections.reverse(stringsList);
            stringsList = new ArrayList<String>(stringsList.stream().sorted().collect(Collectors.toList()));
            Collections.reverse(stringsList);
            stringsList.forEach(s -> System.out.print(s+ " "));
        }

    }
}
