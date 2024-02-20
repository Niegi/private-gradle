package other.dynamic_programming;

public class DynamicClass implements DynamicInterface {

  @Override
  public void sayHello() {
    System.out.println("Hello");
  }

  @Override
  public String dummyMethod(String param) {
    return "Dynamic method invoked with argument: " + param;
  }
}
