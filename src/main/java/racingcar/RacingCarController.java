package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Utils.Validator.validNameForm;
import static racingcar.Utils.Validator.validNumber;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public void init() {
        List<Car> cars = new ArrayList<>();
        try {
            String input = inputView.getNamesInput();
            List<String> names = new ArrayList<>();
            // 형식 검증
            if (validNameForm(input)) {
                names = List.of(input.split(","));
                cars = createCars(names);
            }
            String tryNum = inputView.getTryInput();
            if(validNumber(tryNum)){
                racingStart(cars,Integer.parseInt(tryNum));
            }
            // 게임 수 입력 받기
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void racingStart(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            // 랜덤값 생성
            // 전진
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
