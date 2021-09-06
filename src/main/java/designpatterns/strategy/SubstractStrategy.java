package designpatterns.strategy;

public class SubstractStrategy implements Strategy {
  @Override
  public int doOperation(int a, int b) {
    return a-b;
  }
}
