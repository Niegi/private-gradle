package designpatterns.factories.shape;

public class Square implements Shape {
  @Override
  public void draw() {
    System.out.println("I'm square");
  }
}
