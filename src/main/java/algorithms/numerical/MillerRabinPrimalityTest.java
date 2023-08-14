package algorithms.numerical;

import java.util.Random;

public class MillerRabinPrimalityTest {

  public static boolean isProbablePrime(int n, int k) {
    if (n <= 1) {
      return false;
    }
    if (n <= 3) {
      return true;
    }

    // Write n as (2^r) * d + 1
    int r = 0;
    int d = n - 1;
    while (d % 2 == 0) {
      r++;
      d /= 2;
    }

    // Witness loop
    for (int i = 0; i < k; i++) {
      int a = 2 + new Random().nextInt(n - 3);
      int x = power(a, d, n);

      if (x == 1 || x == n - 1) {
        continue;
      }

      for (int j = 0; j < r - 1; j++) {
        x = (x * x) % n;
        if (x == n - 1) {
          break;
        }
      }

      if (x != n - 1) {
        return false;
      }
    }

    return true;
  }

  public static int power(int x, int y, int p) {
    int res = 1;
    x = x % p;

    while (y > 0) {
      if (y % 2 == 1) {
        res = (res * x) % p;
      }
      y = y >> 1;
      x = (x * x) % p;
    }

    return res;
  }

  public static void main(String[] args) {
    int num = 11;
    int iterations = 5;

    boolean isPrime = isProbablePrime(num, iterations);
    if (isPrime) {
      System.out.println(num + " is likely prime.");
    } else {
      System.out.println(num + " is not prime.");
    }
  }
}
