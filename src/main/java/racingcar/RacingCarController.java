package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Utils.Utility.getRandomNumber;
import static racingcar.Utils.Validator.validNameForm;
import static racingcar.Utils.Validator.validNumber;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public void init() {
        List<Car> cars = new ArrayList<>();
        try {
            String input = inputView.getNamesInput();
            List<String> names;
            // 형식 검증
            if (validNameForm(input)) {
                names = List.of(input.split(","));
                cars = createCars(names);
            }
            String tryNum = inputView.getTryInput();
            if (validNumber(tryNum)) {
                racingStart(cars, Integer.parseInt(tryNum));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void racingStart(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.runOrStay(getRandomNumber());
            }
        }
    }


    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
