package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomValues) {
        if (canMove(randomValues)) {
            position++;
        }
    }

    private boolean canMove(final int randomValues) {
        return randomValues >= MOVE_THRESHOLD;
    }

    public String  getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
