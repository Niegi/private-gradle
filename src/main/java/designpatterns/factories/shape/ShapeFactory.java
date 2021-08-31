package designpatterns.factories.shape;

public class ShapeFactory {
  public static Shape getShape(String shape) {
    if ("rectangle".equals(shape)) {
      return new Rectangle();
    }
    if ("square".equals(shape)) {
      return new Square();
    }
    if ("circle".equals(shape)) {
      return new Circle();
    }
    return null;
  }
}
