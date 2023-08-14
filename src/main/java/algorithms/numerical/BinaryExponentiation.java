package algorithms.numerical;

public class BinaryExponentiation {

  public static long binaryExponentiation(long base, int exponent) {
    if (exponent == 0) {
      return 1;
    }

    long result = binaryExponentiation(base, exponent / 2);

    if (exponent % 2 == 0) {
      return result * result;
    } else {
      return base * result * result;
    }
  }

  public static void main(String[] args) {
    long base = 2;
    int exponent = 10;

    long result = binaryExponentiation(base, exponent);
    System.out.println(base + "^" + exponent + " = " + result);
  }
}
