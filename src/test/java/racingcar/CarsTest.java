package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("우승자 구하기")
    void findWinners() {
        Car moon = new Car("moon");
        moon.move();
        moon.move();
        Car yoon = new Car("yoon");
        yoon.move();
        yoon.move();
        Car ji = new Car("ji");
        ji.move();
        List<Car> original = Arrays.asList(moon, yoon, ji);
        Cars cars = new Cars(original);
        assertThat(cars.findWinners()).containsExactly(moon, yoon);
    }

}