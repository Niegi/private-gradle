package optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalsMain {
    private List<Book> books;
    public OptionalsMain() {
        init();

        Optional<Book> tomek = books.stream().filter(book -> book.getTitle().equals("Tomek")).findFirst();
        tomek.ifPresentOrElse(b -> System.out.println(b.getTitle()), () -> System.out.println("Book doesn't exist"));

        Optional<Book> notExistExample = books.stream().filter(book -> book.getTitle().equals("whatever")).findFirst();
        notExistExample.ifPresentOrElse(b -> System.out.println(b.getTitle()), () -> System.out.println("Book doesn't exist"));
    }

    public static void main(String[] args) {
        new OptionalsMain();
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book(1, "Tomek"));
        books.add(new Book(2, "Martynka"));
        books.add(new Book(3, "Dorotka"));
    }
}
