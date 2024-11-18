package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Controller.CarRacingController;
import racingcar.Model.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest extends NsTest {
    CarRacingController carRacingController = new CarRacingController();

    @ValueSource(strings = {"pobiii", "pobi,해은1234", "해은1234"})
    @ParameterizedTest
    void 이름이_다섯글자_넘으면_예외를_반환한다(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }

    @Test
    void 랜덤값이_4이상이면_앞으로_전진한다() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    carRacingController.racingStart(java.util.List.of(car), 1);
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                4
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}