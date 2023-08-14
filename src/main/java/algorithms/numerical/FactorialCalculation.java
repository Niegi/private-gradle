package algorithms.numerical;

import java.util.stream.LongStream;

public class FactorialCalculation {

  public static long factorialRecursive(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * factorialRecursive(n - 1);
  }

  public static long factorialLoop(int n) {
    long factorial = 1;
    for (int i = 2; i <= n; i++) {
      factorial = factorial * i;
    }
    return factorial;
  }

  public static long factorialStreams(int n) {
    return LongStream.rangeClosed(1, n)
      .reduce(1, (long x, long y) -> x * y);
  }

  public static void main(String[] args) {
    int n = 5;
    long factorialRecursive = factorialRecursive(n);
    long factorialLoop = factorialLoop(n);
    long factorialStreams = factorialStreams(n);
    System.out.println("Factorial of " + n + " computed recursively is: " + factorialRecursive);
    System.out.println("Factorial of " + n + " computed by loop is: " + factorialLoop);
    System.out.println("Factorial of " + n + " computed by Stream is: " + factorialStreams);
  }
}