package generic_types;

import java.util.List;

public class Merchant extends Mariner {
    public Merchant(String name, String surname) {
        super(name, surname);
    }

    public double trade(List<? extends Number> trades) {
        double sum = 0;
        for (Number trade : trades) {
            sum += trade.doubleValue();
        }
        return sum;
    }
}
