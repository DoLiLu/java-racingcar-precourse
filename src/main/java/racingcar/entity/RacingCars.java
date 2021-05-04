package racingcar.entity;

import racingcar.util.Generator;

import java.util.*;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String racingCars) {
        this.racingCars = carNameSplit(racingCars);
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    private List<RacingCar> carNameSplit(String racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = racingCarNames.split(",");

        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName.trim(), 0);
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
        int maxPosition = winnerPosition();

        for (RacingCar racingCar : racingCars) {
            addWinners(winners, maxPosition, racingCar);
        }

        return winners;
    }

    private void addWinners(List<String> winners, int maxPosition, RacingCar racingCar) {
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
