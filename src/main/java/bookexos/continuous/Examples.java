package bookexos.continuous;

import java.util.Random;

public class Examples {

    private Random random = new Random();

    public void estimateArea(int n) {

        double areaPoints = 0;
        for (int i = 0; i < n; i++) {

            double x = random.nextDouble();
            double y = random.nextDouble();

            if (Math.sqrt(y) < x) {
                areaPoints++;
            }
        }

        double e = areaPoints / n;
        System.out.println("Estimated area : " + e);

    }

    public void estimatePiUsingArea(int n) {

        double areaPoints = 0;
        for (int i = 0; i < n; i++) {

            double x = random.nextDouble() - 0.5;
            double y = random.nextDouble() - 0.5;

            double radius = Math.sqrt(x * x + y * y);

            if (radius < 0.5) {
                areaPoints++;
            }
        }

        double pi = 4 * areaPoints / n;
        System.out.println(" Estimated Pi = " + pi);

    }

    public void buffonNeedle(int n) {

        double areaPoints = 0;
        for (int i = 0; i < n; i++) {

            double teta = random.nextDouble() * Math.PI;
            double d = random.nextDouble() / 2;


            if (d < 0.5 * Math.sin(teta)) {
                areaPoints++;
            }
        }

        double pi = 2 / (areaPoints / n);
        System.out.println(" Estimated Pi = " + pi);

    }

    public double[][] sumOfTwoRV(int n) {

        double tab[][] = new double[11][2];

        for (int i = 0; i < 11; i++) {
            tab[i][0] = ((double) (2 * i + 1)) / 11;
            tab[i][1] = 0;
        }

        for (int i = 0; i < n; i++) {
            double value = random.nextDouble() + random.nextDouble();

            for (int j = 0; j < 11; j++) {
                if (Math.abs(tab[j][0] - value) < ((double) 2 / 11))
                    tab[j][1]++;
            }

        }

        for (int j = 0; j < 11; j++) {
            tab[j][1] = tab[j][1] / n;
        }


        return tab;

    }

}
