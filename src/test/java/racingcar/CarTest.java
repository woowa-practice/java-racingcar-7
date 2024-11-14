package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @ValueSource(strings = {"pobiii","pobi,해은1234","해은1234"})
    @ParameterizedTest
    void 이름이_다섯글자_넘으면_예외를_반환한다(String input){
        assertThrows(IllegalArgumentException.class,()->{
            new Car(input);
        });
    }
}