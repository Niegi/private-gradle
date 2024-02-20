package other.dynamic_programming;

import java.lang.reflect.Method;

public class DynamicMethodInvocationExample {

  public static void main(String[] args) {
    try {
      // Get the class dynamically (you can obtain it from user input, configuration, etc.)
      Class<?> clazz = DynamicClass.class;

      // Instantiate an object of the class
      Object instance = clazz.newInstance();

      // Get the method name dynamically (you can obtain it from user input, configuration, etc.)
      String methodName = "dummyMethod";

      // Get the method with the specified name and parameter types
      Method method = clazz.getMethod(methodName, String.class);

      // Invoke the method on the object dynamically
      Object result = method.invoke(instance, "Dynamic Argument");

      // Print the result
      System.out.println("Result of dynamic method invocation: " + result);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
