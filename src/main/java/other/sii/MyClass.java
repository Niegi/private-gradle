package other.sii;

import java.util.List;
import java.util.Optional;

public class MyClass {

  public static void main(String[] args) {
    Employee employee1 = new Employee("Jan", "Kowalski");
    Employee employee2 = new Employee("Andrzej", "Test");

    List<Employee> employees = List.of(employee1, employee2);

    for (Employee e : employees) {
      if (e.getFirstName().equals("Andrzej")) {
        System.out.println(e);
      }
    }

    Optional<Employee> andrzej = employees.stream()
      .filter(e -> e.getFirstName().equals("Andrzej"))
      .findFirst();

//    System.out.println(employee1);
//    System.out.println(employee2);
  }
}
