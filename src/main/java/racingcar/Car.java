package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;
    private Position newPosition;

    public Car(String carName) {
        if (Objects.isNull(carName) || "".equals(carName)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if (isNameOverFive(carName)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        name = carName;
        this.newPosition = new Position();
    }

    public boolean isNameOverFive(String carName) {
        return carName.length() > 5;
    }

    public void move() {
        newPosition.move();
    }

    public int getPosition() {
        return this.position;
    }
    public Position getNewPosition() {
        return this.newPosition;
    }
    public String getName() {
        return name;
    }
}
