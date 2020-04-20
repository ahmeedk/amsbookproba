package bookexos.discreteproba;

import javafx.util.Pair;

import java.util.Random;

public class ExamplesImpl {

    Random random = new Random();

    public double demere1(int n) {

        int j;
        double nbOfSucces = 0;
        int turnsNb = 0;
        boolean notFound = true;

        for (int i = 1; i < n + 1; i++) {
            int r = random.nextInt(6) + 1;
            j = i % 4;

            if (r == 6) {
                notFound = notFound && false;
            }
            if (j == 3) {
                turnsNb++;
                if (!notFound) {
                    nbOfSucces++;
                }
                notFound = true;
            }
        }
        return nbOfSucces / turnsNb;
    }

    public double demere2(int n) {

        int j;
        double nbOfSucces = 0;
        int turnsNb = 0;
        boolean notFound = true;

        for (int i = 1; i < n + 1; i++) {
            int r1 = random.nextInt(6) + 1;
            int r2 = random.nextInt(6) + 1;
            j = i % 25;

            if (r1 == 6 && r2 == 2) {
                notFound = notFound && false;
            }
            if (j == 24) {
                turnsNb++;
                if (!notFound) {
                    nbOfSucces++;
                }
                notFound = true;
            }
        }
        return nbOfSucces / turnsNb;
    }


    public int[] hTSimulation(int n) {
        int j = 0;
        int k = 0;
        boolean lastWinner;

        int[] resutls = new int[2];

        for (int i = 0; i < n; i++) {

            if (random.nextBoolean()) {
                j++;
                lastWinner = true;
            } else {
                j--;
                lastWinner = false;
            }
            if (j > 0 || (j == 0 && lastWinner)) {
                k++;
            }

        }
        resutls[0] = j;
        resutls[1] = k;

        return resutls;
    }

    public int[][] spikeGraph(int n) {

        int[][] results = new int[n][2];

        for (int i = 0; i < n; i++) {
            results[i][0] = hTSimulation(n)[0];
            results[i][1] = hTSimulation(n)[1];
        }
        return results;
    }


    public int[] hTSimulationPennies(int n) {

        int[] resutls = new int[n];
        resutls[0] = random.nextBoolean() ? 1 : 0;

        for (int i = 1; i < n; i++) {

            if (random.nextBoolean()) {
                resutls[i] = resutls[i - 1] + 1;
            } else {
                resutls[i] = resutls[i - 1] - 1;
            }
        }
        return resutls;
    }
}
