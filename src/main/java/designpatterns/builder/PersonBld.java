package designpatterns.builder;

public class PersonBld {
  private String name;
  private String surname;
  private int age;

  public PersonBld(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public static class PersonBldBuilder {

    private String name;
    private String surname;
    private int age;

    public PersonBldBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PersonBldBuilder surname(String surname) {
      this.surname = surname;
      return this;
    }

    public PersonBldBuilder age(int age) {
      this.age = age;
      return this;
    }

    public PersonBld build() {
      return new PersonBld(name, surname, age);
    }
  }

  @Override
  public String toString() {
    return "PersonBld{" +
      "name='" + name + '\'' +
      ", surname='" + surname + '\'' +
      ", age=" + age +
      '}';
  }
}
