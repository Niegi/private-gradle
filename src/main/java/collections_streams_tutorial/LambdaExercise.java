package collections_streams_tutorial;

public class LambdaExercise {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("whatever");
            }
        };

        r = () -> System.out.println("whatever"); // the same as above

        new Thread(() -> System.out.println("another thread")).start();

        MyInterface i = (s1, s2) -> s1+s2;
        System.out.println(i.stringOperation("Tomek", "Romek"));
        print("Tomek", "Romek", (ss1, ss2) -> ss1+ss2);
        print("Tomek", "Romek", (ss1, ss2) -> ss1.toUpperCase()+ss2.toLowerCase());
    }

    static void print(String s1, String s2, MyInterface i) {

        System.out.println(i.stringOperation(s1, s2));
    }
}

@FunctionalInterface
interface MyInterface {
    String stringOperation(String s1, String s2);
}