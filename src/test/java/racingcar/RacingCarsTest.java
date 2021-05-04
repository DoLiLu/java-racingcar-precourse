package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCars;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarsTest {
    private RacingCars racingCars;
    String carNames;

    @BeforeEach
    void setup(){
        carNames = "LEE, JANG, KIM";
        racingCars = new RacingCars("LEE, JANG, KIM");
    }

    @Test
    @DisplayName("경주에 참여할 자동차들 생성")
    public void createRacingCars() {
        assertThat(racingCars.equals(new RacingCars(carNames))).isTrue();
    }
}
