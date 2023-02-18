import java.math.BigInteger;

public class Main {
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= value; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result; // your implementation here
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Expected exactly 1 argument");
        }
        System.out.println(factorial(Integer.parseInt(args[0])));
    }
}