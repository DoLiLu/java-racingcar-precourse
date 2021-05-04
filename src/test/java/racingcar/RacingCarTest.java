package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.Position;
import racingcar.entity.RacingCar;
import racingcar.util.AlwaysMoveGenerator;
import racingcar.util.NoneMoveGenerator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.entity.RacingCar.CAR_NAME_VALID_MESSAGE;
import static racingcar.entity.RacingCars.CAR_START_POINT;

public class RacingCarTest {

    private RacingCar racingCar;
    private Position carPosition;

    @BeforeEach
    void setup(){
        carPosition = new Position(CAR_START_POINT);
        racingCar = new RacingCar("Test", CAR_START_POINT);
    }

    @Test
    @DisplayName("자동차 생성")
    public void createRacingCar() {
        String carName = "Test";

        assertThat(racingCar.equals(new RacingCar(carName, carPosition))).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 Exception 발생")
    void racingCarNameValidFalseThrowException(){
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new RacingCar("carNameLong", CAR_START_POINT))
                .withMessage(CAR_NAME_VALID_MESSAGE);
    }


    @Test
    @DisplayName("자동차 이동")
    public void racingCarMove() {

        racingCar.move(new AlwaysMoveGenerator());

        assertThat(racingCar.isPositionEqual(new Position(1))).isTrue();
    }


    @Test
    @DisplayName("자동차 정지")
    public void racingCarStop() {

        racingCar.move(new NoneMoveGenerator());

        assertThat(racingCar.isPositionEqual(new Position(0))).isTrue();
    }
}
