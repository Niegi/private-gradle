package sii;

public final class Intern extends Employee {
  private String university;

  public Intern(String firstName, String lastName, String university) {
    super(firstName, lastName);
    this.university = university;
  }

  @Override
  public void isManager(boolean isManager) {
    System.out.println("This person is an intern");
  }
}
