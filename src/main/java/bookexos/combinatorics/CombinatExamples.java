package bookexos.combinatorics;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CombinatExamples {


    private Random random = new Random();

    public int[] randomPermutation(int n) {

        List<Integer> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int[] tab = new int[n];
        int j = 0;
        while (!list.isEmpty()) {
            int a = random.nextInt(list.size());
            tab[j] = list.remove(a);
            j++;
        }

        return tab;
    }

    public double[] fixedPermutation(int n, int times) {

        double[] proba = new double[n];

        for (int i = 0; i < times; i++) {
            int j = 0;

            int[] tab = randomPermutation(n);
            for (int k = 0; k < tab.length; k++) {
                if (tab[k] == k + 1) {
                    j++;
                }
            }

            proba[j]++;

        }

        for (int i = 0; i < n; i++) {
            proba[i] = proba[i] / times;
        }

        return proba;
    }

    public void records(int n, int times) {

        double sum = 0;
        for (int i = 0; i < times; i++) {

            int[] permutation = randomPermutation(n);
            for (int j = 0; j < permutation.length; j++) {
                boolean isRecord = true;
                for (int k = 0; k < j; k++) {
                    if (permutation[k] > permutation[j]) {
                        isRecord = false;
                        break;
                    }
                }
                if (isRecord) {
                    sum++;
                }
            }
        }

        double average = sum / times;
        System.out.println(" the average number of record = " + average);
    }


    public int[][] allPermutations(int n) throws Exception {

        if (n > 6) {
            throw new Exception("Number is too large, can't calculate all permutations");
        }

        int[] t = {1};
        int[][] permutations = getLinePermutations(t, 2);

        if (n == 2) {
            return permutations;
        }

        int j = 3;
        while (j <= n) {
            permutations = permutateMatrix(permutations, j);
            j++;
        }

        return permutations;
    }

    public int[][] permutateMatrix(int[][] tab, int a) {

        int size = tab.length * (tab[1].length + 1);

        int len = tab.length + 1;
        int[][] theTab = new int[size][len];

        int l = 0;
        for (int i = 0; i < tab.length; i++) {

            int[][] t = getLinePermutations(tab[i], a);

            for (int j = 0; j < t.length; j++) {
                theTab[l] = t[j];
                l++;
            }

        }

        return theTab;
    }


    public int[][] getLinePermutations(int[] tab, int a) {

        int len = tab.length + 1;
        int[] newTab = new int[len];
        for (int i = 0; i < tab.length; i++) {
            newTab[i] = tab[i];
        }
        newTab[len - 1] = a;

        int[][] theTab = new int[len][len];

        for (int i = 0; i < theTab.length; i++) {
            theTab[0][i] = newTab[i];
        }

        int k = len - 1;
        while (k > 0) {

            int m = newTab[k - 1];
            newTab[k - 1] = newTab[k];
            newTab[k] = m;

            for (int i = 0; i < theTab.length; i++) {
                theTab[len - k][i] = newTab[i];
            }

            k--;
        }

        return theTab;
    }


}
