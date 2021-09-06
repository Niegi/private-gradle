package designpatterns.strategy;

public class AddStrategy implements Strategy {
  @Override
  public int doOperation(int a, int b) {
    return a+b;
  }
}
