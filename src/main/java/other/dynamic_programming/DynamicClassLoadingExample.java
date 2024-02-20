package other.dynamic_programming;

public class DynamicClassExample {

  public static void main(String[] args) {
    try {
      // Get the class name dynamically (you can obtain it from user input, configuration, etc.)
      String className = "other.dynamic_programming.DynamicClass";

      // Load the class dynamically
      Class<?> dynamicClass = Class.forName(className);

      // Instantiate an object of the dynamically loaded class
      Object instance = dynamicClass.newInstance();

      // Now you can work with the dynamically loaded class
      if (instance instanceof DynamicInterface) {
        DynamicInterface dynamicObject = (DynamicInterface) instance;
        dynamicObject.sayHello();
      } else {
        System.out.println("The dynamically loaded class does not implement the expected interface.");
      }

    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
