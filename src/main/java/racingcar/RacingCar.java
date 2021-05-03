package racingcar;

import java.util.Objects;

public class RacingCar {
    public static String CAR_NAME_VALID_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final String carName;
    private final int carPosition;

    public RacingCar(String carName, int carPosition) {
        validateCarName(carName);
        this.carName = carName;
        this.carPosition = carPosition;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_VALID_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carPosition == racingCar.carPosition && Objects.equals(carName, racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPosition);
    }
}
