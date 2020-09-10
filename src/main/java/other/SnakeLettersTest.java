package other;

import java.util.*;
import java.lang.*;

public class SnakeLettersTest    {
    public static void main (String[] args) {

        ArrayDeque<Letter> letters = new ArrayDeque<>();
        Random theGenerator = new Random();

        for (int n=0; n<50; n++){
            String word = "";
            int x = theGenerator.nextInt(51);
            for (int j=0; j<x; j++){
                word = word + "a";
            }
            letters.add(new Letter(word));
        }

        System.out.println("All words:");
        for (Letter letter : letters) {
            System.out.println(letter.getLetter() + "  , length: " + letter.getLetter().length());
        }
        System.out.println("\n********************************************************************************************\n");

        List<Letter> evens = new ArrayList<>();
        List<Letter> odds = new ArrayList<>();

        Letter.separateOddsFromEvens(letters, odds, evens);

        System.out.println("Odds:");
        for (Letter letter : odds) {
            System.out.println(letter.getLetter() + "  , length: " + letter.getLetter().length());
        }
        System.out.println("\n********************************************************************************************\n");
        System.out.println("Evens:");
        for (Letter letter : evens) {
            System.out.println(letter.getLetter() + "  , length: " + letter.getLetter().length());
        }
    }
}

class Letter {
    private String letter;

    Letter (String letter){
        this.letter = letter;
    }

    public String getLetter(){
        return letter;
    }

    public static void separateOddsFromEvens(ArrayDeque<Letter> arrayDeque, List<Letter> odds, List<Letter> evens) {
        for (Letter letter : arrayDeque) {
            if ((letter.getLetter().length() % 2 == 0)) {
                evens.add(letter);
            } else {
                odds.add(letter);
            }
        }
    }
}