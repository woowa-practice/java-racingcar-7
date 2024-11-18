package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Utils.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ValueSource(strings = {"pobi,해은,name3", "pobi", "해은"})
    @ParameterizedTest
    void validNameForm(String input){
        assert(Validator.validNameForm(input));
    }

    @ValueSource(strings = {"pobi;해은,name3", "pobi, 해은"})
    @ParameterizedTest
    void 쉼표_외의_다른_특수문자를_포함하면_예외가_발생한다(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validNameForm(input);
        });
    }

    @ValueSource(strings = {"\n", "\t", "\r"})
    @ParameterizedTest
    void 입력이_없으면_예외가_발생한다(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validNameForm(input);
        });
    }

    @ValueSource(strings = {"i", "34ui", "12;"})
    @ParameterizedTest
    void 횟수_입력이_숫자가_아니면_예외가_발생한다(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validNumber(input);
        });
    }
}