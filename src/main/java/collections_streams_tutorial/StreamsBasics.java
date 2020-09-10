package collections_streams_tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsBasics {

    public static void main(String[] args) {
        myList.stream()
                .forEach(System.out::println);

        List<String> newList = myList.stream().map(String::toUpperCase).collect(Collectors.toList());

        newList.stream()
                .forEach(System.out::println);
    }

    static List<String> myList = Arrays.asList("Tomek", "Martyna");

}
