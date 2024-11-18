package racingcar.Utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Utility {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
