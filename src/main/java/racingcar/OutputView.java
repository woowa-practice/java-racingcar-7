package racingcar;


public class OutputView {
    public void printProcess(Car car) {
        System.out.printf(PrintConstants.RACING_PROCESS,car.getName(),"-".repeat(car.getPosition()));
    }

    public void startPrintProcess(){
        System.out.println(PrintConstants.RESULT_START);
    }
}
