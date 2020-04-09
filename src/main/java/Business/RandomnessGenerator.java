package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomnessGenerator {

    Random random = new Random();

    public List<Character> generatedCoinToss(int number) {
        List list = new ArrayList();

        for (int i = 0; i < number; i++) {

            if (random.nextBoolean()) {
                list.add('T');
            } else {
                list.add('H');
            }
        }

        return list;
    }
}
