package designpatterns.strategy;

public class StrategyContext {
  Strategy strategy;

  public StrategyContext(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int execute(int a, int b) {
    return strategy.doOperation(a, b);
  }
}
