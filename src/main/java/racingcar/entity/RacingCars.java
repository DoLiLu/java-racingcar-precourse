package racingcar.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
