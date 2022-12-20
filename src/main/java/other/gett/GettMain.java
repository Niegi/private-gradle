package other.gett;

import java.util.List;

public class GettMain {

  public static void main(String[] args) {
    Mazda myMazda = new Mazda("red", "some manufactor", 4, "C30");
    Kia myKia = new Kia("white", "other manufactor", 4, "Ceed");
    List<Car> cars = List.of(myMazda, myKia);
    cars.forEach(GettMain::printCarInfo);
  }

  public static void printCarInfo(Car car) {
    System.out.println(car);
    car.ride();
  }
}
