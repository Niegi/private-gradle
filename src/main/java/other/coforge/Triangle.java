package other.coforge;

public class Triangle extends Shape {
  private static final int TRIANGLE_SIDES = 3;

  public Triangle() {
    super(TRIANGLE_SIDES);
  }

  public Integer sum(Integer x, Integer y) {    return x + y;
  }
}
