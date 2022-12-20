package other.gett;

class Mazda extends Car {
  String type;

  public Mazda(String color, String manufactor, int wheelsNumber, String type) {
    super(color, manufactor, wheelsNumber);
    this.type = type;
  }

  @Override
  public void ride() {
    System.out.println("We are riding Mazda");
  }

  @Override
  public boolean ignition(int temperature) {
    return temperature >= -5;
  }

  @Override
  public String toString() {
    return "Mazda{" +
      "type='" + type + '\'' +
      ", color='" + color + '\'' +
      ", manufactor='" + manufactor + '\'' +
      ", wheelsNumber=" + wheelsNumber +
      '}';
  }
}