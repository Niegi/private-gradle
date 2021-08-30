package designpatterns.builder;

public class BuilderDemo {

  public static void main(String[] args) {
    PersonBld personBld = new PersonBld.PersonBldBuilder()
      .name("Tomek")
      .surname("Niegowski")
      .age(30)
      .build();
    System.out.println(personBld);
  }


}

