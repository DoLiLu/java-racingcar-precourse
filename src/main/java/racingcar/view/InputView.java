package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static Scanner scanner = new Scanner(System.in);

    public static String carsNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int carsRunningCountInput() {
        
        System.out.println("시도할 회수는 몇 회 인가요?");

        try {
            int carsRunningCount = scanner.nextInt();
            scanner.nextLine();
            return carsRunningCount;
        } catch (InputMismatchException inputMismatchException) {
            scanner = new Scanner(System.in);
            System.out.println("시도할 회수는 숫자만 입력 가능합니다.");
            return carsRunningCountInput();
        }
    }

}
