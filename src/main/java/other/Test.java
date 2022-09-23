package other;

public class Test {
  public static final int NUMBER_OF_BRANCHES = 10;

  public static void main(String[] args) {
    draw();
  }

  public static void draw() {
    for (int i=1 ; i<=NUMBER_OF_BRANCHES ; i++) {
      for (int j=0 ; j<NUMBER_OF_BRANCHES-i ; j++) {
        System.out.print(" ");
      }
      for (int j=0 ; j<i ; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
