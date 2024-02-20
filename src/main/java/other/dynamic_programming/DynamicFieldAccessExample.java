package other.dynamic_programming;

import java.lang.reflect.Field;

public class DynamicFieldAccessExample {

  public static void main(String[] args) {
    try {
      // Create an instance of the class dynamically (you can obtain it from user input, configuration, etc.)
      SomeFields instance = new SomeFields();

      // Get the class of the object
      Class<?> clazz = instance.getClass();

      // Accessing and modifying public fields
      Field publicField = clazz.getField("publicField");
      System.out.println("Original value of publicField: " + publicField.get(instance));
      publicField.set(instance, "Modified Value");
      System.out.println("Modified value of publicField: " + publicField.get(instance));

      // Accessing and modifying private fields
      Field privateField = clazz.getDeclaredField("privateField");
      privateField.setAccessible(true); // Make private field accessible
      System.out.println("Original value of privateField: " + privateField.get(instance));
      privateField.set(instance, "Modified Private Value");
      System.out.println("Modified value of privateField: " + privateField.get(instance));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class SomeFields {
  public String publicField = "Public Field Value";
  private String privateField = "Private Field Value";
}
