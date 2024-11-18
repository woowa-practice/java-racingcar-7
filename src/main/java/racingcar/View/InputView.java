package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constant.PrintConstants;

public class InputView {
    public String getNamesInput(){
        System.out.println(PrintConstants.NAMES);
        return Console.readLine();
    }
    public String getTryInput(){
        System.out.println(PrintConstants.TRY);
        return Console.readLine();
    }
}
