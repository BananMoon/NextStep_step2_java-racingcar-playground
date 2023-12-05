package racingcar;

import java.util.Objects;

/**
 * 포장한 객체
 * - 값에 대한 유효 범위 책임
 */
public class Position {
    private static final int INIT_POSITION = 0;

    private int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    // 값을 반봔하는 것도 필요하다면 반환할 수 있겠음.
    public void move() {
        this.position += 1;
        // immutable object를 위해서는 return new position(position+1)
    }

    public int getPosition() {
        return position;
    }

    public boolean isOver(Position maxPosition) {
        return this.position > maxPosition.getPosition();
    }
}
