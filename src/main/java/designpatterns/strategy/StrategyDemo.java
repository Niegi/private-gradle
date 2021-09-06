package designpatterns.strategy;

public class StrategyDemo {

  public static void main(String[] args) {
    Strategy strategy = new AddStrategy();
    StrategyContext context = new StrategyContext(strategy);
    System.out.println("3+3=" + context.execute(3,3));
    strategy = new SubstractStrategy();
    context.setStrategy(strategy);
    System.out.println("3-3=" + context.execute(3,3));
    strategy = new MultiplyStrategy();
    context.setStrategy(strategy);
    System.out.println("3*3=" + context.execute(3,3));
  }

}
