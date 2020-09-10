package generic_types;

import java.util.Arrays;

public class GenericTypesMain {

    public static void main(String[] args) {
        Ship<Pirate> pirateShip = new Ship<>();
        pirateShip.add(new Pirate("Tomasz", "Niegowski"));
        System.out.println(pirateShip.findBySurname("Niegowski").cannonShot());

        Ship<Merchant> merchantShip = new Ship<>();
        merchantShip.add(new Merchant("Martynka", "Chomicz"));
        System.out.println(merchantShip.findBySurname("Chomicz").trade(Arrays.asList(1, 2, 3)));
    }

}
