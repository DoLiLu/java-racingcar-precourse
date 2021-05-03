package racingcar.util;

import java.util.Random;

public class RandomRacingCarMove implements RacingCarMove{
    private static final int RANDOM_NUMBER_RANGE = 10;
    private final Random random = new Random();

    @Override
    public boolean move() {
        return random.nextInt(RANDOM_NUMBER_RANGE) >= 4;
    }
}
