package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainTask {

    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>(Arrays.asList(1, 3, 2, 10, 3, 4, 5, 8, 3));
        drawChart(testList);
        fulfillChart(testList);
    }

    private static void drawChart(List<Integer> list) {
        int maxNumber = 0;
        char c = 'X';
        for (int e : list) {
            if (e>maxNumber) {
                maxNumber = e;
            }
        }
        for (int i=maxNumber ; i>0 ; i--) {
            for (int j=0 ; j<list.size() ; j++) {
                if (i-list.get(j) <= 0) {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void fulfillChart(List<Integer> list) {
        int maxNumber = 0;
        for (int e : list) {
            if (e>maxNumber) {
                maxNumber = e;
            }
        }
        boolean [][] chart = new boolean[list.size()][maxNumber];
        for (int i=maxNumber-1 ; i>=0 ; i--) {
            for (int j=0 ; j<list.size() ; j++) {
                if (i-list.get(j) <= 0) {
                    chart[j][i] = true;
                } else {
                    chart[j][i] = false;
                }
            }
        }
    }
}
