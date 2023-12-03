package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("성공 - 차의 이름은 5글자 초과하지 않는다.")
    void carNameSuccessTest() {
        String carName = "붕붕이";
        Car car = new Car(carName);
        assertThat(car.isNameOverFive(car.getName())).isFalse();
    }

    @Test
    @DisplayName("성공 - 차가 1칸 움직인다.")
    void carMoveTest() {
        String carName = "붕붕이";
        Car car = new Car(carName);
        car.move();
//        assertThat(car.getPosition()).isEqualTo(1);
//        assertThat(car.getPosition()).isEqualTo(1);
        // Position 객체 생성 후 통과 테스트
        assertThat(car.getNewPosition()).isEqualTo(new Position(1));
        assertThat(car.getNewPosition()).isEqualTo(new Position(1));
    }
    @Test
    @DisplayName("움직이는 차는 '-'를 출력한다.")
    void printMovingCarTest() {
        String carName = "붕붕이";
        Car car = new Car(carName);
        car.move();
        car.move();
        IOUtil.printCarMoveStatus(car);
    }

}
