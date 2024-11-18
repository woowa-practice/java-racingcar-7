package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Utils.Utility.getRandomNumber;
import static racingcar.Utils.Validator.validNameForm;
import static racingcar.Utils.Validator.validNumber;

public class CarRacingController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void init() {
        try {
            List<Car> cars = ready(inputView.getNamesInput());
            start(cars);
            finish(cars);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void racingStart(List<Car> cars, int tryNum) {
        outputView.startPrintProcess();
        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.runOrStay(getRandomNumber());
                outputView.printProcess(car);
            }
            System.out.print("\n");
        }
    }

    private List<String> whoIsWinner(List<Car> cars) {
        int max_process = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > max_process) {
                max_process = car.getPosition();
                winners = new ArrayList<>(List.of(car.getName()));
                continue;
            }
            if (car.getPosition() == max_process) {
                winners.add(car.getName());
            }
        }
        return winners;
    }


    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<Car> ready(String input) {
        List<Car> cars = new ArrayList<>();
        if (validNameForm(input)) {
            List<String> names = List.of(input.split(","));
            cars = createCars(names);
        }
        return cars;
    }

    private void start(List<Car> cars) {
        String tryNum = inputView.getTryInput();
        if (validNumber(tryNum)) {
            racingStart(cars, Integer.parseInt(tryNum));
        }
    }

    private void finish(List<Car> cars) {
        List<String> winners = whoIsWinner(cars);
        outputView.printWinner(winners);
    }
}
