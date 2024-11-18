package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = validNameLength(name);
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void moveForward() {
        position++;
    }

    private String validNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorConstants.OVER_5_LENGTH);
        }
        return name;
    }

    public void runOrStay(int number) {
        if (number >= 4) {
            moveForward();
        }
    }
}
