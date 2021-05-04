package racingcar.entity;

import racingcar.util.Generator;

import java.util.Objects;

public class RacingCar {
    public static String CAR_NAME_VALID_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int RACING_CAR_MOVE_POSSIBLE_VALUE = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;
    private Position carPosition;

    public RacingCar(String carName, int carPosition) {
        validateCarName(carName);
        this.carName = carName;
        this.carPosition = new Position(carPosition);
    }

    public RacingCar(String carName, Position carPosition) {
        validateCarName(carName);
        this.carName = carName;
        this.carPosition = carPosition;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_VALID_MESSAGE);
        }
    }

    public void move(Generator generator) {
        if (generator.generate() > RACING_CAR_MOVE_POSSIBLE_VALUE) {
            this.carPosition = carPosition.nextPosition();
        }
    }

    public boolean isPositionEqual(Position position) {
        return carPosition.isPositionEqual(position);
    }

    public Position carPosition() {
        return carPosition;
    }

    public String carName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(carName, racingCar.carName) && Objects.equals(carPosition, racingCar.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPosition);
    }
}
