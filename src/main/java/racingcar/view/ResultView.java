package racingcar.view;

import racingcar.entity.RacingCar;
import racingcar.entity.RacingCars;

import java.util.List;

public class ResultView {

    private static final String CAR_POSITION_PRINT_SYMBOL = "-";
    private static final String CAR_PRINT_CONNECT_SYMBOL = " : ";
    private static final String WINNER_NAME_SPLIT_SYMBOL = ",";

    private ResultView() {
    }

    public static void printResult(RacingCars racingCars) {
        printsWinner(racingCars.winners());
    }

    public static void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void carPositionPrint(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.carName() + CAR_PRINT_CONNECT_SYMBOL + carPositionPrintString(racingCar));
        }
        System.out.println();
    }

    private static String carPositionPrintString(RacingCar racingCar) {
        int carPosition = racingCar.carPosition();
        StringBuilder carPositionPrint = new StringBuilder();

        for (int i = 0; i < carPosition; i++) {
            carPositionPrint.append(CAR_POSITION_PRINT_SYMBOL);
        }

        return carPositionPrint.toString();
    }

    public static void printsWinner(List<String> winnerNames) {

        StringBuilder winnerNamesPrint = new StringBuilder();

        for (String winnerName : winnerNames) {
            winnerNamesPrint.append(winnerName);
            winnerNamesPrint.append(WINNER_NAME_SPLIT_SYMBOL);
        }

        System.out.print(winnerNamesPrint.substring(0, winnerNamesPrint.lastIndexOf(WINNER_NAME_SPLIT_SYMBOL)) + " 가 최종 우승했습니다.");
    }


}

