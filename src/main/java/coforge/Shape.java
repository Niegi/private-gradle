package coforge;

abstract class Shape {

  private int sides;

  public Shape(int sides) {
    this.sides = sides;
  }

  public int getSides() {
    return sides;
  }
}
