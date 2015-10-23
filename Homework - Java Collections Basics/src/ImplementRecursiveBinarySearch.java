import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ImplementRecursiveBinarySearch {
    private static int binarySearchImplementation(int[] array,int first,int last,int searchedValue){
        if(last<first){
            return -1;
        }
        int middle = (first+last) >> 1;
        if(array[middle]>searchedValue){
            return binarySearchImplementation(array,first,middle-1,searchedValue);
        }else if(array[middle]<searchedValue){
            return  binarySearchImplementation(array,middle+1,last,searchedValue);
        }else{
            return middle;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer searchedNumber = scanner.nextInt();
        scanner.nextLine();
        int[] arrayOfNumbers = Stream.of(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arrayOfNumbers);
        System.out.println(binarySearchImplementation(arrayOfNumbers,0,arrayOfNumbers.length-1,searchedNumber));

    }
}
