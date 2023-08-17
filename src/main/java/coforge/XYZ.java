package coforge;

public class XYZ {
  public static void main(String[] args) {
    Shape triangle = new Triangle();
    Shape square = new Square();
    System.out.println(triangle.getSides());
    System.out.println(square.getSides());
  }
}
