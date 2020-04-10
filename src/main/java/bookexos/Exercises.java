package bookexos;

import java.util.Random;

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

    public boolean playingOneTime() {

        boolean gameOver = false;

        int playerPoints = 0;
        int opponentPoints = 0;

        boolean playerTurn = true;

        while (!gameOver) {

            if (playerTurn) {
                if (random.nextInt(6) == 0) {
                    playerPoints++;
                } else
                    playerTurn = false;

            } else {
                if (random.nextInt(5) == 0) {
                    opponentPoints++;
                } else
                    playerTurn = true;

            }

            if (playerPoints == 21 || opponentPoints == 21)
                gameOver = true;
        }

        return playerPoints == 21;
    }
}
