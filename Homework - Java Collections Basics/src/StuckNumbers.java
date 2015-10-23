import java.util.Scanner;

public class StuckNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        scanner.nextLine();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        boolean hasFound = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        int a = numbers[i];
                        int b = numbers[j];
                        int c = numbers[k];
                        int d = numbers[l];
                        if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d){
                            String first = a+""+b;
                            String second = c+""+d;
                            if(first.toString().equals(second.toString())){
                                hasFound = true;
                                System.out.printf("%d|%d==%d|%d%n",numbers[i],numbers[j],numbers[k],numbers[l]);
                            }
                        }
                    }
                }
            }
        }
        if(!hasFound){
            System.out.println("No");
        }
    }
}
