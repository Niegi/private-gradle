package other;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReferenceMethods {

    public static void main(String[] args) {

        PointFactory<Point1> pointFactory = Point1::new;
        Point1 point1 = pointFactory.createPoint(1, 3);
        System.out.println(point1.a + ", " + point1.b);

        pointFactory = Point2::new;
        Point2 point2 = (Point2) pointFactory.createPoint(1, 3);
        System.out.println(point2.a + ", " + point2.b);

        Predicate<MyPerson> predicate_age = p -> p.age > 20;
        System.out.println(predicate_age.test(new MyPerson("Tomek", "Niegowski", 29)));
        System.out.println(predicate_age.test(new MyPerson("Martyna", "Niegowska", 18)));

        List<MyPerson> myList = new ArrayList<>();
        myList.add(new MyPerson("Tomek", "Niegowski", 29));
        myList.add(new MyPerson("Martyna", "Niegowska", 18));
        List<MyPerson> newList = myList.stream()
                .filter(predicate_age)
                .collect(Collectors.toList());
        System.out.println(newList.toString());

        newList = myList.stream()
                .filter(ReferenceMethods::myTest)
                .collect(Collectors.toList());
        System.out.println(newList.toString());
    }

    static boolean myTest(MyPerson myPerson) {
        return myPerson.name.length() > 5;
    }

}

class Point1 {

    public Point1() {
    }

    public Point1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int a;
    int b;
}

class Point2 extends Point1 {
    public Point2(int a, int b) {
        this.a = 2*a;
        this.b = 2*b;
    }
}

interface PointFactory<P extends Point1> {

    P createPoint(int a, int b);

}

class MyPerson {
    String name;
    String surname;
    int age;

    public MyPerson(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}