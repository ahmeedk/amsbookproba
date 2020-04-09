package bookexos;

import java.util.Random;

public class Examples {

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
}
