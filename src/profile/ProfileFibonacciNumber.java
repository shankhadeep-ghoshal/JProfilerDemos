package profile;

import java.math.BigInteger;

public class ProfileFibonacciNumber {

    private static long fibonacciNormal(int counter) {
        return counter == 1 || counter == 2
                ? 1
                : fibonacciNormal(counter - 1) + fibonacciNormal(counter - 2);
    }

    private static long fibonacciDP(long[] array, int counter) {
        if (!(array[counter] == 0L)) {
            return array[counter];
        }
        if (counter == 1 || counter == 2) return 1L;
        final long result = fibonacciDP(array,counter - 1) + fibonacciDP(array, counter - 2);
        array[counter] = result;
        return result;
    }

    private static BigInteger bigIntegerFibonacci(int counter) {
        return counter == 1 || counter == 2
                ? BigInteger.ONE
                : bigIntegerFibonacci(counter - 1).add(bigIntegerFibonacci(counter-2));
    }

    private static BigInteger bigIntegerFibonacciDp(int counter, BigInteger[] array) {
        if (array[counter] != null) {
            return array[counter];
        }
        if (counter == 1 || counter == 2) {
            return BigInteger.ONE;
        }
        final BigInteger result = bigIntegerFibonacciDp(counter - 1, array)
                .add(bigIntegerFibonacciDp(counter - 2, array));
        array[counter] = result;
        return result;
    }

    private static BigInteger bigIntegerFibonacciDpIterative(int counter) {
        BigInteger[] array = new BigInteger[counter + 2];
        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;

        for (int i = 2; i <= counter; i++) {
            array[i] = array[i-1].add(array[i-2]);
        }

        return array[counter];
    }

    private static BigInteger spaceOptimizedFibonacci(int counter) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;

        if (counter == 0) return a;
        for (int i = 0 ; i <= counter ; i++) {
            c = a.add(b);
            a = new BigInteger(b.toString());
            b = new BigInteger(c.toString());
        }
        return b;
    }

    public static void main(String[] args) {
        final int counter = 1000;
        BigInteger[] array = new BigInteger[counter+1];
        BigInteger result = bigIntegerFibonacciDp(counter, array);
//        BigInteger result = bigIntegerFibonacci(counter);
    }
}