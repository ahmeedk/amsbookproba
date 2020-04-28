package bookexos.continuous;

import java.util.Random;

public class ContinuousDensitiesFunctionExos {


    private Random random = new Random();


    public double[][] exercise_9(int n) {

        double[][] tab = new double[10][2];

        for (int j = 0; j < 10; j++) {
            tab[j][0] = j * 10 + 5 + 100;
            tab[j][1] = 0;
        }

        double lambda = 1.0 / 10;
        double sum = 0;

        for (int i = 10; i < n; i++) {

            double rand = random.nextDouble();
            double value = (-1.0 / lambda) * Math.log(rand);
            sum += value;

            if (value > 100) {
                // System.out.println(" value = " + value);
                for (int j = 0; j < 10; j++) {
                    if (Math.abs(tab[j][0] - value) < 5) {
                        tab[j][1]++;
                    }
                }
            }
        }

        for (int j = 0; j < 10; j++) {
            tab[j][1] = tab[j][1] / n;
        }

        double avg = sum / n;
        System.out.println(" the average value is : " + avg);
        return tab;
    }

    public void exercise_10(int n) {

        double sum = 0;
        for (int i = 10; i < n; i++) {

            double k = 0;
            while (k < 100) {
                k += random.nextDouble() * 10 + 5;
            }

            //double value = random.nextDouble() * 10 + 5;
            sum += k - 100;
        }

        double avg = sum / n;
        System.out.println("The average value is : " + avg);
    }

    public void exercise_11(int n) {

        double sum = 0;
        for (int i = 10; i < n; i++) {
            double k = random.nextDouble() < 0.9 ? 3 : 73;
            sum += k;
        }

        double avg = sum / n;
        System.out.println("The average value is : " + avg);

        double sum_1 = 0;
        for (int i = 10; i < n; i++) {
            double k = 0;
            while (k < 100) {
                k += random.nextDouble() < 0.9 ? 3 : 73;
            }

            sum_1 += k - 100;
        }

        double avg_1 = sum_1 / n;
        System.out.println("Coming after 100 minutes,  the average value is : " + avg_1);
    }

}
