package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Utils.Validator.validNameForm;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public void init() {
        List<Car> cars = new ArrayList<>();
        try {
            String input = inputView.getInput();
            List<String> names = new ArrayList<>();
            // 형식 검증
            if (validNameForm(input)) {
                names = List.of(input.split(","));
                cars = createCars(names);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
