package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * position이라는 int 타입의 car 객체의 위치 필드 (원시 값)를 패키징한다. 이를 테스트하는 클래스.
 * - 객체지향원칙과 align하는 TIP.
 *   1. getter를 가능한 쓰지 않는다.
 *   2. 객체 비교 시 값보다는 객체를 비교한다.
 */
public class PositionTest {
    @Test
    void creat() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }
    @Test
    void valid() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Position position = new Position(3);
        position.move();
        assertThat(position).isEqualTo(new Position(4));
    }
}
