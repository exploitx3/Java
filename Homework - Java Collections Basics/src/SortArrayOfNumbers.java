import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        scanner.nextLine();
        int[] arrayOfNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            arrayOfNumbers[i] = scanner.nextInt();
        }
        Arrays.sort(arrayOfNumbers);
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }

    }
}
