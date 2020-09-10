package generic_types;

import java.util.ArrayList;
import java.util.List;

public class Ship <T extends Mariner> {
    private List<T> crew;

    public Ship() {
        this.crew = new ArrayList<>();
    }

    public void add(T mariner) {
        this.crew.add(mariner);
    }

    public T findBySurname(String surname) {
        return crew.stream().filter(mariner -> mariner.getSurname().equals(surname)).findFirst().get();
    }
}
