package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    public void start() {
        String carNames = InputView.carsNameInput();
        int carsRunningCount = InputView.carsRunningCountInput();
    }
}
