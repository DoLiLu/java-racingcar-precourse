package racingcar.entity;

import racingcar.util.Generator;

import java.util.*;

public class RacingCars {
    public static final int CAR_START_POINT = 0;
    private static final String CAR_NAME_SPLIT = ",";

    private final List<RacingCar> racingCars;

    public RacingCars(String racingCars) {
        this.racingCars = carNameSplit(racingCars);
    }

    private List<RacingCar> carNameSplit(String racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = racingCarNames.split(CAR_NAME_SPLIT);

        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName.trim(), CAR_START_POINT);
            racingCars.add(racingCar);
        }

        return racingCars;
    }

    public void race(Generator generator) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(generator);
        }
    }

    public List<String> winners() {
        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            addWinners(winners, racingCar);
        }

        return winners;
    }

    private void addWinners(List<String> winners, RacingCar racingCar) {
        int maxPosition = winnerPosition();

        if (racingCar.carPosition() == maxPosition) {
            winners.add(racingCar.carName());
        }
    }

    private int winnerPosition() {
        int maxPosition = 0;

        for (RacingCar racingCar : racingCars) {
            maxPosition = maxPosition(maxPosition, racingCar);
        }

        return maxPosition;
    }

    private int maxPosition(int maxPosition, RacingCar racingCar) {
        if (racingCar.carPosition() > maxPosition) {
            maxPosition = racingCar.carPosition();
        }
        return maxPosition;
    }

    public List<RacingCar> racingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
