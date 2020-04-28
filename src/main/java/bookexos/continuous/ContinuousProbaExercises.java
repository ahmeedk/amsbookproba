package bookexos.continuous;

import java.util.Random;

public class ContinuousProbaExercises {

    Random random = new Random();

    public void exercise_4(int n) {

        double areaPoints = 0;
        for (int i = 0; i < n; i++) {

            double x = random.nextDouble();
            double y = random.nextDouble();

            if (y < Math.sin(x * Math.PI)) {
                areaPoints++;
            }
        }

        double pi = 2 / (areaPoints / n);
        System.out.println(" Estimated Pi = " + pi);
    }

    public void exercise_5(int n) {

        double areaPoints = 0;
        for (int i = 0; i < n; i++) {

            double x = random.nextDouble();
            double y = random.nextDouble();

            if (y < 1 / (1 + x)) {
                areaPoints++;
            }
        }

        double log_2 = areaPoints / n;
        System.out.println(" Estimated log(2) = " + log_2);
    }

    public void exercise_7(int n) {

        double areaPoints = 0;
        for (int i = 0; i < n; i++) {

            double L = 1;
            double teta = random.nextDouble() * Math.PI * 0.5;
            double d1 = random.nextDouble() * L / 2;
            double d2 = random.nextDouble() * L / 2;

            boolean crossLine = d1 < (L / 2) * Math.sin(teta) || d2 < (L / 2) * Math.cos(teta);
            if (crossLine) {
                areaPoints++;
            }
        }

        double pi = 3 / (areaPoints / n);
        System.out.println(" Estimated Pi = " + pi);
    }


    public double[][] exercise_9(int n) {

        double[][] tab = new double[25][2];

        for (int j = 0; j < 25; j++) {
            tab[j][0] = j * 5 + 2.5;
            tab[j][1] = 0;
        }

        for (int i = 0; i < n; i++) {

            double value = -30 * Math.log(random.nextDouble());

            for (int j = 0; j < 25; j++) {
                if (Math.abs(tab[j][0] - value) < 2.5) {
                    tab[j][1]++;
                    //System.out.println("value = " + value);
                    break;
                }
            }
        }

        for (int j = 0; j < 25; j++) {
            tab[j][1] = tab[j][1] / n;
        }

        return tab;

    }

    public double[][] exercise_10(int n) {

        double[][] tab = new double[10][2];

        for (int j = 0; j < 10; j++) {
            tab[j][0] = j * 0.1 + 0.05;
            tab[j][1] = 0;
        }

        for (int i = 0; i < n; i++) {

            double x = random.nextDouble();
            double y = random.nextDouble();

            if (x + y < 1) {

                for (int j = 0; j < 10; j++) {
                    if (Math.abs(tab[j][0] - x) < 0.05) {
                        tab[j][1]++;
                    }
                }
            }
        }

        for (int j = 0; j < 10; j++) {
            tab[j][1] = tab[j][1] / n;
        }

        return tab;
    }


}
