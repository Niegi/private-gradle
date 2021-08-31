package designpatterns.factories;

public class PointFct {
  private double x, y;

  private PointFct(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static class Factory {

    public static PointFct newCartesianPoint(double x, double y) {
      return new PointFct(x, y);
    }

    public static PointFct newPolarPoint(double rho, double theta) {
      return new PointFct(rho*Math.cos(theta), rho*Math.sin(theta));
    }
  }

  @Override
  public String toString() {
    return "PointFct{" +
      "x=" + x +
      ", y=" + y +
      '}';
  }
}
