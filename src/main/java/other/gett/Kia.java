package other.gett;

class Kia extends Car {
  String type;

  public Kia(String color, String manufactor, int wheelsNumber, String type) {
    super(color, manufactor, wheelsNumber);
    this.type = type;
  }

  @Override
  public void ride() {
    System.out.println("We are riding Kia");
  }

  @Override
  public boolean ignition(int temperature) {
    return temperature >= -5;
  }

  @Override
  public String toString() {
    return "Kia{" +
      "type='" + type + '\'' +
      ", color='" + color + '\'' +
      ", manufactor='" + manufactor + '\'' +
      ", wheelsNumber=" + wheelsNumber +
      '}';
  }
}