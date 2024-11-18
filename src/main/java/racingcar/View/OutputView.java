package racingcar.View;


import racingcar.Model.Car;
import racingcar.Constant.PrintConstants;

import java.util.List;

public class OutputView {
    public void printProcess(Car car) {
        System.out.printf(PrintConstants.RACING_PROCESS, car.getName(), "-".repeat(car.getPosition()));
    }

    public void startPrintProcess() {
        System.out.println(PrintConstants.RESULT_START);
    }

    public void printWinner(List<String> winners) {
        System.out.println(PrintConstants.WINNER + String.join(",", winners));
    }
}
