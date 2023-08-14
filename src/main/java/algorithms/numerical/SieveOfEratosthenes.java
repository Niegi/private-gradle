package algorithms.numerical;

import java.util.Arrays;

public class SieveOfEratosthenes {

  public static void sieveOfEratosthenes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }

    System.out.println("Prime numbers in the range 2 to " + n + ":");
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) {
        System.out.print(i + " ");
      }
    }
  }

  public static void main(String[] args) {
    int n = 100;
    sieveOfEratosthenes(n);
  }
}