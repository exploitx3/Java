import java.math.BigInteger;
import java.util.Scanner;


public class CalculateNFactorial {
    private static BigInteger calculateFactorial(BigInteger number){
        if(number.compareTo(BigInteger.ONE)==-1){
            return (BigInteger.ONE);
        }
        return calculateFactorial(number.subtract(BigInteger.ONE)).multiply(number);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = scanner.nextBigInteger();
        System.out.println(calculateFactorial(number));
    }

}
