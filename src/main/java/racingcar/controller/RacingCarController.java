package racingcar.controller;

import racingcar.entity.RacingCars;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public void start() {

        String carNames = InputView.carsNameInput();
        int carsRunningCount = InputView.carsRunningCountInput();

        RacingCars racingCars = new RacingCars(carNames);
        RandomGenerator generator = new RandomGenerator();

        ResultView.printStart();

        for (int i=0; i < carsRunningCount; i++) {
            racingCars.race(generator);
            ResultView.carPositionPrint(racingCars.racingCars());
        }

        ResultView.printResult(racingCars);

    }
}
