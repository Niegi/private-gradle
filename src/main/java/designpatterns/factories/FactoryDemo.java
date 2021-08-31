package designpatterns.factories;

public class FactoryDemo {
  public static void main(String[] args) {
    PointFct cartesianPoint = PointFct.Factory.newCartesianPoint(2, 3);
    PointFct polarPoint = PointFct.Factory.newPolarPoint(2, 3);
    System.out.println(cartesianPoint);
    System.out.println(polarPoint);
  }
}
