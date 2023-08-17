import java.util.List;
import java.util.stream.Collectors;

public class ToDelete {

  public static void main(String[] args) {
    List<String> names = List.of("Tomek", "Martyna", "Wojtek", "Paulina");

    List<String> womanNames = names.stream()
      .filter(s -> s.endsWith("a"))
      .collect(Collectors.toList());

    System.out.println(womanNames);
  }

}
