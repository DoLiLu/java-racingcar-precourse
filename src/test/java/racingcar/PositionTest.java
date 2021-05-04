package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.entity.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {
    private Position position;
    private int startPosition;

    @BeforeEach
    public void setup() {
        startPosition = 0;
        position = new Position(startPosition);
    }

    @Test
    public void createPosition() {
        assertThat(position.equals(new Position(startPosition))).isTrue();
    }
}
