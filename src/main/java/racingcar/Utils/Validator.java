package racingcar.Utils;

import racingcar.Constant.ErrorConstants;

public class Validator {
    public static boolean validNameForm(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorConstants.EMPTY_INPUT);
        }
        if (!input.matches("[\\w가-힣ㄱ-ㅎㅏ-ㅣ]+(,[\\w가-힣ㄱ-ㅎㅏ-ㅣ]+){0,}")) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_FORM);
        }
        return true;
    }

    public static boolean validNumber(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorConstants.EMPTY_INPUT);
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_NUMBER);
        }
        return true;
    }
}