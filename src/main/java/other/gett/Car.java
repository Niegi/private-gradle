package other.gett;

abstract class Car {
  String color;
  String manufactor;
  int wheelsNumber;

  public Car(String color, String manufactor, int wheelsNumber) {
    this.color = color;
    this.manufactor = manufactor;
    this.wheelsNumber = wheelsNumber;
  }

  abstract void ride();
  abstract boolean ignition(int temperature);
}
