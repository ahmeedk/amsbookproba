package bookexos;

import javax.lang.model.element.UnknownElementException;
import javax.lang.model.type.UnknownTypeException;
import java.util.*;

public class Exercises {

    Random random = new Random();

    public void exercise_3(int n) {

        int sumNine = 0;
        int sumTen = 0;
        for (int i = 0; i < n; i++) {
            int sum = random.nextInt(6) + random.nextInt(6) + random.nextInt(6) + 3;
            if (sum == 9) {
                sumNine++;
            } else if (sum == 10) {
                sumTen++;
            }
        }

        double nineProba = (double) sumNine / n;
        double tenProba = (double) sumTen / n;
        System.out.println(" atfer " + n + " P(sum=9) = " + nineProba + " P(sum=10) = " + tenProba);
    }


    public void exercise_4(int n) {

        int playerWins = 0;

        for (int i = 0; i < n; i++) {

            boolean gameOver = false;

            int playerPoints = 0;
            int opponentPoints = 0;

            boolean playerTurn = true;

            while (!gameOver) {

                if (playerTurn) {
                    if (random.nextDouble() < 0.6) {
                        playerPoints++;
                    } else
                        playerTurn = false;

                } else {
                    if (random.nextDouble() < 0.5) {
                        opponentPoints++;
                    } else
                        playerTurn = true;
                }

                if (playerPoints == 21 || opponentPoints == 21)
                    gameOver = true;
            }

            if (playerPoints == 21) {
                playerWins++;
            }
        }

        double winProba = (double) playerWins / n;
        System.out.println(" simulation of  " + n + " times gives :  P(player wins) = " + winProba);
    }

    public double[][] exercise_5(int n) {

        double[][] f_n = new double[n][2];

        for (int i = 0; i < n; i++) {

            int nbSimulation = 10000;
            double occ = 0;
            for (int j = 0; j < nbSimulation; j++) {

                boolean found = false;
                int k = 0;
                while (k < i) {

                    if (random.nextInt(216) == 0) {
                        found = true;
                    }
                    k++;
                }

                if (found) {
                    occ++;
                }
            }
            f_n[i][0] = i;
            f_n[i][1] = occ / nbSimulation;
        }

        return f_n;
    }

    public void exercise_6(int n) {
        String[] tab = new String[38];
        tab[0] = "0";
        tab[1] = "00";

        for (int i = 2; i < 38; i++) {
            tab[i] = String.valueOf(i - 1);
        }

        int wins = 0;

        for (int i = 0; i < n; i++) {

            int index = random.nextInt(38);
            int value = Integer.parseInt(tab[index]);

            if (value > 0 && value % 2 == 0) {
                wins++;
            } else {
                wins--;
            }
        }

        System.out.println(" after playing " + n + " times, player win : " + wins);
    }

    public void exercise_7(int n) {

        String[] tab = new String[38];
        tab[0] = "0";
        tab[1] = "00";

        for (int i = 2; i < 38; i++) {
            tab[i] = String.valueOf(i - 1);
        }

        int wins = 0;

        for (int i = 0; i < n; i++) {

            int index = random.nextInt(38);
            int value = Integer.parseInt(tab[index]);

            if (value == 17) {
                wins = wins + 35;
            } else {
                wins = wins - 35;
            }
        }

        System.out.println(" after playing " + n + " times, player win : " + wins);
    }

    public void exercise_9() {

        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};


        int win = 0;
        int numberOfTurn = 0;
        while (!list.isEmpty()) {
            int bet = list.get(0) + list.get(list.size() - 1);

            int found = random.nextInt(38);

            if (found > 1 && found % 2 == 0) {
                win += bet;
                list.remove(0);
                if (list.size() > 0)
                    list.remove(list.size() - 1);
            } else {
                win -= bet;
                list.add(bet);
            }
            numberOfTurn++;
        }

        System.out.println(" game finish,  player win :  " + win + " number of turn = " + numberOfTurn);

    }

    public void exercise_10() {

        int win = 0;
        int bet = 1;
        int numberOfTurn = 0;

        while (win < 5 && win > -100) {

            int found = random.nextInt(38);

            if (found > 1 && found % 2 == 0) {
                win += bet;
                bet = 1;
            } else {
                win -= bet;
                bet = 2 * bet;
            }

            numberOfTurn++;
        }
        System.out.println(" game finish,  player win :  " + win + " number of turn = " + numberOfTurn);
    }

    public void exercise_12(int n) {

        double republicanWinPercentage = 0;

        for (int i = 0; i < n; i++) {

            int republicanVoters = 0;
            for (int j = 0; j < 1000; j++) {
                if (random.nextDouble() < 0.49) {
                    republicanVoters++;
                }
            }
            double proba = (double) republicanVoters / 1000;
            republicanWinPercentage = republicanWinPercentage + proba;
            // System.out.println(" republican get : " + republicanVoters + " voters, which is " + proba);
        }
        republicanWinPercentage = republicanWinPercentage / n;
        System.out.println("After " + n + " simulation republican get : " + republicanWinPercentage + " % ");
    }


    public void exercise_13() {

        int largeHospitalNumberOfDay = getNumberOfDayWithMaxBoys(45);
        int smallHospitalNumberOfDay = getNumberOfDayWithMaxBoys(15);

        System.out.println(" number of days with more than 60% boys for large hospital =  " + largeHospitalNumberOfDay);
        System.out.println(" number of days with more than 60% boys for small hospital =  " + smallHospitalNumberOfDay);
    }


    private int getNumberOfDayWithMaxBoys(int nbBabies) {

        int nbDays = 0;
        for (int i = 0; i < 365; i++) {
            double nbBoys = 0;
            for (int j = 0; j < nbBabies; j++) {
                if (random.nextDouble() < 0.5) {
                    nbBoys++;
                }
            }
            double boysPercent = nbBoys / nbBabies;
            if (boysPercent > 0.6) {
                nbDays++;
            }
        }

        return nbDays;
    }

    public double[][] exercise_14(int n) {

        Map<Double, Double> proba = new HashMap<>();

        double totalGain = 0;
        for (int i = 0; i < n; i++) {

            int j = 1;
            while (random.nextBoolean()) {
                j++;
            }
            double gain = Math.pow(2, j);
            totalGain += gain;

            double lastValue = proba.containsKey(gain) ? proba.get(gain) : 0;
            lastValue++;

            proba.put(gain, lastValue);
        }

        double[][] sortedProba = new double[proba.size()][2];
        int i = 0;
        while (!proba.isEmpty()) {
            double min = getKeysMinimun(proba);
            sortedProba[i][0] = min;
            sortedProba[i][1] = proba.remove(min) / n;
            i++;
        }
        totalGain = totalGain / n;

        System.out.println("the mean you win =  " + totalGain);

        return sortedProba;
    }

    private double getKeysMinimun(Map<Double, Double> proba) {

        List keys = Arrays.asList(proba.keySet().toArray());
        double min = (Double) keys.get(0);
        for (Object obj : keys) {
            double v = (Double) obj;
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public double[][] exercise_14_v2(int n, int maxBet) {

        double[][] proba = new double[maxBet][2];

        for (int bet = 2; bet < maxBet; bet++) {

            double numberOfWin = 0;

            for (int i = 0; i < n; i++) {

                int j = 1;
                while (random.nextBoolean()) {
                    j++;
                }

                double gain = Math.pow(2, j) - bet;
                if (gain >= 0) {
                    numberOfWin++;
                }
            }

            proba[bet][0] = bet;
            proba[bet][1] = numberOfWin / n;

        }


        // totalGain = totalGain / n;

        System.out.println("the mean you win =  ");

        return proba;
    }


    public void exercise_16(int n) {

        int sum = 0;

        for (int i = 0; i < n; i++) {

            int j = 0;
            boolean hasBoy;
            boolean hasGirl;

            do {
                hasBoy = random.nextBoolean();
                hasGirl = !random.nextBoolean();
                j += 2;
            } while (!(hasBoy && hasGirl));

            sum += j;
        }

        double mean = sum / n;
        System.out.println("the mean number of children per family = " + mean);
    }

}
