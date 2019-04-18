package profile;

import java.math.BigInteger;

public class ProfileTailOptimizedFactorial {

    private static BigInteger fact(BigInteger n) {
        return n.intValue() ==  0 || n.intValue() == 1
                ? BigInteger.ONE
                : n.multiply(fact(n.subtract(BigInteger.ONE)));
    }

    private static BigInteger fact(BigInteger acc, BigInteger n) {
        return n.intValue() ==  0 || n.intValue() == 1
                ? acc
                : fact(acc.multiply(n) , n.subtract(BigInteger.ONE));
    }

    public static void main(String[] args) {
        BigInteger ff = fact(BigInteger.ONE,BigInteger.valueOf(100));
        System.out.println(ff.toString());

      /*  int i = 12500;
        try {
            for (;i < 20000; i++) {
                System.out.println(i);
            }
        } catch (StackOverflowError error) {
            System.out.println("Error at: " + i);
        }*/
    }
}