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
            RacingCar racingCar = new RacingCar(carName.trim(), new Position(CAR_START_POINT));
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
        Position maxPosition = winnerPosition();

        if (racingCar.carPosition().isPositionEqual(maxPosition)) {
            winners.add(racingCar.carName());
        }
    }

    private Position winnerPosition() {
        Position maxPosition = new Position(0);

        for (RacingCar racingCar : racingCars) {
            maxPosition = maxPosition(maxPosition, racingCar.carPosition());
        }

        return maxPosition;
    }

    private Position maxPosition(Position maxPosition, Position carPosition) {
        return maxPosition.maxPosition(carPosition);
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
