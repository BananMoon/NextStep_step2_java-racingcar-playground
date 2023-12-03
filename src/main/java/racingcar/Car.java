package racingcar;

import jdk.internal.joptsimple.internal.Strings;

public class Car {
    private static final int INIT_POSITION = 1;
    private String name;
    private int position;

    public Car(String carName) {
        if (Strings.isNullOrEmpty(carName) || "".equals(carName)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        name = carName;
        this.position = INIT_POSITION;
    }

    public static boolean isNameOverFive(String name) {
        return name.length() > 5;
    }

    public void move() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }
}
