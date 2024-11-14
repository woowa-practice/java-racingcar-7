package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = validNameLength(name);
    }

    private String validNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException(ErrorConstants.OVER_5_LENGTH);
        }
        return name;
    }

}
