package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCar.CAR_NAME_VALID_MESSAGE;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setup(){
        racingCar = new RacingCar("Test", 0);
    }

    @Test
    @DisplayName("자동차 생성")
    public void createRacingCar() {
        String carName = "Test";
        int carPosition = 0;

        assertThat(racingCar.equals(new RacingCar(carName, carPosition))).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 Exception 발생")
    void racingCarNameValidFalseThrowException(){
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new RacingCar("carNameLong", 0))
                .withMessage(CAR_NAME_VALID_MESSAGE);
    }
}
