package bookexos;

import java.util.Random;

public class RandomWalk {


    private Random random = new Random();

    public void randomWalkIn1D() {

        int x = 0;
        int journey = 0;

        do {
            x += random.nextBoolean() ? 1 : -1;
            journey += 1;
        } while (x != 0);

        System.out.println("Random walk in 1D,  step of journey = " + journey);
    }

    public void randomWalkIn2D() {
        int x = 0;
        int y = 0;
        int journey = 0;

        do {
            x += random.nextBoolean() ? 1 : -1;
            y += random.nextBoolean() ? 1 : -1;
            journey += 1;
        } while (!(x == 0 && y == 0));

        System.out.println("Random walk in 2D, step of journey = " + journey);
    }

    public void randomWalkIn3D() {
        int x = 0;
        int y = 0;
        int z = 0;
        int journey = 0;

        do {
            x += random.nextBoolean() ? 1 : -1;
            y += random.nextBoolean() ? 1 : -1;
            z += random.nextBoolean() ? 1 : -1;
            journey += 1;
        } while (!(x == 0 && y == 0 && z == 0));

        System.out.println("Random walk in 3D, step of journey = " + journey);
    }
}
