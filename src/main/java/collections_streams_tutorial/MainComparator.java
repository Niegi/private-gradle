package collections_streams_tutorial;

import java.util.Comparator;
import java.util.function.Function;

public class MainComparator {

    public static void main(String[] args) {

        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2) -> p2.getLastName().compareTo(p1.getLastName());

        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p -> p.getFirstName();
        Function<Person, String> f3 = p -> p.getLastName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(f1);
        cmpPersonAge = Comparator.comparing(Person::getAge); // the same as above

        Comparator<Person> cmpPersonFirstName = Comparator.comparing(f2);
        cmpPersonFirstName = Comparator.comparing(Person::getFirstName);

        Comparator<Person> cmp = cmpPersonAge.thenComparing(cmpPersonFirstName);
    }

}
