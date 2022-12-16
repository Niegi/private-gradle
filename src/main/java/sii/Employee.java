package sii;

public class Employee {
  private int id;
  private String firstName;
  private String lastName;
  static int counter = 0;

  public Employee(String firstName, String lastName) {
    this.id = counter;
    counter++;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void isManager(boolean isManager) {
    if (isManager) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  @Override
  public String toString() {
    return "Employee{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
